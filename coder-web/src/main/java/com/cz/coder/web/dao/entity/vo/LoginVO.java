package com.cz.coder.web.dao.entity.vo;

/**
 * 
 * @ClassName LoginVO  
 * @Description 登录  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-29
 */
public class LoginVO {

	private String adminName  ;
	private String userMobile ;
	private String mobileCode ;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
}
