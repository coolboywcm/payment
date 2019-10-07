package com.payment.frame.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.payment.common.Const;
import com.payment.dto.User;
import com.payment.dto.common.Page;

public class UserInfoHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		User user = (User)request.getSession().getAttribute(Const.SESSION_USER);
		Page page = new Page();
		String currentPage = request.getParameter("currentPage");
		String showCount = request.getParameter("showCount");
		if(!StringUtils.isEmpty(currentPage)){
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		if(!StringUtils.isEmpty(showCount)){
			page.setShowCount(Integer.parseInt(showCount));
		}
		page.setUser(user);
		request.setAttribute("page", page);
		return page;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		return arg0.hasParameterAnnotation(com.payment.frame.annotation.SetUserInfo.class) && Page.class.isAssignableFrom(arg0.getParameterType());
	}

}
