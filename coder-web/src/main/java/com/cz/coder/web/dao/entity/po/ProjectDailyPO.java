package com.fq.dao.entity.po;

public class ProjectDailyPO {
	private String pliId      ;
	private String piId       ;
	private String content     ;
	private String paiseNums  ;
	private String commentNums;
	private String videoUrl   ;
	private String createDate ;
	public String getPliId() {
		return pliId;
	}
	public void setPliId(String pliId) {
		this.pliId = pliId;
	}
	public String getPiId() {
		return piId;
	}
	public void setPiId(String piId) {
		this.piId = piId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPaiseNums() {
		return paiseNums;
	}
	public void setPaiseNums(String paiseNums) {
		this.paiseNums = paiseNums;
	}
	public String getCommentNums() {
		return commentNums;
	}
	public void setCommentNums(String commentNums) {
		this.commentNums = commentNums;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
