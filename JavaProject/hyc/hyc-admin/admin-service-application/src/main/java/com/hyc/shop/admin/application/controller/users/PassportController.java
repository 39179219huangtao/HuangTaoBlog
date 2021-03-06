package com.hyc.shop.admin.application.controller.users;


import com.hyc.shop.admin.bo.user.UserAuthenticationBO;
import com.hyc.shop.admin.dto.user.UserAuthenticationByMobileCodeDTO;
import com.hyc.shop.admin.service.MobileCodeService;
import com.hyc.shop.admin.service.UserService;
import com.hyc.shop.common.constant.UserTypeEnum;
import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.bo.oauth2.OAuth2AccessTokenBO;
import com.hyc.shop.system.dto.oauth2.OAuth2RefreshTokenDTO;
import com.hyc.shop.system.service.OAuth2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("users/passport")
@Api("Passport 模块")
public class PassportController {

    @Reference(validation = "true", version = "${dubbo.consumer.OAuth2Service.version}")
    private OAuth2Service oauth2Service;
    @Reference(validation = "true", version = "${dubbo.provider.UserService.version}")
    private UserService userService;
    @Reference(validation = "true", version = "${dubbo.provider.MobileCodeService.version}")
    private MobileCodeService mobileCodeService;

    // TODO 功能：手机密码登陆
//    @PostMapping("/mobile/pwd/login")
//    public OAuth2AccessToken mobileLogin(@RequestParam("mobile") String mobile,
//                                         @RequestParam("password") String password) {
//        return oauth2Service.getAccessToken(clientId, clientSecret, mobile, password);
//    }

    @PostMapping("/mobile/register")
    @ApiOperation(value = "手机号 + 验证码登陆（注册）", notes = "如果手机对应的账号不存在，则会自动创建")
    public CommonResult<UserAuthenticationBO> mobileRegister(UserAuthenticationByMobileCodeDTO userAuthenticationByMobileCodeDTO) {
        return success(userService.authenticationByMobileCode(userAuthenticationByMobileCodeDTO));
    }

    @PostMapping("mobile/send_register_code")
    @ApiOperation(value = "发送手机验证码")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, example = "15601691300")
    public CommonResult<Boolean> mobileSend(@RequestParam("mobile") String mobile) {
        mobileCodeService.send(mobile);
        return success(true);
    }

    // TODO 芋艿，改绑手机号

    // TODO 功能：qq 登陆
    @PostMapping("/qq/login")
    public String qqLogin() {
        return null;
    }

    // TODO 功能：qq 绑定
    @PostMapping("/qq/bind")
    public String qqBind() {
        return null;
    }

    @PostMapping("/refresh_token") // TODO 功能：刷新 token
    public CommonResult<OAuth2AccessTokenBO> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return success(oauth2Service.refreshToken(new OAuth2RefreshTokenDTO().setRefreshToken(refreshToken)
                .setUserType(UserTypeEnum.USER.getValue())));
    }

    // TODO 功能：退出，销毁 token
}
