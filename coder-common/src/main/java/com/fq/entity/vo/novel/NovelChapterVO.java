package com.fq.entity.vo.novel;

public class NovelChapterVO {
	
	private Integer ncId ; 
	private Integer niId ; 
	private String  title ; //标题
	private Integer chapterNo ; //章节编号
	private String  chapterContent ; //章节内容key
	private Integer chapterPrice ; //解锁据点
	private Integer unlockNum ; // 解锁人数
	private Integer readingNum ; // 阅读人数
	private Integer shareNum ; // 分享人数
	private String  isFree ; // 是否免费：Y：免费；N:付费
	private String  addState ; // 小说上架状态：1:上架；2:待审核;3:其他原因下架
	private String readPermission ; // 用户阅读权限Y:有；N：无
	private String  createDt ; 
	private String  createTm ;
	private Integer chapterWords ; 
	private Integer unitPrice ;
	private String  novelName ;
	
	public Integer getNcId() {
		return ncId;
	}
	public void setNcId(Integer ncId) {
		this.ncId = ncId;
	}
	public Integer getNiId() {
		return niId;
	}
	public void setNiId(Integer niId) {
		this.niId = niId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(Integer chapterNo) {
		this.chapterNo = chapterNo;
	}
	public String getChapterContent() {
		return chapterContent;
	}
	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}
	public Integer getChapterPrice() {
		return chapterPrice;
	}
	public void setChapterPrice(Integer chapterPrice) {
		this.chapterPrice = chapterPrice;
	}
	public Integer getUnlockNum() {
		return unlockNum;
	}
	public void setUnlockNum(Integer unlockNum) {
		this.unlockNum = unlockNum;
	}
	
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	public String getAddState() {
		return addState;
	}
	public void setAddState(String addState) {
		this.addState = addState;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getReadPermission() {
		return readPermission;
	}
	public void setReadPermission(String readPermission) {
		this.readPermission = readPermission;
	}
	public Integer getReadingNum() {
		return readingNum;
	}
	public void setReadingNum(Integer readingNum) {
		this.readingNum = readingNum;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public Integer getChapterWords() {
		return chapterWords;
	}
	public void setChapterWords(Integer chapterWords) {
		this.chapterWords = chapterWords;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getNovelName() {
		return novelName;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	
}
