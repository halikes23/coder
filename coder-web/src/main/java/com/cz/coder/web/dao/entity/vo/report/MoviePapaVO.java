package com.fq.dao.entity.vo.report;

/**
 * 影片大爸爸实体类
 * 
 * @author chen.zhao
 * 
 */
public class MoviePapaVO {
	private String projectName;
	private Integer episodeNo;
	private String title;
	private String account;
	private String userNick;
	private Integer healAmount;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public Integer getHealAmount() {
		return healAmount;
	}
	public void setHealAmount(Integer healAmount) {
		this.healAmount = healAmount;
	}
	
	
}
