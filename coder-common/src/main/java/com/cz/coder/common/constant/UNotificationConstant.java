package com.cz.coder.common.constant;

/**
 * 消息相关枚举
 * @author zhen.cheng
 *
 */
public class UNotificationConstant {

	
	/**
	 * 通知类型（1.日志评论的回复 ， 2.评论的回复 ， 3，评论回复的回复，4:系统消息 , 5:追剧消息，  7. 收礼语音回复 ，8，拆礼物提醒收礼消息，9：漫画更新提示，10：反馈回复）
	 * @author zhen.cheng
	 *
	 */
	public class NotifyType{
		
		public final static String PROJECT_LOG_REPLY = "1" ;
		
		public final static String COMMENT_REPLY = "2";
		
		public final static String COMMENT_REPLY_REPLY = "3";
		
		public final static String SYS_NOTIFICATION = "4";
		
		public final static String PROJECT_CHASE = "5";
		
		public final static String GIFT_REPLY = "7";
		
		public final static String GIFT_REMIND = "8";
		
		public final static String LIVE_CARTOON_UPDATE_REMIND = "9";
		
		public final static String FEEDBACK_REPLY = "10";
		
	}
	
	/**
	 * 是否已读（Y: 已读  N: 未读）
	 */
	public class IsReaded{
		
		public final static String YES = "Y" ;
		
		public final static String NO = "N";
		
	}
	
	/**
	 * 客户端类型A:android;I:IOS;BOTH:B
	 */
	public class ClientType{
		
		public final static String ANDROID = "A" ;
		
		public final static String IOS = "I";
		
		public final static String BOTH = "B";
		
	}
	
}
