package com.fq.dao.entity.vo.notification;

/**
 * 
 * @ClassName SysNotificationVO  
 * @Description 系统消息提示VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-6-7
 */
public class SysNotificationVO {

	private Integer msnId ; // 主键id
	private String oprAccount ; // 消息来源
	private String content ; // 消息内容
	private String createDate ;//时间
	private String state ;//是否已删除
	private String clientType;
	
	public Integer getMsnId() {
		return msnId;
	}
	public void setMsnId(Integer msnId) {
		this.msnId = msnId;
	}
	public String getOprAccount() {
		return oprAccount;
	}
	public void setOprAccount(String oprAccount) {
		this.oprAccount = oprAccount;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
}
