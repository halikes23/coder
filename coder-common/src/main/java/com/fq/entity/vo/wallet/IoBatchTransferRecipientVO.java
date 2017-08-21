package com.fq.entity.vo.wallet;

public class IoBatchTransferRecipientVO {

	private Integer btrId ;
	private String batchNo ;
	private String pingppOrderNo ;
	private String transfer ;
	private String account ;
	private String name ;
	private Integer amount ;
	private String status ;
	private String createDt ;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getPingppOrderNo() {
		return pingppOrderNo;
	}
	public void setPingppOrderNo(String pingppOrderNo) {
		this.pingppOrderNo = pingppOrderNo;
	}
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBtrId() {
		return btrId;
	}
	public void setBtrId(Integer btrId) {
		this.btrId = btrId;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
}
