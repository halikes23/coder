package com.fq.dao.entity.po;
/**
 * 漫画七日榜对象
 * @author chen.zhao 
 *
 */
public class LiveCartoonRankPO {
	private Integer piId ; //项目ID
	private Integer plcId ; //漫画ID
	private Integer recentWeekPlayCount ; //最近七天播放量
	private Integer totalPlayCount ; // 总播放量 
	private String cartoonTitle ; // 标题
	private String chapterCoverUrl ; // 章节封面图
	private Integer currentEpisode ; // 当前更新话数
	private String account ; //作者
	private String headImgUrl; // 作者头像
	private Integer rankNo ; //排序位
	private String busiType; //业务类型
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public Integer getRecentWeekPlayCount() {
		return recentWeekPlayCount;
	}
	public void setRecentWeekPlayCount(Integer recentWeekPlayCount) {
		this.recentWeekPlayCount = recentWeekPlayCount;
	}
	public Integer getTotalPlayCount() {
		return totalPlayCount;
	}
	public void setTotalPlayCount(Integer totalPlayCount) {
		this.totalPlayCount = totalPlayCount;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public String getChapterCoverUrl() {
		return chapterCoverUrl;
	}
	public void setChapterCoverUrl(String chapterCoverUrl) {
		this.chapterCoverUrl = chapterCoverUrl;
	}
	public Integer getCurrentEpisode() {
		return currentEpisode;
	}
	public void setCurrentEpisode(Integer currentEpisode) {
		this.currentEpisode = currentEpisode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public Integer getRankNo() {
		return rankNo;
	}
	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	
	
}
