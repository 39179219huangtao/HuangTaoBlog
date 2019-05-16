package com.yijiupi.bi.web.validator.user;

import com.yijiupi.bi.entity.User;
import com.yijiupi.bi.framework.validate.Validate;
import com.yijiupi.bi.framework.validate.Validator;
import com.yijiupi.bi.service.db1.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Validate
public class UserSaveValidator extends Validator {

	@Autowired
	UserService userService;
	
	@Override
	protected void validate() {
		validateRequired("username", "please enter username", "请输入用户名");
		validateRequired("password", "please enter password", "请输入密码");
		User user = controller.bean(User.class);
		if (userService.getCountByEqual(user, "username") > 0) {
			addError("username already exists", "用户名已经存在");
		}
	}

}
