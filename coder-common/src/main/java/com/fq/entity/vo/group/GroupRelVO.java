package com.fq.entity.vo.group;

public class GroupRelVO {
	private Integer grId ; //抓紧ID
	private Integer gcId ; //项目分组ID
	private Integer busiId ; //业务id  项目id 漫画id 小说id 
	private String  busiType ; //业务类型：1：项目（图片剧） ；2：漫画；3：小说 
	private String  adminAccount ; //管理员
	private String  createDt ; 
	private String  createTm ; 
	private String  isDeleted ;
	private String  projectName ; //图片剧名
	private String  cartoonTitle ; //漫画名
	private String  novelName ; //小说名
	private String  busiName ; //绑定的业务名称
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getGcId() {
		return gcId;
	}
	public void setGcId(Integer gcId) {
		this.gcId = gcId;
	}
	public Integer getBusiId() {
		return busiId;
	}
	public void setBusiId(Integer busiId) {
		this.busiId = busiId;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public String getNovelName() {
		return novelName;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	public String getBusiName() {
		return busiName;
	}
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	} 
	
}
