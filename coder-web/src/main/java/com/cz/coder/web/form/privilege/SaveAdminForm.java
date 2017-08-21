package com.fq.form.privilege;

/**
 * 保存操作人修改表单
 * @author zhen.cheng
 *
 */
public class SaveAdminForm {

	/**
	 * 操作人编号
	 */
	private Integer adminId ;
	
	/**
	 * 操作人姓名
	 */
	private String realName ;
	
	/**
	 * 操作人手机号
	 */
	private String adminPhone ;
	
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	
}
