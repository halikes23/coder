package com.fq.util.page;

import java.util.List;

public class PageInfo<T> {

	/**
	 * 数据列表
	 */
	private List<T> dataList ;
	/**
	 * 当前页
	 */
	private Integer currentlyPageNo ;
	/**
	 * 每页大小
	 */
	private Integer pageSize;
	/**
	 * 数据总量
	 */
	private Integer dataCount;
	
	private Integer pageNow ;

	public List<T> getDataList() {
		return dataList;
	}


	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


	public Integer getCurrentlyPageNo() {
		return currentlyPageNo;
	}


	public void setCurrentlyPageNo(Integer currentlyPageNo) {
		this.currentlyPageNo = currentlyPageNo;
	}


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

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

}
