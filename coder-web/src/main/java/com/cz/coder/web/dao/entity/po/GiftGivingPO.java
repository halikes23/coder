package com.fq.dao.entity.po;

/**
 * 
 * @ClassName GiftGivingPO  
 * @Description 送礼记录PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-6-22
 */
public class GiftGivingPO {
    private Integer ggId ;
    private String  oprAccount ;
	private String  applyAccount ;
	private Integer giftId ;
	private String  givingDate ;
	private String  applyDate ;
	private String  oprMsg ;
	private String  applyMsg ;
	private String  giftType ;
	private Integer giftModuleId ;
	private String  isOpened ;
	
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
	public String getApplyAccount() {
		return applyAccount;
	}
	public void setApplyAccount(String applyAccount) {
		this.applyAccount = applyAccount;
	}
	public Integer getGiftId() {
		return giftId;
	}
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	public String getGivingDate() {
		return givingDate;
	}
	public void setGivingDate(String givingDate) {
		this.givingDate = givingDate;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getOprMsg() {
		return oprMsg;
	}
	public void setOprMsg(String oprMsg) {
		this.oprMsg = oprMsg;
	}
	public String getApplyMsg() {
		return applyMsg;
	}
	public void setApplyMsg(String applyMsg) {
		this.applyMsg = applyMsg;
	}
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public Integer getGiftModuleId() {
		return giftModuleId;
	}
	public void setGiftModuleId(Integer giftModuleId) {
		this.giftModuleId = giftModuleId;
	}
	public String getIsOpened() {
		return isOpened;
	}
	public void setIsOpened(String isOpened) {
		this.isOpened = isOpened;
	}
	
}
