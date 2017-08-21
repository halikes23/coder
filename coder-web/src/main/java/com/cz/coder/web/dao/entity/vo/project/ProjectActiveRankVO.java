package com.fq.dao.entity.vo.project;

/**
 * 
 * @ClassName ProjectActiveRankVO  
 * @Description 影片活跃排序  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-12
 */
public class ProjectActiveRankVO {
	
    private Integer arId ; // 排行主键
	private Integer piId ; // 项目id
	private String activeDate ; // 活跃时间点
	private String action ; // 触发事件
	
	public Integer getArId() {
		return arId;
	}
	public void setArId(Integer arId) {
		this.arId = arId;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
