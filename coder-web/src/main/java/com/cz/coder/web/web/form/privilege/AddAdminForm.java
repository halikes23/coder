package com.cz.coder.web.web.form.privilege;

/**
 * 添加操作人表单
 * @author zhen.cheng
 *
 */
public class AddAdminForm {

	/**
	 * 操作人账号
	 */
	private String userName ;
	
	/**
	 * 操作人姓名
	 */
	private String realName ;
	
	/**
	 * 操作人手机号
	 */
	private String phone ;
	/*
	 * 操作员邮箱
	 * */
	private String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
