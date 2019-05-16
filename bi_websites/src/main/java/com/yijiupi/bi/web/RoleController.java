package com.yijiupi.bi.web;


import com.alibaba.fastjson.JSONObject;
import com.yijiupi.bi.entity.FrPost;
import com.yijiupi.bi.entity.FrRole;
import com.yijiupi.bi.entity.Role;
import com.yijiupi.bi.kit.AjaxJson;
import com.yijiupi.bi.kit.StrKit;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.service.db1.RoleService;
import com.yijiupi.bi.service.db2.FRPostService;
import com.yijiupi.bi.service.db2.FRRoleService;
import com.yijiupi.bi.service.db2.impl.FRRoleServiceImpl;
import com.yijiupi.bi.utils.HttpClientService;
import com.yijiupi.bi.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@Value("${opUrl}")
	private String opUrl;
	@Autowired
	private HttpClientService httpClientService;
	@Autowired
	private FRPostService frPostService;


	@RequestMapping("/getOpRoleList")
	@ResponseBody
	public Map<String, Object> getOpUserList() {
		String url = opUrl + "/adminUser/userRole/list";
		String result = httpClientService.doGet(url, String.class);
		JSONObject jsonObject = JSONObject.parseObject(result);
		Map<String,String> data = JSONObject.parseObject(jsonObject.get("data").toString(), Map.class);
		List<Map<String,String>> roleList = new ArrayList<>();
		data.entrySet().forEach(x->{
			Map<String,String> map = new HashMap<>();
			map.put("postname",x.getValue());
			map.put("description",x.getKey());
			roleList.add(map);
		});

		Map<String,Object> res = new HashMap<>();
		res.put("rows",roleList);
		res.put("total",roleList.size());

		return res;
	}

	@RequestMapping(value="/syncFineBiRole",method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String,Object> syncFineBiRole(@RequestBody List<FrPost> frPosts){
		System.out.println(frPosts);
		frPostService.syncFineBiPost(frPosts);

		Map<String,Object> res = new HashMap<>();
		res.put("msg","success");
		return res;
	}

	
	@RequestMapping("pageByUserId")
	@ResponseBody
	public EasyUiPage<RoleVo> pageByUserId(String userId, EasyUiPage<RoleVo> page) {
		return roleService.pageByUserId(userId, page);
	}
	
	@RequestMapping("page")
	@ResponseBody
	public EasyUiPage<Role> page(EasyUiPage<Role> page, Role role) {
		roleService.selectPage(page);
		return page;
	}
	
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public AjaxJson saveOrUpdate(Role role){
		boolean flag = false;
		if (StrKit.isEmpty(role.getId())){
			flag = roleService.insert(role);
		}
		else{
			flag =roleService.updateById(role);
		}
		AjaxJson aj = flag ? AjaxJson.success().setData(role) : AjaxJson.failure();
		return aj;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public AjaxJson delete(Role role){
		boolean flag = roleService.deleteById(role.getId());
		AjaxJson aj = flag ? AjaxJson.success().setData(role) : AjaxJson.failure();
		return aj;
	}
	
}
