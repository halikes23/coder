package com.fq.dao.entity.vo.report;

public class VoteLogReportVO {
	private String oprAccount;//用户账号
	private String oprUserNick;//用户昵称
	private String voteName;//选票名称
	private String actorAccount;//候选人账号
	private String actorUserNick;//候选人昵称
	private String writeDate;//投票时间
	
	public String getOprAccount() {
		return oprAccount;
	}
	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
	}
	public String getOprUserNick() {
		return oprUserNick;
	}
	public void setOprUserNick(String oprUserNick) {
		this.oprUserNick = oprUserNick;
	}
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public String getActorAccount() {
		return actorAccount;
	}
	public void setActorAccount(String actorAccount) {
		this.actorAccount = actorAccount;
	}
	public String getActorUserNick() {
		return actorUserNick;
	}
	public void setActorUserNick(String actorUserNick) {
		this.actorUserNick = actorUserNick;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
}
