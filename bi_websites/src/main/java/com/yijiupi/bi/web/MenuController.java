package com.yijiupi.bi.web;


import com.yijiupi.bi.config.SessionConst;
import com.yijiupi.bi.entity.FrUser;
import com.yijiupi.bi.entity.Menu;
import com.yijiupi.bi.entity.Role;
import com.yijiupi.bi.kit.AjaxJson;
import com.yijiupi.bi.kit.StrKit;
import com.yijiupi.bi.service.db1.MenuService;
import com.yijiupi.bi.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	
	@Value("${dev.mode}")
	Boolean devMode;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public AjaxJson saveOrUpdate(Menu menu) {
		boolean flag = false;
		if (StrKit.isEmpty(menu.getId())) {
			flag = menuService.insert(menu);
		} else {
			flag = menuService.updateById(menu);
		}
		AjaxJson rp = flag ? AjaxJson.success() : AjaxJson.failure();
		rp.setData(menu);
		return rp;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public boolean delete(Menu menu) {
		return menuService.deleteById(menu.getId());
	}
	
	@ResponseBody
	@RequestMapping("getAdminMenu")
	public List<MenuVo> getAdminMenu() {
		FrUser sessionUser = getSessionAttr(SessionConst.SESSION_USER);
		List<MenuVo> adminMenu;
		if (devMode) {
			adminMenu = menuService.getAllMenu();
		} else {
			adminMenu = menuService.getAdminMenu(String.valueOf(sessionUser.getId()));
		}
		setSessionAttr(SessionConst.SESSION_MENU, adminMenu);
		return adminMenu;
	}
	
	@RequestMapping("renderAsyncTree")
	@ResponseBody
	public List<MenuVo> renderAsyncTree(String id) {
		List<MenuVo> menu;
		if (StrKit.isEmpty(id)) {
			menu = menuService.getFirstDegree();
		} else {
			menu = menuService.getByParentId(id);
		}
		initTreeValue(menu);
		return menu;
	}
	
	private void initTreeValue(List<MenuVo> records) {
		for (MenuVo record : records) {
			record.setState(menuService.hasChild(record) ? "closed" : "open");
		}
	}
	
	@RequestMapping("renderRoleMenuTree")
	@ResponseBody
	public List<MenuVo> renderRoleMenuTree(Role role) {
		List<MenuVo> records = menuService.renderRoleMenuTree(role.getId(), null);
		return records;
	}
	
	@RequestMapping("initRoleMenu")
	@ResponseBody
	public AjaxJson initRoleMenu(String roleId) {
		String[] menuIds = getParaValues("menuIds[]");
		AjaxJson rp = menuService.initRoleMenu(roleId, menuIds) ? AjaxJson.success() : AjaxJson.failure();
		return rp;
	}
	
}
