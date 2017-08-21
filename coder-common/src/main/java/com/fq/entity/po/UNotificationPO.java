package com.fq.entity.po;

/**
 * 消息PO
 * @author zhen.cheng
 *
 */
public class UNotificationPO  {

	/**
	 * 消息编号
	 */
	private Integer mnId ;
	/**
	 * 消息发送对象账号
	 */
	private String notifyAccount ;
	/**
	 * 消息发送人账号
	 */
	private String oprAccount ;
	/**
	 * 项目编号
	 */
	private Integer piId ;
	/**
	 * 消息模块编号
	 */
	private Integer notifyModuleId ;
	/**
	 * 反馈编号
	 */
	private Integer fId ;
	/**
	 * 原始内容
	 */
	private String content ;
	/**
	 * 通知时间
	 */
	private String createDate ;
	/**
	 * 创建人
	 */
	private String creator ;
	/**
	 * 通知类型（1.日志评论的回复 ， 2.评论的回复 ， 3，评论回复的回复，4:系统消息 , 5:追剧消息，  7. 收礼语音回复 ，8，拆礼物提醒收礼消息，9：漫画更新提示，10：反馈回复）
	 */
	private String notifyType ;
	/**
	 * 是否已读（Y: 已读  N: 未读）
	 */
	private String isReaded ;
	/**
	 * 客户端类型A:android;I:IOS;BOTH:B
	 */
	private String clientType ;
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
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
}
