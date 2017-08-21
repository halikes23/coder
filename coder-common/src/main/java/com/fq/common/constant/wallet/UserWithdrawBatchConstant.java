package com.fq.common.constant.wallet;
/**
 * 提现批次常量
 * @author chen.zhao 
 *
 */

public  final  class  UserWithdrawBatchConstant {
	/**
	 * 批次状态 1:使用中； 2:已过期; 3:未审批； 4:审批中 5:审批未通过 6:待结算 7:结算中 8:结算完成
	 * @author chen.zhao 
	 *
	 */
	public final static class STATE{
		
		/**
		 * 正在使用
		 */
		public final static String IN_USE = "1" ;
		
		/**
		 * 已过期
		 */
		public final static String EXPIRED = "2" ;
		
		/**
		 * 未审批
		 */
		public final static String UNCHECKED = "3" ;
				
		/**
		 * 审核中	
		 */
		public final static String CHECKING = "4" ;
		
		/**
		 * 审核失败
		 */
		public final static String CHECKED_FAILED = "5" ;
		
		/**
		 * 未结算
		 */
		public final static String UNTRANSFER = "6" ;
		
		/**
		 * 结算中
		 */
		public final static String TRANSFERING = "7" ;
		
		/**
		 * 结算成功
		 */
		public final static String TRANSFER_SUCCESS = "8" ;
		
		/**
		 * 结算失败
		 */
		public final static String TRANSFERED_FAILED = "9" ;
		
		/**
		 * 未使用
		 */
		public final static String NOT_USE = "0" ;
	}
}
