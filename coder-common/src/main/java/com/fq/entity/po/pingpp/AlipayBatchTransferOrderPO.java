package com.fq.entity.po.pingpp;

public class AlipayBatchTransferOrderPO {

	private String pingppOrderNo ;
	
	private String url ;
	
	private String status ;
	
	private String batchNo ;

	public String getPingppOrderNo() {
		return pingppOrderNo;
	}

	public void setPingppOrderNo(String pingppOrderNo) {
		this.pingppOrderNo = pingppOrderNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	
}
