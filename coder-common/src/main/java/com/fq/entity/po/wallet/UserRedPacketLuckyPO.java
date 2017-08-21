package com.fq.entity.po.wallet;

public class UserRedPacketLuckyPO {
	
	private Integer rplId ; //主键
	
	private Integer ureId ; //红包ID
	
	private String account ; //用户账户
	
	private Integer cashAmt ; // 金额：单位分 
	
	private String openDt ; // 拆红包日期
	
	private String openTm ; // 拆红包时间

	public Integer getRplId() {
		return rplId;
	}

	public void setRplId(Integer rplId) {
		this.rplId = rplId;
	}

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

	public Integer getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(Integer cashAmt) {
		this.cashAmt = cashAmt;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getOpenTm() {
		return openTm;
	}

	public void setOpenTm(String openTm) {
		this.openTm = openTm;
	}
	

}
