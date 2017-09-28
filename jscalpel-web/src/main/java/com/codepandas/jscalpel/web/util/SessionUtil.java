package com.codepandas.jscalpel.web.util;

import javax.servlet.http.HttpServletRequest;

import com.codepandas.jscalpel.web.sys.entity.vo.privilege.AdminVO;

public class SessionUtil {

	public static AdminVO getLoginUser(HttpServletRequest request){
		return (AdminVO)request.getSession().getAttribute("loginUser") ;
	}
	
}
