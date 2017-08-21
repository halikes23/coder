package com.fq.dao.entity.po;
/**
 * 
 * @ClassName ProjectCrowdfundingPO  
 * @Description 筹片表  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-15
 */
public class ProjectCrowdfundingPO {
    private Integer piId ; // 项目id
	private String 	isUse ; // 是否放到首页
	private String  dateTime ; // 日期
	
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
