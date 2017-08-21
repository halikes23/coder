package com.fq.dao.entity.vo;

/**
 * cdkeyinfo
 * @author Administrator
 *
 */

public class CdkeyInfoVO {
	private String cdId;  //主键id
	private String cdkey; //cdkey兑换码
	private String cdkeyMd5; //加密后的兑换码
	private String account;  //用户账户
	private String jPoint;  //兑换码面值 1元=10剧点
	private String isUse;	//是否已用过  Y：已用过  N：未用过	
	private String exchangeTime; //充值时间
	private String producer;  //生成人 
	private String batchNo;   //批次号
	private String produceTime; //生成时间
	private Integer repeatTimes ; // 重复使用次数默认为一次若为0表示没有使用次数的限制
	private String  startDt ; // 开始兑换日期
	private String  endDt ; // 结束兑换日期
	
	public String getCdId() {
		return cdId;
	}
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	public String getCdkey() {
		return cdkey;
	}
	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}
	public String getCdkeyMd5() {
		return cdkeyMd5;
	}
	public void setCdkeyMd5(String cdkeyMd5) {
		this.cdkeyMd5 = cdkeyMd5;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getjPoint() {
		return jPoint;
	}
	public void setjPoint(String jPoint) {
		this.jPoint = jPoint;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getExchangeTime() {
		return exchangeTime;
	}
	public void setExchangeTime(String exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getProduceTime() {
		return produceTime;
	}
	public void setProduceTime(String produceTime) {
		this.produceTime = produceTime;
	}
	public Integer getRepeatTimes() {
		return repeatTimes;
	}
	public void setRepeatTimes(Integer repeatTimes) {
		this.repeatTimes = repeatTimes;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	
}
