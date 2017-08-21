package com.fq.entity.vo;
/**
 * 漫画渠道VO
 * @author chen.zhao 
 *
 */
public class CartoonChannelVO {
	private Integer ciId ; 
	private String  channelName ;
	private String  operator ; 
	private String  createDate ; 
	private String  isDeleted ;
	public Integer getCiId() {
		return ciId;
	}
	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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
