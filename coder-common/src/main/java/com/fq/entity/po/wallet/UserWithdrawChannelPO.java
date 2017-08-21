package com.fq.entity.po.wallet;

/**
 * 用户提现渠道对象实体类
 * @author chen.zhao 
 *
 */

public class UserWithdrawChannelPO {
	
	private Integer  uwcId ; //用户提现渠道ID
 	
	private String   account ; //用户账号
	
	private String 	 channelAccount ; //渠道帐号微信openId\n支付宝帐号（手机号/邮箱）
	
	private String   channelName ; //渠道昵称：微信：昵称；支付宝：用户实名认证的姓名
	
	private String   channelHeadImgUrl ; //头像链接
	
	private String   channelType ; // 渠道类型1：微信；2：支付宝；3：银行卡
	
	private String   clientType ; // 机型A:android;I:ios
	
	private String 	 clientBrand ; // 客户端手机品牌
	
	private String 	 clientChannel ; // 客户端渠道：参照sp_sys_info渠道注册奖励；Ios：IOS
	
	private String 	 clientModel ; // 手机型号 
	
	private String 	 clientSystemNo ; // 手机当前系统型号
	
	private String 	 clientDeviceNo ; // 手机设备编号
	
	private String 	 clientVersion ; // 客户端版本号
	
	private String 	 clientIp ; // 客户端ip
	
	private String 	 createDt ; // 登录时间
	
	private String 	 createTm ; // 创建时间

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

	public String getChannelHeadImgUrl() {
		return channelHeadImgUrl;
	}

	public void setChannelHeadImgUrl(String channelHeadImgUrl) {
		this.channelHeadImgUrl = channelHeadImgUrl;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
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
	

}
