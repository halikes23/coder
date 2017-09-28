package com.codepandas.jscalpel.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 录入约束
 * @author 
 * @param password 密码
 * @return boolean m.matches 1:匹配 2：不匹配
 */
public class CheckedUtil {
	// 正则表达式验证密码是否是由6~30位的字母或数字组成
	public static boolean isRight(String password) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{5,30}$");
		Matcher m = p.matcher(password);
		System.out.println(m.matches() + "---");
		return m.matches();
	}
	
	//正则表达式验证手机号码格式是否正确
	public static boolean isMobileNum(String mobileNum){
		Pattern p = Pattern.compile("^\\d{11}$"); 
		Matcher m = p.matcher(mobileNum);
		System.out.println(m.matches()+"---"); 
		return m.matches();  
	}
	

}
