package com.fq.dao.entity.vo.report;

public class UserReportVO {
	private String createDate ; 
	private Integer newUserCnt;
	private Integer userTotalCnt ;
	private Integer vipCnt ; 
	private Integer activeCnt;
	private Integer behaviorCnt;
	private Integer monthActiveCnt;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getNewUserCnt() {
		return newUserCnt;
	}
	public void setNewUserCnt(Integer newUserCnt) {
		this.newUserCnt = newUserCnt;
	}
	public Integer getUserTotalCnt() {
		return userTotalCnt;
	}
	public void setUserTotalCnt(Integer userTotalCnt) {
		this.userTotalCnt = userTotalCnt;
	}
	public Integer getVipCnt() {
		return vipCnt;
	}
	public void setVipCnt(Integer vipCnt) {
		this.vipCnt = vipCnt;
	}
	public Integer getActiveCnt() {
		return activeCnt;
	}
	public void setActiveCnt(Integer activeCnt) {
		this.activeCnt = activeCnt;
	}
	
	public Integer getBehaviorCnt() {
		return behaviorCnt;
	}
	public void setBehaviorCnt(Integer behaviorCnt) {
		this.behaviorCnt = behaviorCnt;
	}
	public Integer getMonthActiveCnt() {
		return monthActiveCnt;
	}
	public void setMonthActiveCnt(Integer monthActiveCnt) {
		this.monthActiveCnt = monthActiveCnt;
	}
	
	
}
