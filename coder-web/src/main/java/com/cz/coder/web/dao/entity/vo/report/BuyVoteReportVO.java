package com.fq.dao.entity.vo.report;

public class BuyVoteReportVO {
	private String account;//用户账号
	private String userNick;//用户昵称
	private String voteName;//选票名称
	private Integer jpoint;//选票剧点
	private String writeDate;//购票日期
	
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
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
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public Integer getJpoint() {
		return jpoint;
	}
	public void setJpoint(Integer jpoint) {
		this.jpoint = jpoint;
	}
	
}
