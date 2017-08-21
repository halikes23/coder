package com.fq.entity.vo;

public class SpQiniuResourceVO {

	/**
	 * ��������
	 */
	private Integer rId ;
	/**
	 * ��ţKEY
	 */
	private String qiniuKey ;
	/**
	 * ��Դ����·��
	 */
	private String localPath ;
	/**
	 * ��Դ���
	 */
	private String resourceName ;
	/**
	 * ��Դ����
	 */
	private String remark ;
	/**
	 * 资源分类
	 */
	private String resourceType;
	
	private String createDt ;
	private Integer creator ;
	private String creatorName ;
	private String modifyDt ;
	private Integer modifier ;
	private String modifierName ;
	
	private String url ;
	
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Integer getModifier() {
		return modifier;
	}
	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	public String getModifierName() {
		return modifierName;
	}
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}
	public String getModifyDt() {
		return modifyDt;
	}
	public void setModifyDt(String modifyDt) {
		this.modifyDt = modifyDt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
