package com.yijiupi.bi.web;


import com.yijiupi.bi.service.db1.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiupi.bi.entity.UserRole;
import com.yijiupi.bi.kit.AjaxJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController{

	@Autowired
	UserRoleService userRoleService;
	
	@RequestMapping("/save")
	@ResponseBody
	public AjaxJson save(String userId) {
		String[] roleIds = getParaValues("roleIds[]");
		userRoleService.deleteByUserId(userId);
		if (null != roleIds) {
			for (String roleId : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(roleId);
				userRoleService.insert(userRole);
			}
		}
		return AjaxJson.success();
	}
	
}
