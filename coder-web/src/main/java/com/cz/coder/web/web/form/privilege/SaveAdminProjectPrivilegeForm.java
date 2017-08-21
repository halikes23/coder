package com.cz.coder.web.web.form.privilege;

/**
 * 后台用户权限参数表
 * @author Administrator
 *
 */
public class SaveAdminProjectPrivilegeForm {
	private Integer adminId ; 
	private String  piIds ;
	private Integer operater ;
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getPiIds() {
		return piIds;
	}
	public void setPiIds(String piIds) {
		this.piIds = piIds;
	}
	public Integer getOperater() {
		return operater;
	}
	public void setOperater(Integer operater) {
		this.operater = operater;
	} 
	
}
