package com.fq.dao.entity.vo;

/**
 * 被警告用户日志表
 * @author Administrator
 *
 */
public class UserWarningVO {
	private Integer uwlId;
	private String  account;
	private String  userNick;
	private String  dateTime;
	
	public Integer getUwlId() {
		return uwlId;
	}
	public void setUwlId(Integer uwlId) {
		this.uwlId = uwlId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
