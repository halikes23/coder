package com.cz.coder.web.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserUtil {

	 
	private static String[] clientModelA = { "4.3.1" , "x86_64" , "4.4.2" , "6.0" , "10.1.0", "10.2.0" , "6.7.0" , "7.3.0" , "5.0.2" , "6.0",
		"5.1" } ; 
	private static String[] clientModelI = { "iPhone 5s" , "iPhone 6" , "iPhone 5" , "iPhone 6s" , "iPhone 7", "iPhone 7P" , "iPhone 6P" , "iPhone 6sP" } ; 
	private static Integer[] sex = { 1 , 0 } ; 
	
	private static String[] clientChannel = {"JNWTV" , "IPHONE" } ; 
	
	private static String[] clientBrand = { "YOUYI_MARKET" , "LE_MARKET" , "XIAOMI_PLATFORM" , "SECURITYASSISTANT_360" , "YINGYONGBAO" , 
				"JNWTV" , "VIVO" , "OPPO" , "MEIZU" , "JINLI" , "SAMSUNG", "WANGXIA" , "HUAWEI" ,  "DIANXIN_TIANYI" , "YAMAXUN" , 
				"SHOUJIZHUSHOU_2345" } ; 
	private static Integer[] rewardCoupon = { 100 , 200 , 300 } ;  
	
	public static String getClientType(){
		Random rd = new Random() ; 
		if (rd.nextInt(10) >=8  ) {
			return "I" ;
		}
		return "A" ;
	}
	/**
	 * 
	 * @Title: getClientModel 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 
	 * @param @param clientType
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String getClientModel( String clientType ){
		if ( org.apache.commons.lang.StringUtils.equals( "I", clientType )) {
			List<String > clientModelList = Arrays.asList(clientModelI) ; 
			return clientModelList.get( (int)(Math.random()*clientModelList.size())) ; 
		}else {
			List<String > clientModelList = Arrays.asList(clientModelA) ; 
			return clientModelList.get( (int)(Math.random()*clientModelList.size())) ; 
		}
		
		
	}
	public static String getClientBrand( String clientType ){
		if ( org.apache.commons.lang.StringUtils.equals( "I", clientType )) {
			return "iPHONE" ; 
		}
		List<String > clientBrandList = Arrays.asList(clientBrand) ; 
 		return clientBrandList.get( (int)(Math.random()*clientBrandList.size())) ;
	}
	
	public static String getClientChannel( String clientType ){
		if ( org.apache.commons.lang.StringUtils.equals( "I", clientType )) {
			return "IPHONE" ; 
		}
		Random rd = new Random() ; 
		if (rd.nextInt(10) >=5  ) {
			return "JNWTV" ;
		}
		List<String > clientChannelList = Arrays.asList(clientChannel) ; 
 		return clientChannelList.get( (int)(Math.random()*clientChannelList.size())) ;
	}
	
	
	
	/**
	 * 
	 * @Title: getUserThirdType 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 三方渠道1：wx；3：qq
	 * @param @return    设定文件  
	 * @return int    返回类型
	 */
	public static int getUserThirdType(){
		Random rd = new Random() ; 
		if (rd.nextInt(10) >=6  ) {
			return 3 ;
		}
		return 1 ; 
	}
	/**
	 * 
	 * @Title: getUserJpoint 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description:剧点
	 * @param @return    设定文件  
	 * @return int    返回类型
	 */
	public static int getUserJpoint(){
		Random rd = new Random() ; 
		return rd.nextInt(100) ; 
	}
	
	/**
	 * 
	 * @Title: getUserCoupon 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 获取代金券
	 * @param @return    设定文件  
	 * @return int    返回类型
	 */
	public static int getUserCoupon(){
		Random rd = new Random() ; 
		return rd.nextInt(300) ; 
	}
	/**
	 * 
	 * @Title: getUserNum 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 用户量
	 * @param @param num
	 * @param @return    设定文件  
	 * @return int    返回类型
	 */
	public static int getUserNum(int num){
		Random rd = new Random() ; 
		return num+rd.nextInt(300) ; 
	}
	
	/** 
	 * 生成随即密码 
	 * @param pwd_len 生成的密码的总长度 
	 * @return  密码的字符串 
	 */  
	public static String genRandomNum( int pwd_len){  
		// 10个数字  
		final int  maxNum = 10;  
		int i;  //生成的随机数  
		int count = 0; //生成的密码的长度  
		char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
		StringBuffer pwd = new StringBuffer("");  
		Random r = new Random();  
		while(count < pwd_len){  
			//生成随机数，取绝对值，防止生成负数，  
			i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1  
			if (i >= 0 && i < str.length) {  
				pwd.append(str[i]);  
				count ++;  
			}  
		}  
		return pwd.toString();  
	}
	/**
	 * 
	 * @Title: getSex 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 性别
	 * @param @return    设定文件  
	 * @return Integer    返回类型
	 */
	public static Integer getSex(){
		List<Integer> sexList = Arrays.asList(sex) ; 
		return sexList.get((int)(Math.random()*sexList.size())) ;
	}
	/**
	 * 
	 * @Title: getWriteDate 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 获取注册时间
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String getWriteDate( String date){
		Random rd = new Random() ; 
		long time = Long.parseLong( DateFormatUtil.date2TimeStamp(date, null)) ;
		time-= rd.nextInt(100) ; 
		
		return DateFormatUtil.timeStamp2Date( String.valueOf( time) , null ) ;
	}

	public static int getUserRewward(){
		List<Integer > rewardCouponList = Arrays.asList( rewardCoupon ) ; 
		return rewardCouponList.get( (int)(Math.random()*rewardCouponList.size())) ; 
	}
	
	public static  int  getLoginReward(int a , int b){
		return (int)(a+Math.random()*(b-a+1));
	}
	private final static int delta = 0x9fa5 - 0x4e00 + 1 ; 
	public static String randomHan(int j ){
		Random rd = new Random() ; 
		StringBuilder builder = new StringBuilder() ; 
		for (int i = 0; i < j; i++) {
			builder.append( ((char)(0x4e00 + rd.nextInt(delta))) ); 
		}
		return  builder.toString() ; 
		
		
	}
	
	public static void main(String[] args) {
		
		for (int i = 10; i < 100; i++) {
//			System.out.println(getUserOpenId(0));
			System.out.println(getClientType());
			// System.out.println(getWriteDate("2016-10-22 10:22:32"));
			// System.out.println( addressList.get((int)(Math.random()*addressList.size())) );
		}
//		System.out.println(getFixLenthString(10));
//		System.out.println(genRandomNum(9));
	
	}
	
}




