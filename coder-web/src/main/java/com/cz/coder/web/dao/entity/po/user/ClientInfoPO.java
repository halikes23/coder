package com.fq.dao.entity.po.user;

public class ClientInfoPO {
	private String account ; 
	private String clientType ;
	private String clientBrand ;
	private String clientModel ;
	private String clientChannel ;
	private String clientSystemNo ;
	private String clientDeviceNo ;
	private String clientVersion ;
	private String clientIp ; 
	private String createDt ; 
	private String isNp ;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getClientChannel() {
		return clientChannel;
	}
	public void setClientChannel(String clientChannel) {
		this.clientChannel = clientChannel;
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
	public String getIsNp() {
		return isNp;
	}
	public void setIsNp(String isNp) {
		this.isNp = isNp;
	}
}
