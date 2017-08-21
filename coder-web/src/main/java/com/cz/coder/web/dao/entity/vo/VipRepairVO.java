package com.fq.dao.entity.vo;
/**
 * 会员补单对象
 * @author chen.zhao 
 *
 */
public class VipRepairVO {
	private String account ; 
	private Integer pId ; 
	private Integer vipTimeLimit ;
	private String isVip ;
	private String vipOutDt ;
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
	public Integer getVipTimeLimit() {
		return vipTimeLimit;
	}
	public void setVipTimeLimit(Integer vipTimeLimit) {
		this.vipTimeLimit = vipTimeLimit;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public String getVipOutDt() {
		return vipOutDt;
	}
	public void setVipOutDt(String vipOutDt) {
		this.vipOutDt = vipOutDt;
	}
	

}
