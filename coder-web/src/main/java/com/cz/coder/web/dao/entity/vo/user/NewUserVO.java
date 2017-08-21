package com.fq.dao.entity.vo.user;

public class NewUserVO {
	
	private Integer newUserCount;    //新用户数量
	private Integer userTotalCount;  //总用户量 
	private String  writeDate;  //注册时间 
	private Integer vipTotalCount ; //会员总数
	
	public Integer getNewUserCount() {
		return newUserCount;
	}
	public void setNewUserCount(Integer newUserCount) {
		this.newUserCount = newUserCount;
	}
	public Integer getUserTotalCount() {
		return userTotalCount;
	}
	public void setUserTotalCount(Integer userTotalCount) {
		this.userTotalCount = userTotalCount;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public Integer getVipTotalCount() {
		return vipTotalCount;
	}
	public void setVipTotalCount(Integer vipTotalCount) {
		this.vipTotalCount = vipTotalCount;
	}
	
}
