package com.fq.dao.entity.vo;

/**
 * 项目总数排行
 * @author Administrator
 *
 */
public class ProjectRankVO {
	private String projectName ; 
	private Integer commentNums ; 
	private Integer logNums;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getCommentNums() {
		return commentNums;
	}
	public void setCommentNums(Integer commentNums) {
		this.commentNums = commentNums;
	}
	public Integer getLogNums() {
		return logNums;
	}
	public void setLogNums(Integer logNums) {
		this.logNums = logNums;
	}
	
	
}
