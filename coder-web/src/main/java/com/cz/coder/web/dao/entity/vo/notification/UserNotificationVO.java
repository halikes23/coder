package com.fq.dao.entity.vo.notification;

/**
 * 个人消息页面
 * @author Administrator
 *
 */
public class UserNotificationVO {
	private Integer mnId; 
	private String notifyAccount ;  //通知对象账号（收消息的人）
	private String oprAccount ;  //通知人账号 （发消息的人）
	private String headImgUrl ; //通知人头像 
	private String userNick ;  //通知人昵称
	private Integer piId ;  //项目id
	private Integer notifyModuleId ;    //消息模块id
	private String content ;  //原始内容
	private String createDate ;  //通知时间
	private String notifyType ;  //通知类型（1.日志评论的回复 ， 2.评论的回复 ， 3，评论回复的回复 , 4:系统消息）
	private String isReaded ;  //是否已读（Y: 已读  N: 未读）
	
	public Integer getMnId() {
		return mnId;
	}
	public void setMnId(Integer mnId) {
		this.mnId = mnId;
	}
	public String getNotifyAccount() {
		return notifyAccount;
	}
	public void setNotifyAccount(String notifyAccount) {
		this.notifyAccount = notifyAccount;
	}
	public String getOprAccount() {
		return oprAccount;
	}
	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getNotifyModuleId() {
		return notifyModuleId;
	}
	public void setNotifyModuleId(Integer notifyModuleId) {
		this.notifyModuleId = notifyModuleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public String getIsReaded() {
		return isReaded;
	}
	public void setIsReaded(String isReaded) {
		this.isReaded = isReaded;
	}
	
}
