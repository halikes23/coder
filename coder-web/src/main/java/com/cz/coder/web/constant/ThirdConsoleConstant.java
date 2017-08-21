package com.cz.coder.web.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ThirdConsoleConstant {
	
	public final static String KEY_CREATE_DATE = "createDate";
	
	/**
	 * 短信验证按有效期 600s
	 */
	public final static Integer  VALIDITY_OF_MOBILE_CODE = 60*10 ;
	
	
	/**
	 * 是否好友：0否
	 */
	public final static String IS_FRIEND_0 = "0" ;
	/*
	 * cdkey长度
	 */
	public final static Integer CDKEY_LENGTH = 16 ;
	
	public final static String TRUE = "1" ;
	
	public final static String FALSE = "0" ;
	
	/*
	 * 项目排序action
	 */
	public final static String ACTION_USER_LOGIN = "USER_LOGIN"; // 用户登录
	
	public final static String ACTION_COMMENT_PROJECT = "COMMENT_PROJECT"; // 项目评论
	
	public final static String ACTION_COMMENT_REPLY_PROJECT = "COMMENT_REPLY_PROJECT"; // 项目评论回复
	
	public final static String ACTION_COMMENT_PRAISE = "COMMENT_PRAISE"; // 评论点赞
	
	public final static String ACTION_COMMENT_COLLECTION = "COMMENT_COLLECTION"; // 评论收藏
	
	public final static String ACTION_HEAL = "HEAL"; // 项目加血
	
	public final static String ACTION_SEND_REWARD = "SEND_REWARD"; // 项目加血
	
	public final static String ACTION_SHARE = "SHARE"; // 项目分享
	
	public final static String ACTION_MOVIE_PLAY = "MOVIE_PLAY"; // 项目分享
	
	public final static String ACTION_UPLOAD_PROJECT = "UPLOAD_PROJECT"; // 上传项目
	
	public final static String ACTION_UPLOAD_LOG = "UPLOAD_LOG"; // 上传日志
	
	public final static String ACTION_COMMENT_LOG  = "COMMENT_LOG "; // 评论日志
	
	public final static String ACTION_COMMENT_LOG_REPLY  = "COMMENT_LOG_REPLY "; // 回复日志
	
	public final static String ACTION_PRAISE_PROJECT = "PRAISE_PROJECT"; // 项目点赞
	
	public final static String ACTION_SEND_BULLETSCREEN = "SEND_BULLETSCREEN"; // 影片发送弹幕
	
	public final static String ACTION_ADD_MOVIE = "ADD_MOVIE"; // 项目添加影片
	
	public final static String ACTION_UPDATE_PROJECT = "UPDATE_PROJECT"; // 项目修改信息
	
	/**
	 * 时间格式 ： 年月日时分秒
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String date_DatetimeStr = "yyyy-MM-dd HH:mm:ss"; 
	
	/**
	 * 时间格式 ： 年月日时分秒
	 * yyyyMMddHH:mm:ss
	 */
	public final static String date_DatetimeStr2 = "yyyyMMddHHmmss"; 
	
	/**
	 * 时间格式 ： 年月日 
	 * yyyy-MM-dd
	 */
	public final static String date_DateStr1 = "yyyy-MM-dd"; 
	
	/**
	 * 时间格式 ： 年月日 
	 * yyyy-MM-dd
	 */
	public final static String date_DateStr2 = "yyyyMMdd"; 
	
	/**
	 * 时间格式 ： 时分秒
	 * HH:mm:ss
	 */
	public final static String date_TimeStr = "HH:mm:ss";
	
	/**
	 * 默认分页数
	 */
	public final static Integer DEFAULT_PAGE_SIZE = 15 ;
	
	/**
	 * 配置文件路径
	 */
	public final static String CFG_BASE_PATH = "/data/jnwtv/resource/third-console/" ;
	
	public final static Map<String,String> BANNER_TYPE_KEY_NAME_RELS ;
	
	public final static String BANNER_TYPE_MOVIE = "1";
	
	public final static String BANNER_TYPE_URL = "2" ;
	
	public final static String BANNER_TYPE_CARTOON = "4" ;
	
	public final static String BANNER_TYPE_TASKPAGE = "5" ;
	
	public final static String BANNER_TYPE_INVITATIONCODE = "6" ;
	
	public final static String BANNER_TYPE_MOVIE_DISPLAYNAME = "影片";
	
	public final static String BANNER_TYPE_URL_DISPLAYNAME = "外链" ;
	
	public final static String BANNER_TYPE_CARTOON_DISPLAYNAME = "漫画" ;
	
	public final static String BANNER_TYPE_TASKPAGE_DISPLAYNAME = "任务页" ;
	
	public final static String BANNER_TYPE_INVITATIONCODE_DISPLAYNAME = "邀请码" ;
	
	static{
		Map<String,String> temp = new HashMap<String,String>() ;
		
		temp.put(BANNER_TYPE_MOVIE, BANNER_TYPE_MOVIE_DISPLAYNAME) ;
		temp.put(BANNER_TYPE_URL, BANNER_TYPE_URL_DISPLAYNAME) ;
		temp.put(BANNER_TYPE_CARTOON, BANNER_TYPE_CARTOON_DISPLAYNAME) ;
		temp.put(BANNER_TYPE_TASKPAGE, BANNER_TYPE_TASKPAGE_DISPLAYNAME) ;
		temp.put(BANNER_TYPE_TASKPAGE, BANNER_TYPE_INVITATIONCODE_DISPLAYNAME) ;
		
		BANNER_TYPE_KEY_NAME_RELS = Collections.unmodifiableMap(temp) ;
		
	}
	
}
