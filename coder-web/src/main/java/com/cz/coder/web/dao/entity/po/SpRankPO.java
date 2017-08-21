package com.fq.dao.entity.po;

public class SpRankPO {
	private Integer rId ; //主键ID
	private Integer rankNo ; //排序位
	private Integer piId ; //影片对应项目的id/漫画对应项目id
	private Integer recentlyBoxOffie ; // 近期票房
	private Integer totalBoxOffie ; //总票房
	private String  busiType ; // 业务类型：1：影片排行；2：漫画排行  
	private String  projecName ; //项目名
	private Integer episodeNo ; //最大集数
	private String 	account ; // 作者
	private String 	headImgUrl  ; // 作者头像
	private String  coverUrl ; // 封面图
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
	public String getProjecName() {
		return projecName;
	}
	public void setProjecName(String projecName) {
		this.projecName = projecName;
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
