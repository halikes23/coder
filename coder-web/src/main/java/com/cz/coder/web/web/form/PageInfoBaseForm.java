package com.cz.coder.web.web.form;

/**
 * 分页基础表单
 * @author zhen.cheng
 *
 */
public class PageInfoBaseForm {

	/**
	 * 当前页
	 */
	protected Integer currentlyPageNo;
	/**
	 * 每页大小
	 */
	protected Integer pageSize ;
	
	protected Integer begin ;
	
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
	
	public Integer getBegin(){
		return ( currentlyPageNo - 1 ) * pageSize ;
		
	}

	
}
