package com.fq.dao.entity.vo;
/**
 * 投票活动对象
 * @author chen.zhao 
 *
 */
public class OscarActiveVO {
	private Integer oaId ; 
	private String activeTitle;
	private String endDt ;
	private String createDt ;
	private String createTm ; 
	private String isExpired ;
	private String activeImgUrl ;
	private String activeRule ; 
	private String activeBgiTwoX ;
	private String activeBgiThreeX ;
	private String startDt ; 
	private String activeBgiTwoX2;
	private String activeBgiThreeX2;
	private String activeType ;
	private String trueUrl ;//七牛URL
	
	public Integer getOaId() {
		return oaId;
	}
	public void setOaId(Integer oaId) {
		this.oaId = oaId;
	}
	public String getActiveTitle() {
		return activeTitle;
	}
	public void setActiveTitle(String activeTitle) {
		this.activeTitle = activeTitle;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}
	public String getActiveImgUrl() {
		return activeImgUrl;
	}
	public void setActiveImgUrl(String activeImgUrl) {
		this.activeImgUrl = activeImgUrl;
	}
	public String getActiveRule() {
		return activeRule;
	}
	public void setActiveRule(String activeRule) {
		this.activeRule = activeRule;
	}
	
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	public String getActiveType() {
		return activeType;
	}
	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}
	public String getTrueUrl() {
		return trueUrl;
	}
	public void setTrueUrl(String trueUrl) {
		this.trueUrl = trueUrl;
	}
	public String getActiveBgiTwoX() {
		return activeBgiTwoX;
	}
	public void setActiveBgiTwoX(String activeBgiTwoX) {
		this.activeBgiTwoX = activeBgiTwoX;
	}
	public String getActiveBgiThreeX() {
		return activeBgiThreeX;
	}
	public void setActiveBgiThreeX(String activeBgiThreeX) {
		this.activeBgiThreeX = activeBgiThreeX;
	}
	public String getActiveBgiTwoX2() {
		return activeBgiTwoX2;
	}
	public void setActiveBgiTwoX2(String activeBgiTwoX2) {
		this.activeBgiTwoX2 = activeBgiTwoX2;
	}
	public String getActiveBgiThreeX2() {
		return activeBgiThreeX2;
	}
	public void setActiveBgiThreeX2(String activeBgiThreeX2) {
		this.activeBgiThreeX2 = activeBgiThreeX2;
	}
	
	
}
