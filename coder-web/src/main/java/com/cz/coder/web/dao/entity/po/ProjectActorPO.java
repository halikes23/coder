package com.fq.dao.entity.po;

/**
 * 
 * @ClassName ProjectActorPO  
 * @Description 项目剧组PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-3-4
 */
public class ProjectActorPO {

	private Integer piId ; 
	private String actorAccount ;
	private String rachelRole ;
	private Integer actorOrder ;
	private String isActive ;
	
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getActorAccount() {
		return actorAccount;
	}
	public void setActorAccount(String actorAccount) {
		this.actorAccount = actorAccount;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getRachelRole() {
		return rachelRole;
	}
	public void setRachelRole(String rachelRole) {
		this.rachelRole = rachelRole;
	}
	public Integer getActorOrder() {
		return actorOrder;
	}
	public void setActorOrder(Integer actorOrder) {
		this.actorOrder = actorOrder;
	}
	
}
