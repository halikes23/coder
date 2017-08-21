package com.fq.common.constant.wallet;
/**
 * 用户余额变更变量
 * @author chen.zhao 
 *
 */
public final class UserWalletChangeConstant {
	/**
	 * 变动方向
	 * @author chen.zhao 
	 *
	 */
	public final static class  OP {
		
		/**
		 * 拆红包获得
		 */
		public final static String  OPEN_REDENVELOPE  = "1" ;
		
		/**
		 * 提现减少
		 */
		public final static String  CASH_WITHDRAWAL = "2" ;
		
		/**
		 * 兑换减少
		 */
		public final static String  EXCHANGE_REDUCTION = "3" ;
		
	}
}
