package com.fq.dao.entity.vo.user;

/**
 * 用户信息VO
 * @author zhen.cheng
 *
 */
public class UserInfoVO {
	
	/**
	 * 用户sn
	 */
	private Integer userSn ;
	/**
	 * 用户姓名
	 */
	private String account;
	/**
	 * 用户角色
	 */
	private String userRole;
	/**
	 * 用户昵称
	 */
	private String userNick ;
	/*
	 * 是否是内测用户
	 */
	private String isTester ;
	/*
	 * 是否是水军
	 */
	private String isNavy ;
	
	/**
	 * 剧点
	 */
	private Integer jPoint ;
	
	/**
	 * 用户是否禁言
	 */
	private String isGag ;
	
	/**
	 * 演职人员类别区分
	 */
	
	private String userSubRole ;
	
	/**
	 * 是否是VIP用户
	 */
	
	private String isVip ;
	
	/**
	 * 是否是管理者
	 */
	
	private String isManager ;
	
	/**
	 * VIP过期时间
	 */
	
	private String vipOutDt ;
	
	/**
	 * 注册时间
	 */
	
	private String writeDate ;
	
	/**
	 * 地址
	 */
	private String address ; 
	
	/**
	 * (方式)0:剧能玩用户 1:第三方登陆 2:游客
	 */
	
	private String way ; 
	
	/**
	 * 用户三方类型 1; 微信 2: 微博 3：QQ 
	 */
	private String userThirdType ;
	
	/**
	 * 机型A:android;I:ios
	 */
	private String clientType ;

	private String userToken ;
	
	private String deviceNo ;
	
	public String getUserSubRole() {
		return userSubRole;
	}
	public void setUserSubRole(String userSubRole) {
		this.userSubRole = userSubRole;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public String getVipOutDt() {
		return vipOutDt;
	}
	public void setVipOutDt(String vipOutDt) {
		this.vipOutDt = vipOutDt;
	}
	public String getIsGag() {
		return isGag;
	}
	public void setIsGag(String isGag) {
		this.isGag = isGag;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getIsTester() {
		return isTester;
	}
	public void setIsTester(String isTester) {
		this.isTester = isTester;
	}
	public String getIsNavy() {
		return isNavy;
	}
	public void setIsNavy(String isNavy) {
		this.isNavy = isNavy;
	}
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIsManager() {
		return isManager;
	}
	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getUserThirdType() {
		return userThirdType;
	}
	public void setUserThirdType(String userThirdType) {
		this.userThirdType = userThirdType;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	
}
