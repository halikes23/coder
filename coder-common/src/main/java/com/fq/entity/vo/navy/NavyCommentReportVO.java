package com.fq.entity.vo.navy;
/**
 * 水军每日评论数VO
 * @author chen.zhao 
 *
 */
public class NavyCommentReportVO {
	private String createDate ; 
	private String mobile ;
	private String dayCommentNum ;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDayCommentNum() {
		return dayCommentNum;
	}
	public void setDayCommentNum(String dayCommentNum) {
		this.dayCommentNum = dayCommentNum;
	}
	
}
