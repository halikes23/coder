package com.fq.entity.po.wallet;


public class UserWithdrawAppPO {

	private Integer uwaId ;
	
	/**
	 * 帐号
	 */
	private String account ;
	
	/**
	 * 提现金额
	 */
	private Integer withdrawAmt ;
	
	/**
	 * 审核状态：1：待审核；2：审核成功；3:审核失败。
	 */
	private String chkState ;
	
	/**
	 * 审核失败缘由
	 */
	private String chkFileMsg ;
	
	/**
	 * 提现状态：1：申请中；2：提现中 3：已提现；4;提现失败;
	 */
	private String tradeState ;
	
	/**
	 * 提现失败原因
	 */
	private String tradeFailMsg ;
	
	/**
	 * 批次号yymmddyymmdd+000001
	 */
	private String batchNo ;
	
	/**
	 * 渠道类型1：微信；2：支付宝；3：银行卡
	 */
	private String channelType ;
	
	private String channelAccount ; 
	
	private String channelName ;
	
	private String clientBrand ;
	
	private String clientChannel ;
	
	private String clientModel ;
	
	private String clientSystemNo ;
	
	private String clientDeviceNo ;
	
	private String clientVersion ;
	
	private String clientIp ;
	
	private String createDt ;
	
	private String createTm ;
	
	private String orderNo ;
	
	private String clientType ; 
	
	private String sendState ; // 发送状态：1：未发送；2：发送成功 ；3：发送失败
	
	private String transfer ; // pingpp支付订单号 

	public Integer getUwaId() {
		return uwaId;
	}

	public void setUwaId(Integer uwaId) {
		this.uwaId = uwaId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getWithdrawAmt() {
		return withdrawAmt;
	}

	public void setWithdrawAmt(Integer withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}

	public String getChkState() {
		return chkState;
	}

	public void setChkState(String chkState) {
		this.chkState = chkState;
	}

	public String getChkFileMsg() {
		return chkFileMsg;
	}

	public void setChkFileMsg(String chkFileMsg) {
		this.chkFileMsg = chkFileMsg;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getTradeFailMsg() {
		return tradeFailMsg;
	}

	public void setTradeFailMsg(String tradeFailMsg) {
		this.tradeFailMsg = tradeFailMsg;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getClientBrand() {
		return clientBrand;
	}

	public void setClientBrand(String clientBrand) {
		this.clientBrand = clientBrand;
	}

	public String getClientChannel() {
		return clientChannel;
	}

	public void setClientChannel(String clientChannel) {
		this.clientChannel = clientChannel;
	}

	public String getClientModel() {
		return clientModel;
	}

	public void setClientModel(String clientModel) {
		this.clientModel = clientModel;
	}

	public String getClientSystemNo() {
		return clientSystemNo;
	}

	public void setClientSystemNo(String clientSystemNo) {
		this.clientSystemNo = clientSystemNo;
	}

	public String getClientDeviceNo() {
		return clientDeviceNo;
	}

	public void setClientDeviceNo(String clientDeviceNo) {
		this.clientDeviceNo = clientDeviceNo;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getCreateTm() {
		return createTm;
	}

	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}

	public String getChannelAccount() {
		return channelAccount;
	}

	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getSendState() {
		return sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	
	
}
