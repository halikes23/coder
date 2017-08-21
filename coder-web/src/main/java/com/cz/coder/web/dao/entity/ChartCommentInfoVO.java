package com.fq.dao.entity;

/**
 * 封装评论回复和点赞数据
 * @author Administrator
 *
 */
public class ChartCommentInfoVO {
	private String createDate ;
	private Integer likeNums ; 
	private Integer replyNums;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getLikeNums() {
		return likeNums;
	}
	public void setLikeNums(Integer likeNums) {
		this.likeNums = likeNums;
	}
	public Integer getReplyNums() {
		return replyNums;
	}
	public void setReplyNums(Integer replyNums) {
		this.replyNums = replyNums;
	}
	
}
