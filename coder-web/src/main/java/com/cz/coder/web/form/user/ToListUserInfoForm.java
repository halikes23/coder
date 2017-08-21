package com.fq.form.user;

import com.fq.form.PageInfoBaseForm;

/**
 * 进入用户列表界面表单
 * @author zhen.cheng
 *
 */
public class ToListUserInfoForm extends PageInfoBaseForm{

	/**
	 * 用户SN
	 */
	private Integer userSn ;
	/**
	 * 用户账户
	 */
	private String account ;
	
	/**
	 * 用户角色
	 */
	private String userRole ;
	
	/**
	 * 用户昵称
	 */
	private String userNick ;
	
	/**
	 * 用户是否禁言
	 */
	private String isGag ;
	
	/**
	 * 演职人员类别区分
	 */
	
	private String userSubRole ;
	
	/**
	 * 是否是VIP用户
	 */
	
	private String isVip ;
	
	/**
	 * 是否是管理者
	 */
	
	private String isManager ; 
	
	/**
	 * VIP过期时间
	 */
	
	private String vipOutDt ;
	
	private String selStartDate ;
	
	private String selEndDate ;
	
	private String writeDate ;
	
	private String selectStartDate ;
	
	private String selectEndDate ;
	

	public String getSelectStartDate() {
		return selectStartDate;
	}

	public void setSelectStartDate(String selectStartDate) {
		this.selectStartDate = selectStartDate;
	}

	public String getSelectEndDate() {
		return selectEndDate;
	}

	public void setSelectEndDate(String selectEndDate) {
		this.selectEndDate = selectEndDate;
	}

	public String getSelStartDate() {
		return selStartDate;
	}

	public void setSelStartDate(String selStartDate) {
		this.selStartDate = selStartDate;
	}

	public String getSelEndDate() {
		return selEndDate;
	}

	public void setSelEndDate(String selEndDate) {
		this.selEndDate = selEndDate;
	}

	public String getUserSubRole() {
		return userSubRole;
	}

	public void setUserSubRole(String userSubRole) {
		this.userSubRole = userSubRole;
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

	public String getIsGag() {
		return isGag;
	}

	public void setIsGag(String isGag) {
		this.isGag = isGag;
	}

	public Integer getUserSn() {
		return userSn;
	}

	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

}
