package com.fq.entity.vo.project;

/**
 * 项目标签
 * @author cz
 *
 */
public class ProjectTagVO {
	
	/**
	 * 项目标签编号
	 */
	private Integer ptId ;
	
	/**
	 * 项目标签
	 */
	private String tag ;
	
	/**
	 * 启用停用状态
	 */
	private String state ;
	
	/**
	 * 标签评论文案数量
	 */
	private Integer commentCount ;

	public Integer getPtId() {
		return ptId;
	}

	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
}
