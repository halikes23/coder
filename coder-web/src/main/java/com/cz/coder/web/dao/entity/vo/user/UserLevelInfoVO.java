package com.fq.dao.entity.vo.user;

/**
 * 
 * @ClassName UserLevelInfoVO  
 * @Description 用户等级经验VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-3-29
 */
public class UserLevelInfoVO {
	private String  liId ; // id
    private String  account ; // 账户
	private String  userType ; // 用户类型 N:普通用户;V:VIP; 
	private Integer exeAmount ; // 总经验量
	private Integer  lvNo ;  // 当前级别
	
	public String getLiId() {
		return liId;
	}
	public void setLiId(String liId) {
		this.liId = liId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getExeAmount() {
		return exeAmount;
	}
	public void setExeAmount(Integer exeAmount) {
		this.exeAmount = exeAmount;
	}
	public Integer getLvNo() {
		return lvNo;
	}
	public void setLvNo(Integer lvNo) {
		this.lvNo = lvNo;
	}
	
	
}
