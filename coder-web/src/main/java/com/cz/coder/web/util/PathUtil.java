package com.cz.coder.web.util;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {

	public static String getRealPath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
}
