package com.cz.coder.common.constant;

import java.util.HashMap;
import java.util.Map;


/**
 * 返回结果
 * 1XXXX 系统级异常
 * 2XXXX 数据格式异常
 * 3XXXX 业务验证异常
 * @author zhen.cheng
 *
 */
public class RetCode {
	
	public final static String KEY_RET_CODE = "code" ;
	public final static String KEY_CODE_MSG = "codeMsg";
//	public final static String KEY_RET_CODE = "Result" ;
//	public final static String KEY_CODE_MSG = "Desc";
private static Map<String,String> msgs = new HashMap<String,String>() ;
	
	private final static Map<String,String> unmodifiableMsgs ;
	
	
	public final static String SUCCESS = "00000" ;//成功
	
	
	// 1XXXX
	public final static String SYSTEM_ERROR = "11111" ;
	public final static String SYSTEM_INIT_ERROR = "10000" ;
	public final static String DATABASE_EXCEPTION = "10001" ;
	
	
	// 2XXXX
	public final static String WRONG_DATE_FORMAT = "20001" ;
	
	// 3XXXX
	public final static String DATA_ERROR = "30000" ;
	public final static String CANNOT_NULL = "30001" ;
	public final static String WRONG_MOBILENUM = "30002" ;
	public final static String ROLE_HAS_EXISTS = "30003" ;
	
	static{
		
		msgs.put( SUCCESS , "成功" ) ;
		msgs.put( SYSTEM_ERROR , "系统异常" ) ;
		msgs.put( SYSTEM_INIT_ERROR , "系统初始化异常" ) ;
		msgs.put( WRONG_DATE_FORMAT , "时间格式错误" ) ;
		msgs.put( CANNOT_NULL , "不能为空" ) ;
		msgs.put( WRONG_MOBILENUM , "验证码错误" ) ;
		msgs.put( DATA_ERROR , "数据错误" ) ;
		msgs.put( ROLE_HAS_EXISTS , "角色已存在" ) ;
		
		unmodifiableMsgs = java.util.Collections.unmodifiableMap( msgs ) ;
		
	}
	/**
	
	 * 根据code 返回对应描述
	 * @param code
	 * @return
	 */
	public final static String RET_CODE_MSG( String code ){
		
		return unmodifiableMsgs.get( code ) ;
		
	}
	
	/**
	 * 生成结果返回MAP
	 * @param code
	 * @return
	 */
	public static Map<String,Object> buildRetCodeResult( String code ){
		Map<String,Object> rst = new HashMap<String,Object>() ;
		rst.put( KEY_RET_CODE , code ) ;
		rst.put( KEY_CODE_MSG , RET_CODE_MSG( code )) ;
		return rst ;
	}
	
}
