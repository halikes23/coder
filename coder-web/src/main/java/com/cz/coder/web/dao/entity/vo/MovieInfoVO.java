package com.fq.dao.entity.vo;

/**
 * 
 * @ClassName MovieInfoVO  
 * @Description 视频信息VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-30
 */
public class MovieInfoVO {
	private String  mId ; // 视频ID
	private String  title ; 	// 影片标题
	private Integer userSn ;
	private String  userNick ;	// 投稿人名称
	private String  playNums ; 	// 播放
	private String  likeNums ; 	// 点赞次数
	private String  rewardTotal ; // 打赏据点
	private String  capitalCurrent ; // 当前加血量
	private String  rewardCount ; // 打赏次数
	private String  shareNums ;  	// 分享次数
	private String  collectionNums ;// 收藏次数
	private String  writeDate ; 	// 上传日期
	private String  mAccount ; // 上传者账号
	private String  mPartCount ;   // 小片段数量             
	private String  nodeIdStart ;	// 投稿人名称
	private String  mDesc ; 	// 播放
	private String  tags ; 	// 点赞次数
	private String  isUse ; // 打赏据点
	private String  coverUrl ; // 打赏次数
	private String  isShareGuide ;  	// 分享次数
	private String  shareUrl ; // 收藏次数
	private String  state ; // 影片状态  H.正在补血，A.满血待拍，P.可以播放,N.未进入补血阶段
	
	public String getCapitalCurrent() {
		return capitalCurrent;
	}
	public void setCapitalCurrent(String capitalCurrent) {
		this.capitalCurrent = capitalCurrent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getPlayNums() {
		return playNums;
	}
	public void setPlayNums(String playNums) {
		this.playNums = playNums;
	}
	public String getLikeNums() {
		return likeNums;
	}
	public void setLikeNums(String likeNums) {
		this.likeNums = likeNums;
	}
	public String getRewardTotal() {
		return rewardTotal;
	}
	public void setRewardTotal(String rewardTotal) {
		this.rewardTotal = rewardTotal;
	}
	public String getRewardCount() {
		return rewardCount;
	}
	public void setRewardCount(String rewardCount) {
		this.rewardCount = rewardCount;
	}
	public String getShareNums() {
		return shareNums;
	}
	public void setShareNums(String shareNums) {
		this.shareNums = shareNums;
	}
	public String getCollectionNums() {
		return collectionNums;
	}
	public void setCollectionNums(String collectionNums) {
		this.collectionNums = collectionNums;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmAccount() {
		return mAccount;
	}
	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}
	public String getmPartCount() {
		return mPartCount;
	}
	public void setmPartCount(String mPartCount) {
		this.mPartCount = mPartCount;
	}
	public String getNodeIdStart() {
		return nodeIdStart;
	}
	public void setNodeIdStart(String nodeIdStart) {
		this.nodeIdStart = nodeIdStart;
	}
	public String getmDesc() {
		return mDesc;
	}
	public void setmDesc(String mDesc) {
		this.mDesc = mDesc;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getIsShareGuide() {
		return isShareGuide;
	}
	public void setIsShareGuide(String isShareGuide) {
		this.isShareGuide = isShareGuide;
	}
	public String getShareUrl() {
		return shareUrl;
	}
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
