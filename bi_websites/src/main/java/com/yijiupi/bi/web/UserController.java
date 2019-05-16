package com.yijiupi.bi.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yijiupi.bi.config.SessionConst;
import com.yijiupi.bi.dto.AdminUser;
import com.yijiupi.bi.dto.JiupiCity;
import com.yijiupi.bi.dto.UserQueryDTO;
import com.yijiupi.bi.entity.FrUser;
import com.yijiupi.bi.entity.User;
import com.yijiupi.bi.framework.validate.JsonValidate;
import com.yijiupi.bi.kit.AjaxJson;
import com.yijiupi.bi.kit.StrKit;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.service.SyncService;
import com.yijiupi.bi.service.db1.UserService;
import com.yijiupi.bi.service.db2.FRDepartmentService;
import com.yijiupi.bi.service.db2.FRUserService;
import com.yijiupi.bi.utils.BaseResult;
import com.yijiupi.bi.utils.HttpClientService;
import com.yijiupi.bi.web.validator.user.UserLoginValidator;
import com.yijiupi.bi.web.validator.user.UserSaveValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @Autowired
    FRDepartmentService frDepartmentService;

    @Autowired
    FRUserService frUserService;

    @Autowired
    SyncService syncService;

    @Value("${opUrl}")
    private String opUrl;

    @Autowired
    private HttpClientService httpClientService;

    @RequestMapping("/getOpUserList")
    @ResponseBody
    public JSONObject getOpUserList(UserQueryDTO user, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows) {
        String url = opUrl + "/adminUser/list";

        user.setCurrentPage(page);
        user.setPageSize(rows);
        //所有启用的用户才被查出来
        user.setState(1);
        Map<String, Object> params = user.translateToMap();
        String adminUser = httpClientService.doPost(url, params, String.class);

        JSONObject result = JSON.parseObject(adminUser);
        JSONObject data = result.getJSONObject("data");
        JSONArray dataList = data.getJSONArray("dataList");

        List<AdminUser> adminUserList = Lists.newArrayList();
        dataList.forEach(e -> {
            AdminUser adminUser1 = JSONObject.parseObject(JSON.toJSONString(e), AdminUser.class);

            adminUserList.add(adminUser1);
        });

        JSONObject pager = data.getJSONObject("pager");
        JSONObject datagrid = new JSONObject();
        datagrid.put("rows", adminUserList);
        datagrid.put("total", pager.getIntValue("recordCount"));
        datagrid.put("pages", pager.getIntValue("totalPage"));
        datagrid.put("current", pager.getIntValue("currentPage"));
        datagrid.put("size", pager.getIntValue("pageSize"));
        System.out.println(adminUser);
        return datagrid;
    }

    @RequestMapping("/getFrUserList")
    @ResponseBody
    public EasyUiPage<FrUser> getFrUserList(EasyUiPage<FrUser> pageInfo, FrUser frUser) {
        return frUserService.getFrUserList(pageInfo, frUser, "like:username", "like:realname","like:mobile");
    }

    @RequestMapping("/getCityList")
    @ResponseBody
    public JSONObject getCityList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows) {
        String url = opUrl + "/adminUser/allJiupiCity/list";

        String adminUser = httpClientService.doGet(url, String.class);
        System.out.println(adminUser);
        JSONObject result = JSON.parseObject(adminUser);
        JSONArray dataList = result.getJSONArray("data");
        JSONObject datagrid = new JSONObject();
        datagrid.put("rows", dataList);
        return datagrid;
    }

    @ResponseBody
    @RequestMapping("syncFineBiAllUser")
    public BaseResult resetCache() {
        try {
            syncService.syncAllUser();
            return BaseResult.getSuccessResult();
        } catch (Exception ex) {
            return BaseResult.getFailedResult(ex.getMessage());
        }
    }

    @RequestMapping(value = "syncFineBiUser", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public BaseResult syncFineBiUser(@RequestBody List<AdminUser> adminUsers) {

        log.info("adminUsers:{}", JSON.toJSONString(adminUsers));
        frUserService.syncUser(adminUsers);
        frUserService.syncUserDepartmentPos(adminUsers);
        return BaseResult.getSuccessResult();
    }

    @RequestMapping(value = "syncFineBiDepartment", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public BaseResult syncFineBiDepartment(@RequestBody List<JiupiCity> jiupiCities) {
        log.info("jiupiCities:{}", JSON.toJSONString(jiupiCities));
        frDepartmentService.syncUserDepartment(jiupiCities);
        return BaseResult.getSuccessResult();
    }


    @RequestMapping("/login")
    @ResponseBody
    @JsonValidate(UserLoginValidator.class)
    public AjaxJson login(FrUser frUser) {

        String url = opUrl + "/adminUser/login";


        FrUser dbUser = frUserService.getFrUser(frUser, "username");
        if (null == dbUser) {
            return AjaxJson.failure().setMsg("用户不存在，或密码错误");
        } else {
            Map<String, Object> params = Maps.newHashMap();
            params.put("account", frUser.getUsername());
            params.put("password", frUser.getPassword());
            String adminUserString = httpClientService.doPost(url, params, String.class);
            JSONObject result = JSON.parseObject(adminUserString);

            boolean success = result.getBooleanValue("success");

            AdminUser data = result.getObject("data", AdminUser.class);
            if (!success) {
                return AjaxJson.failure().setMsg("用户不存在，或密码错误");
            } else {
//                frUser.setId(dbUser.getId());
//                frUserService.syncUser(Lists.newArrayList(data));
//                frUserService.syncUserDepartmentPos(Lists.newArrayList(data));
//                frUserService.updateFrUserById(frUser);
            }
            setSessionAttr(SessionConst.SESSION_MENU, null);
            setSessionAttr(SessionConst.SESSION_USER, dbUser);
            return AjaxJson.success().setMsg("登陆成功");
        }


    }

    @RequestMapping("/page")
    @ResponseBody
    public EasyUiPage<User> page(EasyUiPage<User> pageInfo, User user) {
        return userService.pageByDynamicEqual(pageInfo, user, "username", "realname");
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxJson update(User user) {
        user.setUsername(null);
        user.setPassword(null);
        Boolean result = userService.updateById(user);
        return result ? AjaxJson.success().setData(user) : AjaxJson.failure();
    }

    @RequestMapping("/save")
    @ResponseBody
    @JsonValidate(UserSaveValidator.class)
    public AjaxJson save(User user) {
        Boolean result = userService.insert(user);
        return result ? AjaxJson.success().setData(user) : AjaxJson.failure();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxJson delete(User user) {
        Boolean result = userService.deleteById(user.getId());
        return result ? AjaxJson.success() : AjaxJson.failure();
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public AjaxJson updatePwd(String oldPassword, String newPassword) {
        User user = getSessionAttr(SessionConst.SESSION_USER);
        if (!StrKit.MD5(oldPassword).equals(user.getPassword())) {
            return AjaxJson.failure().setMsg("输入密码有误");
        } else {
            user.setPassword(StrKit.MD5(newPassword));
            userService.updateById(user);
            setSessionAttr(SessionConst.SESSION_USER, user);
            return AjaxJson.success();
        }
    }

    @RequestMapping("getSessionUser")
    @ResponseBody
    public AjaxJson getSessionUser() {
        FrUser user = getSessionAttr(SessionConst.SESSION_USER);
        if (null != user) {
            //不能泄露密码，但也不能改原对象的属性
            user = (FrUser)user.clone();
            user.setPassword("");
            return AjaxJson.success().setData(user);
        }
        return AjaxJson.failure();
    }

    @RequestMapping("/logout")
    public String logout() {
        getSession().invalidate();
        return "redirect:/";
    }

}
