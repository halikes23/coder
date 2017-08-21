package com.fq.dao.entity.vo;

public class UserProductMonthIncomeVO {
	
	private String month ; 
	private String  monthIncome ;
	private String  cartoonChannelIncome ; //漫画第三方渠道月收入
	private String totalMonthIncome ; //月总收入（订阅+渠道）
	private Integer id ; //小说漫画ID
	private String name ; //小说漫画名称
	private String subType ; //作品类型
	private String channelName ; //渠道名称
	private String baseMoney ; //保底金
	private String productType ; 
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(String monthIncome) {
		this.monthIncome = monthIncome;
	}
	public String getCartoonChannelIncome() {
		return cartoonChannelIncome;
	}
	public void setCartoonChannelIncome(String cartoonChannelIncome) {
		this.cartoonChannelIncome = cartoonChannelIncome;
	}
	public String getTotalMonthIncome() {
		return totalMonthIncome;
	}
	public void setTotalMonthIncome(String totalMonthIncome) {
		this.totalMonthIncome = totalMonthIncome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
}
