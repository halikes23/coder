package com.cz.coder.web.properties;

import java.util.Properties;

import com.cz.coder.web.constant.ThirdConsoleConstant;
import com.fq.util.ConfigUtil;

public class GlobalProperties {

	public final static String SMS_USERNAME   ; // 账户
	public final static String SMS_PSD   ; // 密码
	public final static String SMS_URL  ; // 短息请求链接
//	public final static String SMS_MSG_REGISTER  ; // 用户注册
//	public final static String SMS_MSG_RESETPWD  ; // 重置密码
//	public final static String SMS_MSG_CONSOLE  ; // 管理台登录
	public final static String SMS_MSG_REGISTER = "是您本次注册的验证码，如非您本人操作请及时修改密码。" ; // 用户注册
	public final static String SMS_MSG_RESETPWD  = "是您本次重置密码的验证码，如非您本人操作请及时修改密码。"; // 重置密码
	public final static String SMS_MSG_CONSOLE = "是您验证码，欢迎使用剧能玩操作台。" ; // 管理台登录
	public final static String IS_DEBUG ;
	public final static String QINIU_RESOURCE_BASE_DIR ;
	public final static String SERVERS ;//
	
	public final static String SYSTEM_HELPER ; // 系统助手账号
	public final static String SYSTEM_FEEDBACK_REPLIER ; // 返回回复账号
	public final static String appId = "app_X5KSyHubbXbDCuPW";
			
    // 你生成的私钥路径
	public final static String PINGPP_PUBLIC_KEY_FILE_PATH = "/data/jnwtv/resource/schedule/rsa_public_key.pem";
	public final static String PINGPP_PRIVATE_KEY_FILE_PATH = "/data/jnwtv/resource/schedule/rsa_private_key.pem";
	public static String PINGPP_API_KEY_LIVE =  "sk_live_HWzzzHKKuzv99COKqHqX94uP" ; // pingppapikey
	public static String PINGPP_API_KEY_TEST =  "sk_test_Kq1GyHirDCm9SqH8W1Ca9af5" ; // pingppapikey
	
	static{
		Properties prop = ConfigUtil.readProperty( ThirdConsoleConstant.CFG_BASE_PATH +"Global.properties" ) ;
		String isDebug = null ;
		try{
			isDebug = prop.getProperty("Global.IS_DEBUG").toString() ;
		}catch(Exception e){
			isDebug = "0" ;
		}
		IS_DEBUG = isDebug ; 
		
		SMS_USERNAME = prop.getProperty("Global.SMS_USERNAME").toString();
		SMS_PSD = prop.getProperty("Global.SMS_PSD").toString();
		SMS_URL = prop.getProperty("Global.SMS_URL").toString();
		QINIU_RESOURCE_BASE_DIR = prop.getProperty("Global.QINIU_RESOURCE_BASE_DIR") ;
		SERVERS = prop.getProperty("Global.SERVERS");
		SYSTEM_HELPER = prop.getProperty("Global.SYSTEM_HELPER") ;
		SYSTEM_FEEDBACK_REPLIER= prop.getProperty("Global.SYSTEM_FEEDBACK_REPLIER") ;
		
	}
	
}
