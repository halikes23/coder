package com.fq.entity.vo.wallet;

public class RedPacketLuckyVO {
	
	private String userNick ;
	private String headImgUrl ;
	private Integer cashAmt ;
	private String createDt ;
	private String createTm ;
	private long openDt ; // 拆红包时间戳
	
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public Integer getCashAmt() {
		return cashAmt;
	}
	public void setCashAmt(Integer cashAmt) {
		this.cashAmt = cashAmt;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public long getOpenDt() {
		return openDt;
	}
	public void setOpenDt(long openDt) {
		this.openDt = openDt;
	}
	
}
