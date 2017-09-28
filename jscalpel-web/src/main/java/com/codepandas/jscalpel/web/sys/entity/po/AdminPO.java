package com.codepandas.jscalpel.web.sys.entity.po;
/**
 * 
 * @ClassName AdminPO  
 * @Description 管理员PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-30
 */
public class AdminPO {
	private Integer aId ;
	private String adminName  ;
	private String realName ;
	private String pwd ;
	private String adminPhone;
	private String isUse ;
	private String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	
	
	
}
