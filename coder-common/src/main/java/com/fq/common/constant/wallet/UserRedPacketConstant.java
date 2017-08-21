package com.fq.common.constant.wallet;
/**
 * 用户红包对象实体类
 * @author chen.zhao 
 *
 */
public final  class UserRedPacketConstant {
	/**
	 * 使用类型
	 * @author chen.zhao 
	 *
	 */
	public final static class  USED_STATE {
		
		/**
		 * 不可用
		 */
		public final static String  NOT_AVAILABLE  = "0" ;
		
		/**
		 * 已使用
		 */
		public final static String  ON_USE = "1" ;
		/**
		 * 可用未使用
		 */
		public final static String  NO_USE = "2" ;
		
		/**
		 * 未到期
		 */
		public final static String UNEXPIRED  = "3" ;
		
	}
	
	/**
	 * 红包获取方式
	 * @author chen.zhao 
	 *
	 */
	public final static class ACCESS_WAY {
			
		/**
		 * 邀请好友
		 */
		public final static String  INVITE_FRIENDS = "１" ;
		
		/**
		 * 被邀请
		 */
		public final static String  BE_INVITED = "2" ;
			
		}
	
	
}
