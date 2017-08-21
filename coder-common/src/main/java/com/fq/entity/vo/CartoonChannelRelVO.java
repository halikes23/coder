package com.fq.entity.vo;

/**
 * 漫画渠道关系VO
 * @author chen.zhao 
 *
 */
public class CartoonChannelRelVO {
	
	private Integer crId ; 
	private Integer ciId ;
	private Integer plcId ; 
	private String  createDate ; 
	private String  isDeleted ;
	private String  cartoonTitle ;
	
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
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	
	
}
