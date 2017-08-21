package com.fq.form.login;

/**
 * 修改密码表单
 * @author zhen.cheng
 *
 */
public class ChgPsdForm {

	/**
	 * 管理员账户
	 */
	private String adminName ;
	/**
	 * 原密码
	 */
	private String oldPsd ;
	/**
	 * 新密码
	 */
	private String newPsd ;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getOldPsd() {
		return oldPsd;
	}
	public void setOldPsd(String oldPsd) {
		this.oldPsd = oldPsd;
	}
	public String getNewPsd() {
		return newPsd;
	}
	public void setNewPsd(String newPsd) {
		this.newPsd = newPsd;
	}
	
	
	
}
