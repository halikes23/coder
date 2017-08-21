package com.fq.entity.po;

/**
 * banner条对象
 * @author zhen.cheng
 *
 */
public class CBannerInfo {

	/**
	 * 主键id
	 */
	private Integer biId ;
	/**
	 * 项目id
	 */
	private Integer piId ;
	/**
	 * 影片id
	 */
	private Integer miId ;
	/**
	 * 轮播图qiniukey
	 */
	private String imgQiniuKey ;
	/**
	 * 轮播图url
	 */
	private String imgUrl ;
	/**
	 * 类型：1:影片；2:广告；3:跳转充值；4：漫画；5：任务页
	 */
	private String bannerType;
	/**
	 * banner显示名称
	 */
	private String bannerTypeDisplayName;
	/**
	 * 排序
	 */
	private Integer orderIndex ;
	/**
	 * H5页面跳转Url
	 */
	private String url ;
	/**
	 * 第几集
	 */
	private Integer episode ;
	/**
	 * 访问次数
	 */
	private Integer visitCount ;
	/**
	 * 伪删除标记位：N:未删除；Y:已删除
	 */
	private String isDeleted ;
	/**
	 * 是否启用：N:停用；Y:启用
	 */
	private String isEnabled ;
	/*
	 * 业务id（剧圈id/问卷id）	
	 */
	private Integer busiId;

	public Integer getBusiId() {
		return busiId;
	}
	public void setBusiId(Integer busiId) {
		this.busiId = busiId;
	}
	public Integer getBiId() {
		return biId;
	}
	public void setBiId(Integer biId) {
		this.biId = biId;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getMiId() {
		return miId;
	}
	public void setMiId(Integer miId) {
		this.miId = miId;
	}
	public String getImgQiniuKey() {
		return imgQiniuKey;
	}
	public void setImgQiniuKey(String imgQiniuKey) {
		this.imgQiniuKey = imgQiniuKey;
	}
	public String getBannerType() {
		return bannerType;
	}
	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getEpisode() {
		return episode;
	}
	public void setEpisode(Integer episode) {
		this.episode = episode;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getBannerTypeDisplayName() {
		return bannerTypeDisplayName;
	}
	public void setBannerTypeDisplayName(String bannerTypeDisplayName) {
		this.bannerTypeDisplayName = bannerTypeDisplayName;
	}
	public Integer getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
