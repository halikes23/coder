package com.fq.dao.entity.vo.user;

/**
 * 用户日志被点赞消息通知VO
 * @author chen.zhao 
 *
 */
public class ProjectLogPraiseVO {
	private Integer praiseCount; 
	private String account ;
	private Integer pliId;
	private Integer piId ;
	private String createDate;
	private String logType;
	public Integer getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Integer getPliId() {
		return pliId;
	}
	public void setPliId(Integer pliId) {
		this.pliId = pliId;
	}
	
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	
}
