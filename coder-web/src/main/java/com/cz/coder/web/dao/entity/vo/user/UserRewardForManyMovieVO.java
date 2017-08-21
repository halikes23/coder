package com.fq.dao.entity.vo.user;

/**
 * 用户对一个项目中的多个影片打赏
 * @author Administrator
 *
 */
public class UserRewardForManyMovieVO {
	private Integer piId ;
	private String  account ; 
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	
	
}
