package com.fq.dao.entity.vo.report;
/**
 * 漫画解锁实体类
 * @author Administrator
 *
 */
public class UnlockLiveCartoonVO {
	private String  account ;
	private String  userNick ;
	private String cartoonTitle;
	private Integer episodeNo;
	private Integer UnlockJpoint ;
	private String  createDt ;
	private String  isNavy;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	public Integer getUnlockJpoint() {
		return UnlockJpoint;
	}
	public void setUnlockJpoint(Integer unlockJpoint) {
		UnlockJpoint = unlockJpoint;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getIsNavy() {
		return isNavy;
	}
	public void setIsNavy(String isNavy) {
		this.isNavy = isNavy;
	}
	

}
