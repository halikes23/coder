package com.fq.dao.entity.vo.project;

/**
 * 
* @ClassName: CrowdfundingVO
* @Description: 众筹VO
* @author fupenghao
* @date 2016-3-14 下午4:34:37
*
 */
public class CrowdfundingVO {
	private Integer piId;
	private String projectName;
	private String projectCoverUrl;
	private Integer projectTotalEpisode; // 项目总集数
	private Integer projectUpdateEpisode ;  // 项目已更新集数
	private String 	projectDesc; // 项目简介【剧情】
	private String  projectDescOriginal; //[原著]
	private String  projectDescBackground; //[背景]
	private Integer projectLogNums;
	private Integer projectCommentNums;
	private String  projectOwnerNick;
	private String  crowdfundingProjectCoverUrl ;
	
	private Integer orderIndex;
	
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
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
	public String getProjectCoverUrl() {
		return projectCoverUrl;
	}
	public void setProjectCoverUrl(String projectCoverUrl) {
		this.projectCoverUrl = projectCoverUrl;
	}
	public Integer getProjectUpdateEpisode() {
		return projectUpdateEpisode;
	}
	public void setProjectUpdateEpisode(Integer projectUpdateEpisode) {
		this.projectUpdateEpisode = projectUpdateEpisode;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public Integer getProjectLogNums() {
		return projectLogNums;
	}
	public void setProjectLogNums(Integer projectLogNums) {
		this.projectLogNums = projectLogNums;
	}
	public Integer getProjectCommentNums() {
		return projectCommentNums;
	}
	public void setProjectCommentNums(Integer projectCommentNums) {
		this.projectCommentNums = projectCommentNums;
	}
	public String getProjectOwnerNick() {
		return projectOwnerNick;
	}
	public void setProjectOwnerNick(String projectOwnerNick) {
		this.projectOwnerNick = projectOwnerNick;
	}
	public String getCrowdfundingProjectCoverUrl() {
		return crowdfundingProjectCoverUrl;
	}
	public void setCrowdfundingProjectCoverUrl(String crowdfundingProjectCoverUrl) {
		this.crowdfundingProjectCoverUrl = crowdfundingProjectCoverUrl;
	}
	public Integer getProjectTotalEpisode() {
		return projectTotalEpisode;
	}
	public void setProjectTotalEpisode(Integer projectTotalEpisode) {
		this.projectTotalEpisode = projectTotalEpisode;
	}
	public String getProjectDescOriginal() {
		return projectDescOriginal;
	}
	public void setProjectDescOriginal(String projectDescOriginal) {
		this.projectDescOriginal = projectDescOriginal;
	}
	public String getProjectDescBackground() {
		return projectDescBackground;
	}
	public void setProjectDescBackground(String projectDescBackground) {
		this.projectDescBackground = projectDescBackground;
	}
	
}
