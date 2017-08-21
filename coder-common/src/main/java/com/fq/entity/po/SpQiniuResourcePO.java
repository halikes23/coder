package com.fq.entity.po;

public class SpQiniuResourcePO {

	private Integer rId ;

	private String qiniuKey ;

	private String localPath ;
	
	private String resourceName ;
	
	private String remark ;
	
	private String resourceType;
	
	private String createDt ;
	private Integer creator ;
	private String modifyDt ;
	private Integer modifier ;
	
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getQiniuKey() {
		return qiniuKey;
	}
	public void setQiniuKey(String qiniuKey) {
		this.qiniuKey = qiniuKey;
	}
	public String getLocalPath() {
		return localPath;
	}
	
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getModifier() {
		return modifier;
	}
	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	public String getModifyDt() {
		return modifyDt;
	}
	public void setModifyDt(String modifyDt) {
		this.modifyDt = modifyDt;
	}
	
}
