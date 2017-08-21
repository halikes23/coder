package com.fq.entity.vo.novel;
/**
 * 小说排行榜对象
 * @author chen.zhao 
 *
 */
public class NovelRankVO {
	
	private Integer rankNo ; //排行编号
	private Integer niId ; //对应小说项目ID
	private Integer recentlyBoxOffice ; //最近一周票房
	private Integer totalBoxOffice ; //总票房
	private String  novelName ; //小说名
	private String  account ; //账号/作者
	private String  coverUrl ;//封面图
	private String  novelType ; //小说类型
	private String  novelDesc ; //小说简介
	private String  claimAccount ; //认领者账号
	private String  claimHeadImg  ; //认领者头像
	private String haveUpdateTips ; // 是否有更新提示Y：有提示标签；N:无提示标签
	
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
	
	public Integer getRecentlyBoxOffice() {
		return recentlyBoxOffice;
	}
	public void setRecentlyBoxOffice(Integer recentlyBoxOffice) {
		this.recentlyBoxOffice = recentlyBoxOffice;
	}
	public Integer getTotalBoxOffice() {
		return totalBoxOffice;
	}
	public void setTotalBoxOffice(Integer totalBoxOffice) {
		this.totalBoxOffice = totalBoxOffice;
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
	public String getHaveUpdateTips() {
		return haveUpdateTips;
	}
	public void setHaveUpdateTips(String haveUpdateTips) {
		this.haveUpdateTips = haveUpdateTips;
	}
	
}
