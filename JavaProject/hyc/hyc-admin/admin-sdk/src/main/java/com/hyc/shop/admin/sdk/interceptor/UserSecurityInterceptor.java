package com.hyc.shop.admin.sdk.interceptor;


import com.hyc.shop.admin.sdk.annotation.RequiresLogin;
import com.hyc.shop.admin.sdk.context.UserSecurityContext;
import com.hyc.shop.admin.sdk.context.UserSecurityContextHolder;
import com.hyc.shop.common.constant.UserTypeEnum;
import com.hyc.shop.common.exception.ServiceException;
import com.hyc.shop.common.util.HttpUtil;
import com.hyc.shop.common.util.MallUtil;
import com.hyc.shop.common.util.StringUtil;
import com.hyc.shop.system.bo.oauth2.OAuth2AuthenticationBO;
import com.hyc.shop.system.constant.AdminErrorCodeEnum;
import com.hyc.shop.system.dto.oauth2.OAuth2GetTokenDTO;
import com.hyc.shop.system.service.OAuth2Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User 安全拦截器
 */
@Component
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {

    @Reference(validation = "true", version = "${dubbo.consumer.OAuth2Service.version:1.0.0}")
    private OAuth2Service oauth2Service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置当前访问的用户类型。注意，即使未登陆，我们也认为是用户
        MallUtil.setUserType(request, UserTypeEnum.USER.getValue());

        // 根据 accessToken 获得认证信息，判断是谁
        String accessToken = HttpUtil.obtainAuthorization(request);
        OAuth2AuthenticationBO authentication = null;
        ServiceException serviceException = null;
        if (StringUtil.hasText(accessToken)) {
            try {
                authentication = oauth2Service.getAuthentication(new OAuth2GetTokenDTO().setAccessToken(accessToken)
                        .setUserType(UserTypeEnum.USER.getValue()));
            } catch (ServiceException e) {
                serviceException = e;
            }
        }

        // 进行鉴权
        HandlerMethod method = (HandlerMethod) handler;
        boolean requiresLogin = method.hasMethodAnnotation(RequiresLogin.class);
        if (requiresLogin) { // 如果需要鉴权
            if (serviceException != null) { // 认证失败，抛出上面认证失败的 ServiceException 异常
                throw serviceException;
            }
            if (authentication == null) { // 无认证信息，抛出未登陆 ServiceException 异常
                throw new ServiceException(AdminErrorCodeEnum.OAUTH2_NOT_LOGIN.getCode(), AdminErrorCodeEnum.OAUTH2_NOT_LOGIN.getMessage());
            }
            // TODO 芋艿，后续拓展读取用户信息
        }

        // 鉴权完成，初始化 AdminSecurityContext 上下文
        UserSecurityContext context = new UserSecurityContext();
        UserSecurityContextHolder.setContext(context);
        if (authentication != null) {
            context.setUserId(authentication.getUserId());
            MallUtil.setUserId(request, authentication.getUserId()); // 记录到 request 中，避免 AdminSecurityContext 后续清理掉后，其它地方需要用到 userId
            // TODO 芋艿，后续拓展读取用户信息
        }

        // 返回成功
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 清空 SecurityContext
        UserSecurityContextHolder.clear();
    }

}
