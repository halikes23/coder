package com.fq.entity.po.group;

public class GroupCodePO {
	
	private Integer gcId ; 
	private String  projectGroupCode ; //项目分组码
	private String  groupDesc ; //分组描述
	private Integer commentNum ; //评论总数量
	private Integer commentFloor ; //评论楼层 
	private Integer logNum ; //剧圈数量
	private String  isDeleted ; //是否删除：Y：已删除；N:未删除 
	private String  createDt ; 
	private String  createTm ;
	
	public Integer getGcId() {
		return gcId;
	}
	public void setGcId(Integer gcId) {
		this.gcId = gcId;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getCommentFloor() {
		return commentFloor;
	}
	public void setCommentFloor(Integer commentFloor) {
		this.commentFloor = commentFloor;
	}
	public Integer getLogNum() {
		return logNum;
	}
	public void setLogNum(Integer logNum) {
		this.logNum = logNum;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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
}
