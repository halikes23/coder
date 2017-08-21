package com.fq.dao.entity.vo.user;

/**
 * 所有打赏影片的用户信息
 * @author Administrator
 *
 */
public class RewardUserInfoVO {
	private String account ; 
	private String userNick ;
	private Integer healAmount ; 
	private String mobile  ;
	
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
	public Integer getHealAmount() {
		return healAmount;
	}
	public void setHealAmount(Integer healAmount) {
		this.healAmount = healAmount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
