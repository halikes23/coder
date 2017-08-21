package com.fq.dao.entity.vo;

/**
 * 启动页实体
 * @author Administrator
 *
 */
public class StartPageVO {
	private Integer spId ;
	private String imgQiniuKey ; 
	private String updateDate ;
	private String isDeleted ;
	private String createDate ;
	private String trueUrl;//转换成的七牛KeyURL
	
	public String getTrueUrl() {
		return trueUrl;
	}
	public void setTrueUrl(String trueUrl) {
		this.trueUrl = trueUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public String getImgQiniuKey() {
		return imgQiniuKey;
	}
	public void setImgQiniuKey(String imgQiniuKey) {
		this.imgQiniuKey = imgQiniuKey;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
