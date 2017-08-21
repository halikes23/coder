package com.fq.dao.entity.vo.gift;

/**
 * 
 * @ClassName GiftNotificationVO  
 * @Description 礼物消息列表VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-6-27
 */
public class GiftNotificationVO {
	private Integer ggId ;
    private String oprAccount ;
	private String oprName ;
	private String oprHeadImgUrl ;
	private String givingDate ;
	
	public Integer getGgId() {
		return ggId;
	}
	public void setGgId(Integer ggId) {
		this.ggId = ggId;
	}
	public String getOprAccount() {
		return oprAccount;
	}
	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
	}
	public String getOprName() {
		return oprName;
	}
	public void setOprName(String oprName) {
		this.oprName = oprName;
	}
	public String getOprHeadImgUrl() {
		return oprHeadImgUrl;
	}
	public void setOprHeadImgUrl(String oprHeadImgUrl) {
		this.oprHeadImgUrl = oprHeadImgUrl;
	}
	public String getGivingDate() {
		return givingDate;
	}
	public void setGivingDate(String givingDate) {
		this.givingDate = givingDate;
	}
	
	
}
