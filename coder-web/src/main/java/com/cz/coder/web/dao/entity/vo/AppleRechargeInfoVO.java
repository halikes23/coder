package com.fq.dao.entity.vo;

/**
 * 苹果充值记录参数
 * @author Administrator
 *
 */
public class AppleRechargeInfoVO {
	private Integer taId ;   //订单id
	private String account ;  //充值账户
	private String userNick ; //用户昵称
	private Integer jpoint ;  //充值剧点
	private String contractNo ; //合同号
	private String pmtState ;  //支付状态
	private String receiptData ; //订单校验信息
	private String  date ;    //日期
	
	
	public Integer getTaId() {
		return taId;
	}
	public void setTaId(Integer taId) {
		this.taId = taId;
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
	public Integer getJpoint() {
		return jpoint;
	}
	public void setJpoint(Integer jpoint) {
		this.jpoint = jpoint;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getPmtState() {
		return pmtState;
	}
	public void setPmtState(String pmtState) {
		this.pmtState = pmtState;
	}
	public String getReceiptData() {
		return receiptData;
	}
	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
