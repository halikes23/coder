package com.fq.entity.vo.project;
/**
 * 日志评论配图VO
 * @author chen.zhao 
 *
 */
public class ProjectLogCommentImgVO {
	
	private Integer plciId ; //主键ID
	private Integer plcId ; //日志评论ID
	private String  imgKey ; //图片KEY
	private String  createDate ; //时间 
	private String  orderNo ; //排序
	
	public Integer getPlciId() {
		return plciId;
	}
	public void setPlciId(Integer plciId) {
		this.plciId = plciId;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public String getImgKey() {
		return imgKey;
	}
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
