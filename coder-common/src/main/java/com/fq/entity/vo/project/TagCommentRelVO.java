package com.fq.entity.vo.project;

public class TagCommentRelVO {

	/**
	 * 标签评论关系编号
	 */
	private Integer tcrId ;
	
	/**
	 * 项目标签编号
	 */
	private Integer ptId ;
	
	/**
	 * 评论
	 */
	private String comment ;

	public Integer getTcrId() {
		return tcrId;
	}

	public void setTcrId(Integer tcrId) {
		this.tcrId = tcrId;
	}

	public Integer getPtId() {
		return ptId;
	}

	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
