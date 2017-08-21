package com.fq.entity.po.pingpp;

public class TpTradePingppAppPO {
	private Integer tpId ;
	private String account ;
	private String orderNo ;
	private String currency ;
	private String subject ;
	private Integer amount ;
	private Integer jPoint ;
	private String channel ;
	private String clientIp ;
	private String appId ;
	private String appDt ;
	private String appTm ;
	private String pmtState ;
	private String chargeJson ;
	private String webhooksJson ;
	private String contractNo ;
	private String transactionNo ; // 支付渠道返回的交易流水号
	private Integer pId  ; // 产品id
	private Integer ackAmt  ; // 确认金额
	private Integer appAmt  ; //  申请金额
	private String checkState  ; // 对账状态：app_amt==ack_amt 时为Y；否则为：N
 	private String tradeType ; // 订单类型 1:支付订单 ； 2:奖励订单 
	
	public Integer getTpId() {
		return tpId;
	}
	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppDt() {
		return appDt;
	}
	public void setAppDt(String appDt) {
		this.appDt = appDt;
	}
	public String getAppTm() {
		return appTm;
	}
	public void setAppTm(String appTm) {
		this.appTm = appTm;
	}
	public String getPmtState() {
		return pmtState;
	}
	public void setPmtState(String pmtState) {
		this.pmtState = pmtState;
	}
	public String getChargeJson() {
		return chargeJson;
	}
	public void setChargeJson(String chargeJson) {
		this.chargeJson = chargeJson;
	}
	public String getWebhooksJson() {
		return webhooksJson;
	}
	public void setWebhooksJson(String webhooksJson) {
		this.webhooksJson = webhooksJson;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public Integer getAckAmt() {
		return ackAmt;
	}
	public void setAckAmt(Integer ackAmt) {
		this.ackAmt = ackAmt;
	}
	public Integer getAppAmt() {
		return appAmt;
	}
	public void setAppAmt(Integer appAmt) {
		this.appAmt = appAmt;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	

}
