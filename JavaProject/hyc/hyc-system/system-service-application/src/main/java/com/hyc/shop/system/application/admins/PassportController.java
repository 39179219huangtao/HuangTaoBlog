package com.hyc.shop.system.application.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.bo.admin.AdminAuthenticationBO;
import com.hyc.shop.system.dto.admin.AdminAuthenticationDTO;
import com.hyc.shop.system.service.AdminService;
import com.hyc.shop.system.service.OAuth2Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("admins/passport")
@Api("Admin Passport 模块")
public class PassportController {

    /**
     * 登陆总数 Metrics
     */
    private static final Counter METRICS_LOGIN_TOTAL = Metrics.counter("mall.admin.passport.login.total");

    @Reference(validation = "true", version = "${dubbo.provider.OAuth2Service.version}")
    private OAuth2Service oauth2Service;

    @Reference(validation = "true", version = "${dubbo.provider.AdminService.version}")
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "手机号 + 密码登陆")
    public CommonResult<AdminAuthenticationBO> login(AdminAuthenticationDTO adminAuthenticationDTO) {
        // 增加计数
        METRICS_LOGIN_TOTAL.increment();
        // 执行登陆
        return success(adminService.authentication(adminAuthenticationDTO));
    }

    // TODO 功能 logout

    // TODO 功能 refresh_token

}
