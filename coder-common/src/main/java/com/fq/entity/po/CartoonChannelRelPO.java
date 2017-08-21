package com.fq.entity.po;

public class CartoonChannelRelPO {
	
	private Integer crId ; 
	private Integer ciId ;
	private Integer plcId ; 
	private String  createDate ; 
	private String  isDeleted ;
	
	public Integer getCrId() {
		return crId;
	}
	public void setCrId(Integer crId) {
		this.crId = crId;
	}
	public Integer getCiId() {
		return ciId;
	}
	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
