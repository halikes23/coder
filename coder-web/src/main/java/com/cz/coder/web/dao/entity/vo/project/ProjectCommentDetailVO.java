package com.fq.dao.entity.vo.project;

/**
 * 评论详情实体类
 * @author Administrator
 *
 */
public class ProjectCommentDetailVO {
	private Integer pcrId ;
	private Integer pcId ; 
	private Integer piId ;
	private String oprAccount ;
	private String oprUserNick ;
	private String applyAccount ;
	private String applyUserNick ;
	private Integer replyCommentId;
	private String content ;
	private String createDate;
	public Integer getPcrId() {
		return pcrId;
	}
	public void setPcrId(Integer pcrId) {
		this.pcrId = pcrId;
	}
	public Integer getPcId() {
		return pcId;
	}
	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getOprAccount() {
		return oprAccount;
	}
	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
	}
	public String getOprUserNick() {
		return oprUserNick;
	}
	public void setOprUserNick(String oprUserNick) {
		this.oprUserNick = oprUserNick;
	}
	public String getApplyAccount() {
		return applyAccount;
	}
	public void setApplyAccount(String applyAccount) {
		this.applyAccount = applyAccount;
	}
	public String getApplyUserNick() {
		return applyUserNick;
	}
	public void setApplyUserNick(String applyUserNick) {
		this.applyUserNick = applyUserNick;
	}
	public Integer getReplyCommentId() {
		return replyCommentId;
	}
	public void setReplyCommentId(Integer replyCommentId) {
		this.replyCommentId = replyCommentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
