package com.fq.dao.entity.vo.project;

/**
 * 项目信息
 * @author Administrator
 *
 */
public class PurviewProjectInfo {
	private Integer piId ; 
	private String projectName ;
	private Boolean checked;
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
	
}
