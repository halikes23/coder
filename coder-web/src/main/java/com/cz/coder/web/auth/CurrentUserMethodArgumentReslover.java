package com.cz.coder.web.auth;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserMethodArgumentReslover implements HandlerMethodArgumentResolver {

	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		String annoVal = null ;
		if(parameter.getParameterAnnotation(SessionScope.class) != null ){
			annoVal = parameter.getParameterAnnotation(SessionScope.class).value();
		}
		else if (parameter.getMethodAnnotation(SessionScope.class) != null ){
			annoVal = parameter.getMethodAnnotation(SessionScope.class).value() != null ? 
										StringUtils.defaultString(parameter.getMethodAnnotation(SessionScope.class).value()):StringUtils.EMPTY;
		}
		if(webRequest.getAttribute(annoVal,RequestAttributes.SCOPE_SESSION) != null ){
			return webRequest.getAttribute(annoVal, RequestAttributes.SCOPE_SESSION);
		}
		return null;
	}

	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		if(parameter.hasParameterAnnotation(SessionScope.class)) 
		{
			return true;
		}
		
		else if(parameter.getMethodAnnotation(SessionScope.class) != null) 
		{
			return true;
		}
		
		return false;
	}

}
