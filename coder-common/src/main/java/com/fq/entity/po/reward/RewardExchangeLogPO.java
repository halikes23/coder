package com.fq.entity.po.reward;

public class RewardExchangeLogPO {

	
	private Integer  ureId ; // 主键ID
	
	private String  account ; // 用户账号
	
	private Integer pId ; // 产品id 
	
	private Integer exchangeRewardAmt ; // 兑换赏金数量 
	
	private String  op ; // 变动方向：1：赏金兑换；2：赏金提现
	
	private Integer taId ; // tp_trade_app 主键 
	
	private String  createDt ;  // 变更日期 
	
	private String  createTm ;  // 变更时间 
	
	private String   clientType ; // 机型A:android;I:ios
	
	private String 	 clientBrand ; // 客户端手机品牌
	
	private String 	 clientChannel ; // 客户端渠道：参照sp_sys_info渠道注册奖励；Ios：IOS
	
	private String 	 clientModel ; // 手机型号 
	
	private String 	 clientSystemNo ; // 手机当前系统型号
	
	private String 	 clientDeviceNo ; // 手机设备编号
	
	private String 	 clientVersion ; // 客户端版本号
	
	private String 	 clientIp ; // 客户端ip

	public Integer getUreId() {
		return ureId;
	}

	public void setUreId(Integer ureId) {
		this.ureId = ureId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getExchangeRewardAmt() {
		return exchangeRewardAmt;
	}

	public void setExchangeRewardAmt(Integer exchangeRewardAmt) {
		this.exchangeRewardAmt = exchangeRewardAmt;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Integer getTaId() {
		return taId;
	}

	public void setTaId(Integer taId) {
		this.taId = taId;
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

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
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
	
	
}
