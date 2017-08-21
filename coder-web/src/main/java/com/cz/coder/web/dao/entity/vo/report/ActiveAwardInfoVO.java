package com.fq.dao.entity.vo.report;

public class ActiveAwardInfoVO {
	private int activeAwardId ;
	private String account ; // 用户账号
	private String mobile ;	//用户手机号
	private int  activeId ; // 活动编号
	private String clientDeviceNo ; // 客户端设备编号
	private String haveAward ; // 是否已经奖励
	private String createDt ;  // 创建日期
	private String createTm ;  // 创建时间
	
	public int getActiveAwardId() {
		return activeAwardId;
	}
	public void setActiveAwardId(int activeAwardId) {
		this.activeAwardId = activeAwardId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getActiveId() {
		return activeId;
	}
	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}
	public String getClientDeviceNo() {
		return clientDeviceNo;
	}
	public void setClientDeviceNo(String clientDeviceNo) {
		this.clientDeviceNo = clientDeviceNo;
	}
	public String getHaveAward() {
		return haveAward;
	}
	public void setHaveAward(String haveAward) {
		this.haveAward = haveAward;
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
