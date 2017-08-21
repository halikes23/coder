package com.fq.dao.entity.po;
/**
 * 
 * @ClassName MovieRankPO  
 * @Description 影片排行PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-23
 */
public class MovieRankPO {

	private Integer rankNo ; // 排序
	private Integer mId ; // 影片id
	private Integer rankRecent ; // 最近七天总量 对应rank_nums1
	private Integer rankTotal ; // 影片被打赏总量 对应ran_knums2
	private Integer rankNums3 ; // 1
	private Integer rankNums4 ; // 0
	private Integer rankNums5 ; // 0
	private Integer piId ; //项目ID
	private Integer recentWeekPlayCount ; //最近七天播放量
	private Integer totalPlayCount ; // 总播放量 
	private String projectName ; // 标题
	private String coverUrl ; // 封面图
	private String chapterCoverUrl ; // 章节封面图
	private Integer currentEpisode ; // 当前更新话数
	private String account ; //作者,投稿人
	private String headImgUrl; // 作者头像
	private String busiType; //业务类型
	private Integer episodeNo ; //影片集数
	
	public Integer getRankNo() {
		return rankNo;
	}
	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Integer getRankRecent() {
		return rankRecent;
	}
	public void setRankRecent(Integer rankRecent) {
		this.rankRecent = rankRecent;
	}
	public Integer getRankTotal() {
		return rankTotal;
	}
	public void setRankTotal(Integer rankTotal) {
		this.rankTotal = rankTotal;
	}
	
	public Integer getRankNums3() {
		return rankNums3;
	}
	public void setRankNums3(Integer rankNums3) {
		this.rankNums3 = rankNums3;
	}
	public Integer getRankNums4() {
		return rankNums4;
	}
	public void setRankNums4(Integer rankNums4) {
		this.rankNums4 = rankNums4;
	}
	public Integer getRankNums5() {
		return rankNums5;
	}
	public void setRankNums5(Integer rankNums5) {
		this.rankNums5 = rankNums5;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
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
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	
	
}
