package com.fq.interceptor;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fq.auth.LoginAuth;
import com.fq.form.login.LoginCheckForm;


public class LoginInterceptor implements HandlerInterceptor {

	private String sessionUser;
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		if(arg2.getClass().isAssignableFrom(HandlerMethod.class))
		{
			LoginAuth authPassPort =((HandlerMethod)arg2).getMethodAnnotation(LoginAuth.class);
			if(authPassPort == null || authPassPort.validate() == false){
				return true;
			}else{
				HttpSession session = arg0.getSession();
				LoginCheckForm log = (LoginCheckForm)session.getAttribute(sessionUser);
				if(log  == null ){
					arg1.sendRedirect(arg0.getContextPath());
					return false;
				}
				@SuppressWarnings("unchecked")
				List<Map<String, String>> auth = (List<Map<String,String>>) session.getAttribute("AUTH");
				if(auth == null ){
					arg1.setCharacterEncoding("UTF-8");
					arg1.getWriter().write("<!doctype html><meta charset=\"utf-8\"><script  type=\"text/javascript\" charset=\"utf-8\">alert('您没有权限.');history.back(-1);</script>");
					return false;
				}
				boolean authFlag = false;
				String reqeustURI = arg0.getRequestURI();
				for(Map<String, String> a : auth ){
						String program = a.get("programurl");
						if(program == null ){
							break;
						}
						if(equlStr(reqeustURI, program)){
							authFlag = true; 
							break;
						}
				}
				if(!authFlag)
				{
					arg1.setCharacterEncoding("UTF-8");
					arg1.getWriter().write("<!doctype html><meta charset=\"utf-8\"><script  type=\"text/javascript\" charset=\"utf-8\">alert('您没有权限.');history.back(-1);</script>");
					return false;
				}
				
				return true;
			}
		}
		else
		{
			return true;
		}
	}

	public String getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}
	private static boolean equlStr (String reqURL , String programURL){
		String[] url = reqURL.split("/");
		String[] purl  = programURL.split("[?]")[0].split("/");
		String p =  "";
		for (int i = url.length - purl.length ; i  < url.length ; i ++){
			p +="/"+url[i];
		}
		programURL = purl[0].startsWith("/")?purl[0]:"/"+purl[0];
		if(programURL.equals(p)){
			return true;
		}else{
			return false;
		}
	}
}
