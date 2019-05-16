package com.yijiupi.bi.web.validator.user;

import com.yijiupi.bi.framework.validate.Validate;
import com.yijiupi.bi.framework.validate.Validator;

@Validate
public class UserLoginValidator extends Validator {

	@Override
	protected void validate() {
		validateRequired("username", "please enter your username", "请输入用户名");
		validateRequired("username", "please enter your password", "请输入密码");
	}

}
