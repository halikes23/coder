package com.fq.dao.entity.vo.livecartoon;

public class LiveCartoonChapterVO {

	private Integer lcId ; //漫画编号
	private Integer piId ; 
	private String title ; //该话标题
	private String cartoonTitle ; //漫画项目标题
	private String coverUrl ; //该话封面图
	private String chapterCoverUrl ; //该话展示封面图
	private Integer episodeNo ; //第几话
	private String createDt ; 
	private String isFree ; //是否需要付费Y：是N:否
	private String readPermision ; //是否有权看Y:有权看;N:无权看
	private Integer visitNo ;// 项目漫画总播放量
	private Integer unlockJpoint ; // 解锁所需剧点
	private String createTm ; //项目漫画创建时间
	private Integer plcId ; //项目ID
	private Integer maxEpisodeNo ; //最大更新集数
	
	
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getChapterCoverUrl() {
		return chapterCoverUrl;
	}
	public void setChapterCoverUrl(String chapterCoverUrl) {
		this.chapterCoverUrl = chapterCoverUrl;
	}
	public Integer getLcId() {
		return lcId;
	}
	public void setLcId(Integer lcId) {
		this.lcId = lcId;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	public String getReadPermision() {
		return readPermision;
	}
	public void setReadPermision(String readPermision) {
		this.readPermision = readPermision;
	}
	public Integer getVisitNo() {
		return visitNo;
	}
	public void setVisitNo(Integer visitNo) {
		this.visitNo = visitNo;
	}
	public Integer getUnlockJpoint() {
		return unlockJpoint;
	}
	public void setUnlockJpoint(Integer unlockJpoint) {
		this.unlockJpoint = unlockJpoint;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public Integer getMaxEpisodeNo() {
		return maxEpisodeNo;
	}
	public void setMaxEpisodeNo(Integer maxEpisodeNo) {
		this.maxEpisodeNo = maxEpisodeNo;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	
}
