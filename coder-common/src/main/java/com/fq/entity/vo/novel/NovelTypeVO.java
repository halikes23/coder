package com.fq.entity.vo.novel;

public class NovelTypeVO {

	private Integer ntId ;
	private String novelType ;
	private String typeImg ;
	private Integer indexNo ;
	private String isDeleted ;
	private String typeFlag ; // 类型标记；1：书籍类型；2：全部类型；3：我的书架；
	private String qiniuUrl ;
	
	public Integer getNtId() {
		return ntId;
	}
	public void setNtId(Integer ntId) {
		this.ntId = ntId;
	}
	public String getNovelType() {
		return novelType;
	}
	public void setNovelType(String novelType) {
		this.novelType = novelType;
	}
	public String getTypeImg() {
		return typeImg;
	}
	public void setTypeImg(String typeImg) {
		this.typeImg = typeImg;
	}
	public Integer getIndexNo() {
		return indexNo;
	}
	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	public String getQiniuUrl() {
		return qiniuUrl;
	}
	public void setQiniuUrl(String qiniuUrl) {
		this.qiniuUrl = qiniuUrl;
	}
	
}
