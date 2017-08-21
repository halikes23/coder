package com.fq.dao.entity.po.pay;

/**
 * 
 * @ClassName CDkeyInfoPO  
 * @Description 兑换码信息  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-22
 */
public class CDkeyInfoPO {

	private String  cdKey; // 兑换码
	private String  cdkeyMd5; // 加密后的兑换码 
	private String  account; // 兑换人账号
	private Integer  jPoint; //  面值
	private String  isUse; // 是否已经使用
	private String  exchangeTime; // 兑换日期
	private String  producer; // 创建管理员信息
	private String  batchNo ; // 批次号
	private String  produceTime ; // 生成日期
	private Integer repeatTimes ; // 重复使用次数默认为一次若为0表示没有使用次数的限制
	private String  startDt ; // 开始兑换日期
	private String  endDt ; // 结束兑换日期
	public String getCdKey() {
		return cdKey;
	}
	public void setCdKey(String cdKey) {
		this.cdKey = cdKey;
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
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
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
