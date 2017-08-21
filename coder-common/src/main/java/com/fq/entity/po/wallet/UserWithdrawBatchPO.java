package com.fq.entity.po.wallet;

public class UserWithdrawBatchPO {
	
	private String batchNo ; //提现批次号 （主键）
	
	private String state ; // 状态 ： 1 使用中 ; 2 已过期  ； 3未审批 ; 4 审批中 ; 5 审批未通过 ; 6 待结算  ; 7 结算中 ; 8 结算完成 
	
	private String 	startDt ; // 批次开始日期 
	
	private String 	startTm ; // 批次开始时间 
	
	private String 	endDt ; // 批次结束日期 
	
	private String 	endTm ; // 批次结束时间
	
	private String  checkFailedCnt ; // 审核失败数量
    
	private String  checkFailedAmt ; // 审核失败金额
	                                
	private String 	checkSuccessCnt ; // 审核通过数量
	                                
	private String 	checkSuccessAmt ; // 审核通过金额
	
	
	private String 	redPacketStartDt ; // 开抢红包日期 
	
	private String 	redPacketStartTm ; // 开抢红包时间 
	
	private String  redPacketEndDt ; // 抢红包结束日期 
	
	private String 	redPacketEndTm ; // 抢红包结束时间
	
	
	private String 	withdrawStartDt ; // 提现开始日期 
	
	private String 	withdrawStartTm ; // 提现开始时间 
	
	private String 	withdrawEndDt ; // 提现结束日期 
	
	private String 	withdrawEndTm ; // 提现结束时间


	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	public String getCheckFailedCnt() {
		return checkFailedCnt;
	}

	public void setCheckFailedCnt(String checkFailedCnt) {
		this.checkFailedCnt = checkFailedCnt;
	}

	public String getCheckFailedAmt() {
		return checkFailedAmt;
	}

	public void setCheckFailedAmt(String checkFailedAmt) {
		this.checkFailedAmt = checkFailedAmt;
	}

	public String getCheckSuccessCnt() {
		return checkSuccessCnt;
	}

	public void setCheckSuccessCnt(String checkSuccessCnt) {
		this.checkSuccessCnt = checkSuccessCnt;
	}

	public String getCheckSuccessAmt() {
		return checkSuccessAmt;
	}

	public void setCheckSuccessAmt(String checkSuccessAmt) {
		this.checkSuccessAmt = checkSuccessAmt;
	}

	public String getRedPacketStartDt() {
		return redPacketStartDt;
	}

	public void setRedPacketStartDt(String redPacketStartDt) {
		this.redPacketStartDt = redPacketStartDt;
	}

	public String getRedPacketStartTm() {
		return redPacketStartTm;
	}

	public void setRedPacketStartTm(String redPacketStartTm) {
		this.redPacketStartTm = redPacketStartTm;
	}

	public String getRedPacketEndDt() {
		return redPacketEndDt;
	}

	public void setRedPacketEndDt(String redPacketEndDt) {
		this.redPacketEndDt = redPacketEndDt;
	}

	public String getRedPacketEndTm() {
		return redPacketEndTm;
	}

	public void setRedPacketEndTm(String redPacketEndTm) {
		this.redPacketEndTm = redPacketEndTm;
	}

	public String getWithdrawStartDt() {
		return withdrawStartDt;
	}

	public void setWithdrawStartDt(String withdrawStartDt) {
		this.withdrawStartDt = withdrawStartDt;
	}

	public String getWithdrawStartTm() {
		return withdrawStartTm;
	}

	public void setWithdrawStartTm(String withdrawStartTm) {
		this.withdrawStartTm = withdrawStartTm;
	}

	public String getWithdrawEndDt() {
		return withdrawEndDt;
	}

	public void setWithdrawEndDt(String withdrawEndDt) {
		this.withdrawEndDt = withdrawEndDt;
	}

	public String getWithdrawEndTm() {
		return withdrawEndTm;
	}

	public void setWithdrawEndTm(String withdrawEndTm) {
		this.withdrawEndTm = withdrawEndTm;
	}
	
	
	
}
