package com.fq.dao.entity.vo.sina;

public class SinaAppCateVO {

	private Integer sacId ;
	private Integer spId ; //新浪推广信息表外键
	private Integer appCateId ;//产品应用标签id
	private String  appCateName ;//产品应用标签名
	
	public Integer getSacId() {
		return sacId;
	}
	public void setSacId(Integer sacId) {
		this.sacId = sacId;
	}
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public Integer getAppCateId() {
		return appCateId;
	}
	public void setAppCateId(Integer appCateId) {
		this.appCateId = appCateId;
	}
	public String getAppCateName() {
		return appCateName;
	}
	public void setAppCateName(String appCateName) {
		this.appCateName = appCateName;
	}
}
