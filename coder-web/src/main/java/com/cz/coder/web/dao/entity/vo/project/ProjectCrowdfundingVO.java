package com.fq.dao.entity.vo.project;

/**
 * 
 * @ClassName ProjectCrowdfundingVO  
 * @Description 众筹项目VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-19
 */
public class ProjectCrowdfundingVO {
 
	private Integer  piId;  // 项目id
	private String   isUse; //  是被否伪删除  Y ；使用中 ；N ：已被删除
	private String   dateTime ; //  更新日期
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
}
