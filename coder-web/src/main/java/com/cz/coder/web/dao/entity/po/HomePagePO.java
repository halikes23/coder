package com.fq.dao.entity.po;

/**
 * 首页PO
 * @author zhen.cheng
 *
 */
public class HomePagePO {

	/**
	 * 影片编号
	 */
	private Integer mId ;
	/**
	 * 标题
	 */
	private String title ;
	/**
	 * 是否使用
	 */
	private Integer isUse ;
	/**
	 * 日期
	 */
	private String writeDate ;
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
}
