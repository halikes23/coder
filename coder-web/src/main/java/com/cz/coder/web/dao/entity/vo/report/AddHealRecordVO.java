package com.fq.dao.entity.vo.report;

/**
 * 加血记录实体类
 * @author Administrator
 *
 */
public class AddHealRecordVO {
	private String  projectName ; 
	private Integer episodeNo ; 
	private String account ;
	private String userNick ; 
	private Integer healAmount ; 
	private String healDate ;
	private String isNavy ;
	
	
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
	public String getHealDate() {
		return healDate;
	}
	public void setHealDate(String healDate) {
		this.healDate = healDate;
	} 
//	public String getIsNavy() {
//		return isNavy;
//	}
//	public void setIsNavy(String isNavy) {
//		this.isNavy = isNavy;
//	} 
	public String getIsNavy() {
		return isNavy;
	}
	public void setIsNavy(String isNavy) {
		this.isNavy = isNavy;
	}
	
	
	
}
