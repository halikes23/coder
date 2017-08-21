package com.fq.entity.vo;
/**
 * 漫画渠道收入VO
 * @author chen.zhao 
 *
 */
public class CartoonChannelIncomeVO {
	
	private Integer cciId ;
	private String createDate ;
	private String income ; 
	private Integer plcId ; 
	private Integer ciId ;
	private String cartoonTitle ; 
	private String channelName ; 
	private String baseMoney ;//保底金
	private String incomeType ;
	public Integer getCciId() {
		return cciId;
	}
	public void setCciId(Integer cciId) {
		this.cciId = cciId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public Integer getCiId() {
		return ciId;
	}
	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getBaseMoney() {
		return baseMoney;
	}
	public void setBaseMoney(String baseMoney) {
		this.baseMoney = baseMoney;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	
}	
