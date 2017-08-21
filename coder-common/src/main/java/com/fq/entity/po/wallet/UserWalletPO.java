package com.fq.entity.po.wallet;

/*
 * 用户钱包对象实体类
 */

public class UserWalletPO {
	
	private Integer uwId ; //用户钱包ID
	
	private String account ; //用户账号 
	
	private Integer cashAmt ; //用户余额
	
	private Integer frozenAmt ; //冻结资金
	
	private String  chkState  ;  //是否通过审核
	
	private String  updateDt ; //最近一次变更日期
	
	private String  updateTm ; //最近一次变更时间
	
	private String  updateUser ; //操作员账号(管理员)
	

	public Integer getUwId() {
		return uwId;
	}

	public void setUwId(Integer uwId) {
		this.uwId = uwId;
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

	

	public Integer getFrozenAmt() {
		return frozenAmt;
	}

	public void setFrozenAmt(Integer frozenAmt) {
		this.frozenAmt = frozenAmt;
	}

	public String getChkState() {
		return chkState;
	}

	public void setChkState(String chkState) {
		this.chkState = chkState;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getUpdateTm() {
		return updateTm;
	}

	public void setUpdateTm(String updateTm) {
		this.updateTm = updateTm;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	
	

}
