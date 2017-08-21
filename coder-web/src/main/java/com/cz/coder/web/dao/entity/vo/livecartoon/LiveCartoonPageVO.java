package com.fq.dao.entity.vo.livecartoon;

public class LiveCartoonPageVO {

	private Integer plcId ;
	private String cartoonTitle ;
	private String episodeNo ;
	private Integer  lcpId ;
	private Integer  lcId ;
	private Integer  pageNo ;
	private String  cartoonUrl ;
	private String  cartoonRealUrl ;
	private Integer  pageHeight ;
	private Integer  pageWidth ;
	private String  isDeleted ;
	
	
	public Integer getLcpId() {
		return lcpId;
	}
	public void setLcpId(Integer lcpId) {
		this.lcpId = lcpId;
	}
	public Integer getLcId() {
		return lcId;
	}
	public void setLcId(Integer lcId) {
		this.lcId = lcId;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getCartoonUrl() {
		return cartoonUrl;
	}
	public void setCartoonUrl(String cartoonUrl) {
		this.cartoonUrl = cartoonUrl;
	}
	public Integer getPageHeight() {
		return pageHeight;
	}
	public void setPageHeight(Integer pageHeight) {
		this.pageHeight = pageHeight;
	}
	public Integer getPageWidth() {
		return pageWidth;
	}
	public void setPageWidth(Integer pageWidth) {
		this.pageWidth = pageWidth;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCartoonRealUrl() {
		return cartoonRealUrl;
	}
	public void setCartoonRealUrl(String cartoonRealUrl) {
		this.cartoonRealUrl = cartoonRealUrl;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public String getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(String episodeNo) {
		this.episodeNo = episodeNo;
	}
	@Override
	public String toString() {
		return "LiveCartoonPageVO [lcpId=" + lcpId + ", pageNo=" + pageNo
				+ ", cartoonUrl=" + cartoonUrl + "]";
	}
	
	
}
