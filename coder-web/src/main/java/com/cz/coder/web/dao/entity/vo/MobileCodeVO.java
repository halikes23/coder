package com.fq.dao.entity.vo;
/**
 * 
 * @ClassName MobileCode  
 * @Description 短信验证码  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-26
 */
public class MobileCodeVO {

	private String mobileCode ;
	private String userName ;
	private String userMobile ;
	private String sendDate ;
 
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	 
}
