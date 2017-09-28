package com.codepandas.jscalpel.web.sys.entity.po;

/**
 * 
 * @ClassName LoginPO  
 * @Description 登录  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-29
 */
public class LoginPO {
	private String adminName  ;
	private String pwd ;
	private String isUse ;
	private String mobileCode ;
	
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
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	
}
