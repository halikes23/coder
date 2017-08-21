package com.fq.dao.entity.vo;

/**
 * 
 * @ClassName ProjectInfoVO  
 * @Description 项目信息VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-3-4
 */
public class ProjectInfoVO {
    private Integer  piId ; // 项目id
	private String   projectName ; // 项目名
	private String   projectOwnerAccount ; // 剧主账号
	private Integer  projectLogNums ; // 日志数量
	private Integer  projectCommNums ; // 评论次数
	private String   isUse ; // 是否在首页显示，Y：使用中；N：不使用
	private String   projectType ; // 类型:D:成片版 C：筹片版 B：精品版
	private String 	projectDesc; // 项目简介【剧情】
	private String  projectDescOriginal; //[原著]
	private String  projectDescBackground; //[背景]
	private String  recommendDesc; //推荐位猜你喜欢一句话
	private Integer  projectTotalEpisode ; // 总集数
	private Integer  projectUpdateEpisode ; // 已经更新的集数
	private String   haveFinished ; // 是否已完结 : Y:已完结 N：更新中
	private String   projectCoverUrl ; // 项目封面qiniukey
	private String   crowdfundingProjectCoverUrl ; // 项目封面crowdfundingProjectCoverUrl
	private Integer  projectPlayNums ; // 项目播放次数
	private Integer  projectRewardTotal ; // 项目被打赏总数
	private String   projectTags ; // 项目标签
	private String   projectFirstBloodAccount ; // 项目一血账号
	private String   projectBigPapaAccount ; // 项目大爸爸账号
	private Integer  projectCapitalTotal ; // 项目每一集众筹上限
	private String   createDate ; // 项目创建日期
	private String   ownerThinkingTitle ; // 宣言标题
	private String   ownerThinkingContent ; // 宣言内容
	private String	 freeEpisode = "0";
	private String 	 unlockJpoint = "0";
	private String   unlockTM;
	private String 	 isCharge;
	private String 	 projectAuthor;
	private String 	 projectOriginalUrl;
	private String 	 downloadLinkAndroid;
	private String   downloadLinkIos;
	private String   haveLiveCartoon ; 
	private Integer  plcId ;
	private String   projectGroupCode ;
	private String   projectSubType ;  //项目子类型
	private String   isShowPapa;//是否展示守护神列表
	
