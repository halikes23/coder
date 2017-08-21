package com.fq.dao.entity.vo.user;

public class UserJPointLogVO {
	private Integer lId;
	private Integer userSn;
	private String account;
	private Integer jPoint;
	private Integer op;
	private Integer opId;
	private String opObj; 
	private String opDesc ;	
	private String writeDate;
	private String coinType ; 
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public Integer getOp() {
		return op;
	}
	public void setOp(Integer op) {
		this.op = op;
	}
	public Integer getOpId() {
		return opId;
	}
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	public String getOpObj() {
		return opObj;
	}
	public void setOpObj(String opObj) {
		this.opObj = opObj;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getOpDesc() {
		return opDesc;
	}
	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}
	public String getCoinType() {
		return coinType;
	}
	public void setCoinType(String coinType) {
		this.coinType = coinType;
	}
	
}
