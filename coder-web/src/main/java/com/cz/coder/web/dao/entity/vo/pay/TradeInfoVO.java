package com.fq.dao.entity.vo.pay;

/**
 * 订单信息
 * @author Administrator
 *
 */
public class TradeInfoVO {
	
	private Integer taId; 
	private String entityNo;  //实体编号
	private String entityType; //实体类型（1：个人，2：项目）
	private Integer appAmt;  //据点量
	private Integer appVol;  //据点量
	private String date;
	private String cdkey;
	private String busiCode; //类型 1:个人打赏给个人  ,2 , 个人被打赏   3,个人打赏项目 ， 4，项目被打赏   5:每日登录奖励 , 6:注册 , 7:充值据点，8:影片退款
	private String contractNo; //合同号
	private String receiptData; //苹果内购订单参数数据
	private String pmtState;  //支付状态 1：未支付 2：支付成功 3：支付失败
	private String pmtChannel;  //支付渠道 1：苹果内购 2：ping++ 3：CDKEY;4：(alipay)支付宝手机支付；5：(upacp)银联；6：(wx)微信
	
	public Integer getTaId() {
		return taId;
	}
	public void setTaId(Integer taId) {
		this.taId = taId;
	}
	public String getEntityNo() {
		return entityNo;
	}
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public Integer getAppVol() {
		return appVol;
	}
	public void setAppVol(Integer appVol) {
		this.appVol = appVol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCdkey() {
		return cdkey;
	}
	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getReceiptData() {
		return receiptData;
	}
	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}
	public String getPmtState() {
		return pmtState;
	}
	public void setPmtState(String pmtState) {
		this.pmtState = pmtState;
	}
	public Integer getAppAmt() {
		return appAmt;
	}
	public void setAppAmt(Integer appAmt) {
		this.appAmt = appAmt;
	}
	public String getPmtChannel() {
		return pmtChannel;
	}
	public void setPmtChannel(String pmtChannel) {
		this.pmtChannel = pmtChannel;
	}
	
	
}
