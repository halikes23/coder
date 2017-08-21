package com.fq.dao.entity.vo.gift;

/**
 * 
 * @ClassName GiftInfoVO  
 * @Description 礼物基本信息VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-6-22
 */
public class GiftInfoVO {
	
	private Integer giftId ; // 礼品Id
	private String giftName ; // 礼品名
	private String giftThumbImg ; // 礼物缩略图
	private String giftImg ; // 礼物大图
	private String giftPrice ; // 礼物价格
	private Integer giftJpoint ; // 礼物对应的剧点
	private String  giftGreetings ; // 问候语
	private String  isUse ; //是否使用
	private String realUrl ;  //大图真实七牛路径
	private Integer orderIndex ; // 礼物排序
	
	public Integer getGiftId() {
		return giftId;
	}
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftThumbImg() {
		return giftThumbImg;
	}
	public void setGiftThumbImg(String giftThumbImg) {
		this.giftThumbImg = giftThumbImg;
	}
	public String getGiftImg() {
		return giftImg;
	}
	public void setGiftImg(String giftImg) {
		this.giftImg = giftImg;
	}
	public String getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(String giftPrice) {
		this.giftPrice = giftPrice;
	}
	public Integer getGiftJpoint() {
		return giftJpoint;
	}
	public void setGiftJpoint(Integer giftJpoint) {
		this.giftJpoint = giftJpoint;
	}
	public String getGiftGreetings() {
		return giftGreetings;
	}
	public void setGiftGreetings(String giftGreetings) {
		this.giftGreetings = giftGreetings;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	
}
