package com.fq.dao.entity.vo.project;

/**
 * 
 * @author xinwei.haung
 *
 */
public class ProjectCommentVO {
	
	private Integer pcId;
	
	private Integer piId ;
	
	private String projectName;
	
	private String userNick;
	
	private String account;
	
	private String content;
	
	private String floor ;
	
	private String createDate;
	
	private Integer cnt ; 
	
	private String  groupCode ;

	
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getPcId() {
		return pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
	
	public Integer getPiId() {
		return piId;
	}

	public void setPiId(Integer piId) {
		this.piId = piId;
	}

	public ProjectCommentVO() {
	}

	public ProjectCommentVO(String projectName, String userNick, String account,
			String content,String createDate) {
		super();
		this.projectName = projectName;
		this.userNick = userNick;
		this.account = account;
		this.createDate = createDate;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
}
