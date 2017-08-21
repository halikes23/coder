package com.cz.coder.web.util;

import javax.servlet.http.HttpServletRequest;

import com.cz.coder.web.dao.entity.vo.privilege.AdminVO;

public class SessionUtil {

	public static AdminVO getLoginUser(HttpServletRequest request){
		return (AdminVO)request.getSession().getAttribute("loginUser") ;
	}
	
}
