package com.yijiupi.bi.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yijiupi.bi.entity.FrUser;
import com.yijiupi.bi.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yijiupi.bi.config.SessionConst;


/*拦截器,作为登录验证*/
public class LoginRedirectInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		FrUser sessionUser = (FrUser) request.getSession().getAttribute(SessionConst.SESSION_USER);
		if (null == sessionUser){
			response.sendRedirect(request.getContextPath() + "/view/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
