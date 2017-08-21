package com.fq.entity.vo.wallet;
/**
 * 红包对应被邀请用户关系对象实体类
 * @author chen.zhao 
 *
 */
public class UserRedPacketInviteRelVO {
	
	private Integer  reiId ; //主键ID
	
	private Integer  ureId ; // 红包ID
	
	private String 	 usedState ; // 使用类型  0 ：不可用 ； 1： 已使用 ； 2 ：未使用
	
	private String 	 oprAccount ; // 邀请人账号
	
	private String 	 applyAccount ; // 被邀请人帐号 
	
	private String 	 createDt ; // 创建日期
	
	private String   createTm ; // 创建时间
	
	private String   clientType ; // 机型A:android;I:ios
	
	private String 	 clientBrand ; // 客户端手机品牌
	
	private String 	 clientChannel ; // 客户端渠道：参照sp_sys_info渠道注册奖励；Ios：IOS
	
	private String 	 clientModel ; // 手机型号 
	
	private String 	 clientSystemNo ; // 手机当前系统型号
	
	private String 	 clientDeviceNo ; // 手机设备编号
	
	private String 	 clientVersion ; // 客户端版本号
	
	private String 	 clientIp ; // 客户端ip

	public Integer getReiId() {
		return reiId;
	}

	public void setReiId(Integer reiId) {
		this.reiId = reiId;
	}

	public Integer getUreId() {
		return ureId;
	}

	public void setUreId(Integer ureId) {
		this.ureId = ureId;
	}

	public String getUsedState() {
		return usedState;
	}

	public void setUsedState(String usedState) {
		this.usedState = usedState;
	}

	public String getOprAccount() {
		return oprAccount;
	}

	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
	}

	public String getApplyAccount() {
		return applyAccount;
	}

	public void setApplyAccount(String applyAccount) {
		this.applyAccount = applyAccount;
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
