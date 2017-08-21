package com.fq.dao.entity.po.novel;
/**
 * 小说七日榜排行对象
 * @author chen.zhao 
 *
 */
public class NovelRankPO {
	
	private Integer rId ; 
	private Integer rankNo ; 
	private Integer piId ; 
	private Integer recentlyBoxOffie ; 
	private Integer totalBoxOffie ; 
	private String  busiType ; 
	private String  projectName ; 
	private Integer episodeNo ; 
	private String  account ; 
	private String  headImgUrl ; 
	private String  coverUrl ;
	
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer getRankNo() {
		return rankNo;
	}
	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getRecentlyBoxOffie() {
		return recentlyBoxOffie;
	}
	public void setRecentlyBoxOffie(Integer recentlyBoxOffie) {
		this.recentlyBoxOffie = recentlyBoxOffie;
	}
	public Integer getTotalBoxOffie() {
		return totalBoxOffie;
	}
	public void setTotalBoxOffie(Integer totalBoxOffie) {
		this.totalBoxOffie = totalBoxOffie;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
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
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	} 
	
}
