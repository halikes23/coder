package com.fq.dao.entity.vo;


public class QuartzTask {
	public final static QuartzTask build( String taskName , String title , Integer paramsCount , String remark ){
		QuartzTask task = new QuartzTask(); 
		task.setTaskName(taskName);
		task.setTitle(title);
		task.setRemark(remark);
		task.setParamsCount(paramsCount);
		return task ;
	}
	
	private String taskName ;
	private String title ;
	private String remark ;
	
	private Integer paramsCount ;
	
	private String param1 ;
	private String param2 ;
	private String param3 ;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getParamsCount() {
		return paramsCount;
	}
	public void setParamsCount(Integer paramsCount) {
		this.paramsCount = paramsCount;
	}
	
}
