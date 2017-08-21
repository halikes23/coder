package com.fq.dao.entity.vo;

/**
 * 商品信息
 * @author chen.zhao 
 *
 */
public class ProductInfoVO {
	private Integer pId;         
	private String productName;
	private String productId;
	private String productMoney;
	private Integer discountMoney;
	private Integer jPoint;
	private String productImg;
	private String productDesc;
	private String createDate;
	private Integer rewardMoney ; // 充值奖励人民币  单位:元
	private Integer rewardJpoint ;// 充值奖励描述  单位：剧点
	private String clientType ; // 产品类型A:android;I:IOS；N:快捷支付;V:VIP
	private Integer vipTimeLimit ; // 会员期限
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductMoney() {
		return productMoney;
	}
	public void setProductMoney(String productMoney) {
		this.productMoney = productMoney;
	}
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getRewardMoney() {
		return rewardMoney;
	}
	public void setRewardMoney(Integer rewardMoney) {
		this.rewardMoney = rewardMoney;
	}
	public Integer getRewardJpoint() {
		return rewardJpoint;
	}
	public void setRewardJpoint(Integer rewardJpoint) {
		this.rewardJpoint = rewardJpoint;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public Integer getVipTimeLimit() {
		return vipTimeLimit;
	}
	public void setVipTimeLimit(Integer vipTimeLimit) {
		this.vipTimeLimit = vipTimeLimit;
	}
	public Integer getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(Integer discountMoney) {
		this.discountMoney = discountMoney;
	}
	
	
	
}
