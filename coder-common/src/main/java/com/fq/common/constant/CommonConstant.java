package com.fq.common.constant;

public class CommonConstant {
	
	public final static String ENCODE_UTF8 = "utf-8" ;
	
	public final static String ENCODE_GBK = "GBK" ;
	
	public static final String REDIS_KEY_RET_CODE = "retCode" ;
	
	/**
	 * 下划线常量
	 */
	public final static String SYMBOL_UNDERLINE = "_" ;
	
	/**
	 * 支付状态  未支付
	 */
	public final static String PMT_STAT_UNPMT = "1" ;
	
	/**
	 * 支付状态  支付成功
	 */
	public final static String PMT_STAT_SUCCESS = "2" ;
	
	/**
	 * 支付状态  支付失败
	 */
	public final static String PMT_STAT_FAIL = "3" ;
	
	public final static String STR_ZERO = "0" ;
	public final static String STR_ONE = "1" ;
	
	public final static String STR_Y = "Y" ;
	public final static String STR_N = "N" ;
	
	public final static String REDIS_COMMAND_SPLIT_SYMBOL = "&SPLIT" ;
	
	/**
	 * 红包默认批次号
	 */
	public final static String RED_PACKET_BATCH_NO_DEFAULT = "00000000000000000000000000" ;
	
	/**
	 * 消息相关常亮
	 */
	public static class NOTIFICATION{
		/**
		 * 通知类型-剧圈/水区消息 评论的回复
		 */
		public final static String NOTIFY_TYPE_SEND_PROJECT_LOG_COMMENT_REPLY_MSG = "1" ;
		/**
		 * 通知类型-提醒收礼消息
		 */
		public final static String NOTIFY_TYPE_APPLY_GIFT = "8" ;
		
		/**
		 * 通知类型-提醒收礼消息
		 */
		public final static String NOTIFY_TYPE_SEND_MSG4THANK = "7" ;
		/**
		 * 通知类型-剧圈/水区消息回复
		 */
		public final static String NOTIFY_TYPE_SEND_PROJECT_LOG_REPLY_MSG = "10" ;
		
		/**
		 * 是否已读-否
		 */
		public final static String IS_READED_NO = "N" ;
		
		/**
		 * 是否已读-是
		 */
		public final static String IS_READED_YES = "Y" ;
	}
	
	public static class GIFT_GIVING{
		/**
		 * 是否已答谢-是
		 */
		public final static String HAVE_REPLY_YES = "Y" ;
		/**
		 * 是否已答谢-否
		 */
		public final static String HAVE_REPLY_NO = "N" ;
	}
	
	public static class REDIS{
		
		public final static String KEY_KEY = "key";
		
		public final static String KEY_FIELD = "field";
		
		public final static String KEY_FIELDS = "fields";
		
		public final static String KEY_VALUE = "value";
		
		public final static String KEY_VALUES = "values";
		
		public final static String KEY_RESULT = "result" ;
		
		public final static String KEY_EX = "ex" ;
		
		public final static String KEY_OK = "OK" ;
		
		public final static String KEY_NXXX = "nxxx" ;
		
		public final static String KEY_NX = "nx" ;
		
		public final static String KEY_XX = "xx" ;
		
		public final static String KEY_FIELDS_AND_VALUES = "fieldsAndValues" ;
		
		public final static String KEY_NEW_VALUE = "newValue" ;
		
		public final static String KEY_LENGTH = "length" ;
		
		public final static String KEY_COUNT = "count" ;
		
		public final static String KEY_LIST = "list" ;
		
		public final static String KEY_MEMBERS = "members";
		
		public final static String KEY_RESPONSES = "responses" ;
		
		public final static String PRE_MDB = "mdb_" ;
		
		public final static String KEY_COMMAND_TYPE = "commandType" ;
		
		public final static String KEY_STIMESTAMP = "stimestamp" ;
		
		public final static String KEY_CLIENT_IP = "clientIp" ;
		
		public final static String KEY_RET_CODE = "retCode" ;
		
		public final static String KEY_START = "start" ;
		
		public final static String KEY_STOP = "stop" ;
		
		public static class COMMAND_TYPE{
			
			public final static String BATCH = "batch" ;
			
			public final static String DEL = "del";
			
			public final static String HMGET = "hmget" ;
			
			public final static String GET = "get" ;
			
			public final static String SET = "set" ;
			
			public final static String LTRIM = "ltrim" ;
			
		}
		 
	}
	
	
}
