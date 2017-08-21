package com.fq.entity.po.book;

public class OriginChapterInfoPO {
	private Integer  id ; //书籍ID
	private Integer cId ; // 章节ID 
	private String  bName ; //书籍名称
	private String  cName ; //章节名称
	private String title ; 
	private String content  ; 
	private String isFree ; 
	private Integer chapterWords ; //章节字数
	private Integer sort ; 
	private Integer unitPrice ; 
	private Integer chapterPrice ; 
	private String  isDeleted ;
	private Integer niId ;  
	private String createDt ; 
	private String createTm ; 
	private Integer bcId ;
	private Integer bId ; //书籍表主键ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	public Integer getChapterWords() {
		return chapterWords;
	}
	public void setChapterWords(Integer chapterWords) {
		this.chapterWords = chapterWords;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getChapterPrice() {
		return chapterPrice;
	}
	public void setChapterPrice(Integer chapterPrice) {
		this.chapterPrice = chapterPrice;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getNiId() {
		return niId;
	}
	public void setNiId(Integer niId) {
		this.niId = niId;
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
	public Integer getBcId() {
		return bcId;
	}
	public void setBcId(Integer bcId) {
		this.bcId = bcId;
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	
}