	public String getProjectAuthor() {
		return projectAuthor;
	}
	public void setProjectAuthor(String projectAuthor) {
		this.projectAuthor = projectAuthor;
	}
	public String getProjectOriginalUrl() {
		return projectOriginalUrl;
	}
	public void setProjectOriginalUrl(String projectOriginalUrl) {
		this.projectOriginalUrl = projectOriginalUrl;
	}
	public String getDownloadLinkAndroid() {
		return downloadLinkAndroid;
	}
	public void setDownloadLinkAndroid(String downloadLinkAndroid) {
		this.downloadLinkAndroid = downloadLinkAndroid;
	}
	public String getDownloadLinkIos() {
		return downloadLinkIos;
	}
	public void setDownloadLinkIos(String downloadLinkIos) {
		this.downloadLinkIos = downloadLinkIos;
	}
	public String getFreeEpisode() {
		return freeEpisode;
	}
	public void setFreeEpisode(String freeEpisode) {
		this.freeEpisode = freeEpisode;
	}
	public String getUnlockJpoint() {
		return unlockJpoint;
	}
	public void setUnlockJpoint(String unlockJpoint) {
		this.unlockJpoint = unlockJpoint;
	}
	public String getUnlockTM() {
		return unlockTM;
	}
	public void setUnlockTM(String unlockTM) {
		this.unlockTM = unlockTM;
	}
	public String getIsCharge() {
		return isCharge;
	}
	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectOwnerAccount() {
		return projectOwnerAccount;
	}
	public void setProjectOwnerAccount(String projectOwnerAccount) {
		this.projectOwnerAccount = projectOwnerAccount;
	}
	public Integer getProjectLogNums() {
		return projectLogNums;
	}
	public void setProjectLogNums(Integer projectLogNums) {
		this.projectLogNums = projectLogNums;
	}
	public Integer getProjectCommNums() {
		return projectCommNums;
	}
	public void setProjectCommNums(Integer projectCommNums) {
		this.projectCommNums = projectCommNums;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public Integer getProjectTotalEpisode() {
		return projectTotalEpisode;
	}
	public void setProjectTotalEpisode(Integer projectTotalEpisode) {
		this.projectTotalEpisode = projectTotalEpisode;
	}
	public Integer getProjectUpdateEpisode() {
		return projectUpdateEpisode;
	}
	public void setProjectUpdateEpisode(Integer projectUpdateEpisode) {
		this.projectUpdateEpisode = projectUpdateEpisode;
	}
	public String getHaveFinished() {
		return haveFinished;
	}
	public void setHaveFinished(String haveFinished) {
		this.haveFinished = haveFinished;
	}
	public String getProjectCoverUrl() {
		return projectCoverUrl;
	}
	public void setProjectCoverUrl(String projectCoverUrl) {
		this.projectCoverUrl = projectCoverUrl;
	}
	public Integer getProjectPlayNums() {
		return projectPlayNums;
	}
	public void setProjectPlayNums(Integer projectPlayNums) {
		this.projectPlayNums = projectPlayNums;
	}
	public Integer getProjectRewardTotal() {
		return projectRewardTotal;
	}
	public void setProjectRewardTotal(Integer projectRewardTotal) {
		this.projectRewardTotal = projectRewardTotal;
	}
	public String getProjectTags() {
		return projectTags;
	}
	public void setProjectTags(String projectTags) {
		this.projectTags = projectTags;
	}
	public String getProjectFirstBloodAccount() {
		return projectFirstBloodAccount;
	}
	public void setProjectFirstBloodAccount(String projectFirstBloodAccount) {
		this.projectFirstBloodAccount = projectFirstBloodAccount;
	}
	public String getProjectBigPapaAccount() {
		return projectBigPapaAccount;
	}
	public void setProjectBigPapaAccount(String projectBigPapaAccount) {
		this.projectBigPapaAccount = projectBigPapaAccount;
	}
	public Integer getProjectCapitalTotal() {
		return projectCapitalTotal;
	}
	public void setProjectCapitalTotal(Integer projectCapitalTotal) {
		this.projectCapitalTotal = projectCapitalTotal;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOwnerThinkingTitle() {
		return ownerThinkingTitle;
	}
	public void setOwnerThinkingTitle(String ownerThinkingTitle) {
		this.ownerThinkingTitle = ownerThinkingTitle;
	}
	public String getOwnerThinkingContent() {
		return ownerThinkingContent;
	}
	public void setOwnerThinkingContent(String ownerThinkingContent) {
		this.ownerThinkingContent = ownerThinkingContent;
	}
	public String getCrowdfundingProjectCoverUrl() {
		return crowdfundingProjectCoverUrl;
	}
	public void setCrowdfundingProjectCoverUrl(String crowdfundingProjectCoverUrl) {
		this.crowdfundingProjectCoverUrl = crowdfundingProjectCoverUrl;
	}
	public String getProjectDescOriginal() {
		return projectDescOriginal;
	}
	public void setProjectDescOriginal(String projectDescOriginal) {
		this.projectDescOriginal = projectDescOriginal;
	}
	public String getProjectDescBackground() {
		return projectDescBackground;
	}
	public void setProjectDescBackground(String projectDescBackground) {
		this.projectDescBackground = projectDescBackground;
	}
	public String getRecommendDesc() {
		return recommendDesc;
	}
	public void setRecommendDesc(String recommendDesc) {
		this.recommendDesc = recommendDesc;
	}
	public String getHaveLiveCartoon() {
		return haveLiveCartoon;
	}
	public void setHaveLiveCartoon(String haveLiveCartoon) {
		this.haveLiveCartoon = haveLiveCartoon;
	}
	public Integer getPlcId() {
		return plcId;
	}
	public void setPlcId(Integer plcId) {
		this.plcId = plcId;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public String getProjectSubType() {
		return projectSubType;
	}
	public void setProjectSubType(String projectSubType) {
		this.projectSubType = projectSubType;
	}
	public String getIsShowPapa() {
		return isShowPapa;
	}
	public void setIsShowPapa(String isShowPapa) {
		this.isShowPapa = isShowPapa;
	}
	
	
}
