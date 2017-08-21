package com.fq.dao.entity.vo.project;


/**
 * 猜你喜欢项目
 * @author Administrator
 *
 */
public class ProjectGuessLikeVO {
	private Integer piId; //原项目id
	private Integer relPiId; //关联项目id
	private String projectName; //项目名称
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getRelPiId() {
		return relPiId;
	}
	public void setRelPiId(Integer relPiId) {
		this.relPiId = relPiId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
