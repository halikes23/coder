package com.fq.form.qiniu;

public class UploadResourceForm {
	
	private String resourceType;
	private String remark ;
	private String resourceName ;
	private String qiniuKey ;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getQiniuKey() {
		return qiniuKey;
	}
	public void setQiniuKey(String qiniuKey) {
		this.qiniuKey = qiniuKey;
	}
	
	
}
