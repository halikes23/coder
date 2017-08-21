package com.fq.dao.entity.vo;

/**
 * 兑换cdkey异常记录
 * @author Administrator
 *
 */
public class ExchangeErrorVO {
	private Integer eelId;
	private String account;
	private String userNick;
	private Integer errorNo;
	private String lastFailTime;
	
	public Integer getEelId() {
		return eelId;
	}
	public void setEelId(Integer eelId) {
		this.eelId = eelId;
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
	public Integer getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(Integer errorNo) {
		this.errorNo = errorNo;
	}
	public String getLastFailTime() {
		return lastFailTime;
	}
	public void setLastFailTime(String lastFailTime) {
		this.lastFailTime = lastFailTime;
	}
	
}
