package com.fq.common.constant.wallet;

/**
 * 提现常量
 * @author z
 *
 */
public final class UserWithdrawAppConstant {

	/**
	 * 审核状态
	 * @author zhen.cheng
	 *
	 */
	public final static class CHK_STATE{
		
		/**
		 * 待审核
		 */
		public final static String UNCHK = "1";
		
		/**
		 * 审核成功
		 */
		public final static String CHK_SUCCESS = "2";
		
		/**
		 * 审核失败
		 */
		public final static String CHK_FAILED = "3" ;
		
	}
	
	/**
	 * 提现状态
	 * @author zhen.cheng
	 *
	 */
	public final static class TRADE_STATE{
		
		/**
		 * 申请中
		 */
		public final static String APPLYING = "1" ;
		
		/**
		 * 提现中
		 */
		public final static String WIDTHDRAWING = "2" ;
		
		/**
		 * 提现成功
		 */
		public final static String WIDTHDRAW_SUCCESS = "3" ;
		
		/**
		 * 提现失败
		 */
		public final static String WIDTHDRAW_FAIL = "4" ;
		
	}
	
	/**
	 * 发送状态
	 * @author zhen.cheng
	 *
	 */
	public final static class SEND_STATE{
		
		/**
		 * 不发送
		 */
		public final static String DONOT_SEND = "0" ; 
		
		/**
		 * 未发送
		 */
		public final static String UNSEND = "1" ;
		
		/**
		 * 发送成功
		 */
		public final static String SEND_SUCCESS = "2" ;
		
		/**
		 * 发送失败
		 */
		public final static String SEND_FAILED = "3" ;
		
		
	}
	
	/**
	 * 支付渠道
	 * @author zhen.cheng
	 *
	 */
	public final static class CHANNEL_TYPE{
		
		/**
		 * 微信支付
		 */
		public final static String PUB_WX = "1" ;
		
		/**
		 * 支付宝批量支付
		 */
		public final static String ALIPAY_BATCH = "2" ;
		
	}
	
}
