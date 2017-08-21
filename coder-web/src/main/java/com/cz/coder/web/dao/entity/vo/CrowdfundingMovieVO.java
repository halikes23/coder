package com.fq.dao.entity.vo;

/**
 * 
 * @ClassName MovieInfoVO  
 * @Description 视频信息VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-30
 */
public class CrowdfundingMovieVO {
	private String  mId ; // 视频ID
	private String  title ; 	// 影片标题
	private String 	account ;   //投稿人账号
	private String  userNick ;	// 投稿人名称
	private String  tags ; 	// 标签
	private String  playNums ; 	// 播放数量
	private String  likeNums ; 	// 点赞次数
	private String  capitalCurrent ; // 当前加血量
	private String  writeDate ; 	// 上传日期
	private String  state ; // 影片状态  H.正在补血，A.满血待拍，P.可以播放,N.未进入补血阶段
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getCapitalCurrent() {
		return capitalCurrent;
	}
	public void setCapitalCurrent(String capitalCurrent) {
		this.capitalCurrent = capitalCurrent;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
