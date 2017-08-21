package com.fq.entity.vo.navy;
/**
 * 水军评论VO
 * @author chen.zhao 
 *
 */
public class NavyCommentVO {
	
	private Integer nciId ; 
	private String  mobile ; 
	private String  isRemind ; 
	private Integer dayCommentNum ; 
	private String  userNick ;
	private String  needRemind ;
	private String  isDeleted ;
	
	public Integer getNciId() {
		return nciId;
	}
	public void setNciId(Integer nciId) {
		this.nciId = nciId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIsRemind() {
		return isRemind;
	}
	public void setIsRemind(String isRemind) {
		this.isRemind = isRemind;
	} 
	public Integer getDayCommentNum() {
		return dayCommentNum;
	}
	public void setDayCommentNum(Integer dayCommentNum) {
		this.dayCommentNum = dayCommentNum;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getNeedRemind() {
		return needRemind;
	}
	public void setNeedRemind(String needRemind) {
		this.needRemind = needRemind;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
