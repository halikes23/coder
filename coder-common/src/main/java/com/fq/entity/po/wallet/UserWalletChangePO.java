package com.fq.entity.po.wallet;

public class UserWalletChangePO {
	
	private Integer  uwcId ; // 主键ID
	
	private String  account ; // 用户账号
	
	private Integer cashAmt ; // 变更后余额 
	
	private Integer chgAmt ; // 余额变更数量 
	
	private String  op ; // 变动方向：1：拆红包获得；2：提现减少；3：兑换减少； 
	
	private Integer busiId ; // 业务id（提现申请编号/红包编号/兑换编号） 
	
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

	public Integer getUwcId() {
		return uwcId;
	}

	public void setUwcId(Integer uwcId) {
		this.uwcId = uwcId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(Integer cashAmt) {
		this.cashAmt = cashAmt;
	}

	public Integer getChgAmt() {
		return chgAmt;
	}

	public void setChgAmt(Integer chgAmt) {
		this.chgAmt = chgAmt;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Integer getBusiId() {
		return busiId;
	}

	public void setBusiId(Integer busiId) {
		this.busiId = busiId;
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
