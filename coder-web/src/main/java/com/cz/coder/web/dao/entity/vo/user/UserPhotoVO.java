package com.fq.dao.entity.vo.user;

/**
 * 用户相册照片
 * @author zhen.cheng
 *
 */
public class UserPhotoVO {

	/**
	 * 用户相片ID
	 */
	private Integer upId ;
	/**
	 * 用户七牛KEY
	 */
	private String imgQiniuKey ;
	/**
	 * 用户七牛URL
	 */
	private String ImgQiniuUrl ;
	/**
	 * 照片上传时间
	 */
	private String dateTime ;
	
	public Integer getUpId() {
		return upId;
	}
	public void setUpId(Integer upId) {
		this.upId = upId;
	}
	public String getImgQiniuKey() {
		return imgQiniuKey;
	}
	public void setImgQiniuKey(String imgQiniuKey) {
		this.imgQiniuKey = imgQiniuKey;
	}
	public String getImgQiniuUrl() {
		return ImgQiniuUrl;
	}
	public void setImgQiniuUrl(String imgQiniuUrl) {
		ImgQiniuUrl = imgQiniuUrl;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
