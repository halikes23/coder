package com.fq.form.user;

import com.fq.form.PageInfoBaseForm;

/**
 * 进入用户列表界面表单
 * @author zhen.cheng
 *
 */
public class ChangeUserRoleForm{

	/**
	 * 用户SN
	 */
	private String account ;
	
	/**
	 * 用户角色
	 */
	private String userRole ;
	
	/**
	 * 演员类型
	 */
	
	private String userSubRole ;


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
	
	public String getUserSubRole() {
		return userSubRole;
	}

	public void setUserSubRole(String userSubRole) {
		this.userSubRole = userSubRole;
	}
	


}
