package com.fq.task;

public class PageInfo{

	/**
	 * 当前页
	 */
	private Integer begin ;
	/**
	 * 每页大小
	 */
	private Integer pageSize;
	/**
	 * 数据总量
	 */
	private Integer dataCount;

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getDataCount() {
		return dataCount;
	}
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
	
	
	
}
