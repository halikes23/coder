package com.fq.dao.entity.vo.gift;

/**
 * 礼品赠送单
 * @author zhen.cheng
 *
 */
public class GiftGivingVO {

	private Integer ggId ;
    private String  oprAccount ;
    private String  oprUserNick ; 
	private String  applyAccount ;
	private String  applyUserNick ;
	private String giftId ;
	private String  givingDate ;
	private String  applyDate ;
	private String  oprMsg ;
	private String  replyMsg ;
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
	public String getOprUserNick() {
		return oprUserNick;
	}
	public void setOprUserNick(String oprUserNick) {
		this.oprUserNick = oprUserNick;
	}
	public String getApplyAccount() {
		return applyAccount;
	}
	public void setApplyAccount(String applyAccount) {
		this.applyAccount = applyAccount;
	}
	public String getApplyUserNick() {
		return applyUserNick;
	}
	public void setApplyUserNick(String applyUserNick) {
		this.applyUserNick = applyUserNick;
	}
	public String getGiftId() {
		return giftId;
	}
	public void setGiftId(String giftId) {
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
	public String getReplyMsg() {
		return replyMsg;
	}
	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
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
