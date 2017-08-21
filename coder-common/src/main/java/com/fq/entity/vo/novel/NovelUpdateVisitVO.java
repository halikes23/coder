package com.fq.entity.vo.novel;

public class NovelUpdateVisitVO {
    private Integer niId ; 
	private Integer ncId ; 
	private Integer nuvId ; 
	private String  account ; 
	private String  createDt ; 
	private String  createTm ;
	
	public Integer getNiId() {
		return niId;
	}
	public void setNiId(Integer niId) {
		this.niId = niId;
	}
	public Integer getNcId() {
		return ncId;
	}
	public void setNcId(Integer ncId) {
		this.ncId = ncId;
	}
	public Integer getNuvId() {
		return nuvId;
	}
	public void setNuvId(Integer nuvId) {
		this.nuvId = nuvId;
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
	
}
