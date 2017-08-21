package com.fq.entity.po.rank;
/**
 * 小说排行对象PO
 * @author chen.zhao 
 *
 */
public class NovelRankPO {

	private Integer rankNo ; //排行编号
	private Integer niId ; //对应小说项目ID
	private Integer recentlyBoxOffie ; //最近一周票房
	private Integer totalBoxOffie ; //总票房
	private String  novelName ; //小说名
	private String  account ; //账号/作者
	private String  coverUrl ;//封面图
	private String  novelType ; //小说类型
	private String  novelDesc ; //小说简介
	private String  claimAccount ; //认领者账号
	private String  claimHeadImg  ; //认领者头像
	
	public Integer getRankNo() {
		return rankNo;
	}
	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}
	public Integer getNiId() {
		return niId;
	}
	public void setNiId(Integer niId) {
		this.niId = niId;
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
	public String getNovelName() {
		return novelName;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getNovelType() {
		return novelType;
	}
	public void setNovelType(String novelType) {
		this.novelType = novelType;
	}
	public String getNovelDesc() {
		return novelDesc;
	}
	public void setNovelDesc(String novelDesc) {
		this.novelDesc = novelDesc;
	}
	public String getClaimAccount() {
		return claimAccount;
	}
	public void setClaimAccount(String claimAccount) {
		this.claimAccount = claimAccount;
	}
	public String getClaimHeadImg() {
		return claimHeadImg;
	}
	public void setClaimHeadImg(String claimHeadImg) {
		this.claimHeadImg = claimHeadImg;
	}
}
