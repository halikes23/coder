package com.fq.util;

import javax.servlet.http.HttpServletRequest;

import com.fq.dao.entity.vo.privilege.AdminVO;

public class SessionUtil {

	public static AdminVO getLoginUser(HttpServletRequest request){
		return (AdminVO)request.getSession().getAttribute("loginUser") ;
	}
	
}
