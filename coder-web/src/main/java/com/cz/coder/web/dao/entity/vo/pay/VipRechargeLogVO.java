package com.fq.dao.entity.vo.pay;

public class VipRechargeLogVO {
	
	private Integer vipRechargeId ;
	private Integer pId ; 
	private String account ; 
	private String createDt ;
	private String createTm ;
	private String outDt ; 
	private String isNp;
	
	public Integer getVipRechargeId() {
		return vipRechargeId;
	}
	public void setVipRechargeId(Integer vipRechargeId) {
		this.vipRechargeId = vipRechargeId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getOutDt() {
		return outDt;
	}
	public void setOutDt(String outDt) {
		this.outDt = outDt;
	}
	public String getIsNp() {
		return isNp;
	}
	public void setIsNp(String isNp) {
		this.isNp = isNp;
	}
	
}
