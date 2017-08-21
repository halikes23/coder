package com.cz.coder.web.common.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	private final static String NAME= "康复宝";
	/**
	 * 
	 * @Title: isNull 
	 * @Description: 验证是否为null或者是否为空格，若是返回true,否则返回false
	 * @param @param str
	 * @param @return    设定文件  
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean isNull (String str){
		return str==null || "".equals(str.trim());
	}
	
	public static String join( List<?> objs , String splitSymbol , String left , String right ){
		
		StringBuilder rst = new StringBuilder() ;
		
		for( int i = 0 ; i < objs.size() ; i ++ ){
			if( i != 0 ){
				rst.append( splitSymbol ) ;
			}
			rst.append( left ).append( objs.get( i ) ).append( right ) ;
			
		}
		
		
		return rst.toString() ;
	}
	/**
	 * 
	 * @Title: randomStr 
	 * @Description: 生成随机字符串
	 * @param @param len
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String randomStr ( int len )
	{
		if (len == 0)
		{
			return "";
		}
		/* int a = (int) ( Math.random () * 2 );
		if (a == 0)
		{
			return ( (int) ( Math.random () * 10 ) ) + randomStr (len - 1);
		}
		else if (a == 1)
		{
			return ( (char) ( (int) ( Math.random () * 26 ) + 65 ) ) + randomStr (len - 1);
		}
		else
		{
			return ( (char) ( (int) ( Math.random () * 26 ) + 65 ) ) + randomStr (len - 1);
		} */
		return ( (char) ( (int) ( Math.random () * 26 ) + 65 ) ) + randomStr (len - 1);
	}

	
	
	
	/**
	 * 
	* 函数功能说明 截取字符串长度
	* jingkun.chen 2015-8-27 
	* @参数：@param str
	* @参数：@return 
	* @return String
	 */
	
	public static  String  subString(String str  , int len){
		if (str.length() > len ) {
			return str.substring(0, len);
		}else {
			return str;
		}
		
	}
	
	
	
	
	/**
	 * 
	* 函数功能说明  验证用户名是否合法
	* jingkun.chen 2015-8-27 
	* @参数：@param str
	* @参数：@return 
	* @return boolean
	 */
	public static boolean  nameRulers(String str){
		return str.replaceAll(" ", "").contains(NAME);
	}
	public static String getBatchNo( Integer jPoint , String adminName){
		
		return  System.currentTimeMillis() / 1000L + adminName + jPoint ;
	} 
	
	
	public static void main(String[] args){
		
	List<String> lst = new ArrayList<String>() ;
		
		lst.add( "a" ) ;
		lst.add( "b" ) ;
		
		String rst= StringUtils.join( lst , ",", "'", "'") ;
		System.out.println( rst );
		
		String aa = "18860361620";
		subString( aa , 3) ;
		System.out.println(subString( aa , 3) );
		System.out.println ("随机数" +randomStr (16));
		
	}
	
	public static boolean equals(String str1 , String str2){
		return org.apache.commons.lang.StringUtils.equals(str1, str2) ;
	}
	
}
