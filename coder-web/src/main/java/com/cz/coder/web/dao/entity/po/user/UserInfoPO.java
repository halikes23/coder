package com.fq.dao.entity.po.user;

/**
 * 
 * @ClassName UserInfoPO  
 * @Description   
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-4
 */
public class UserInfoPO {

	private Integer userSn;
	private String  account;
	private String  pwd ;
	private String  userNick;
	private String  mobile;
	private String  userDesc;
	private String  headImgUrl;
	private Integer jPoint ;
	private Integer coupon ;
	private Integer rewardMount;
	private Integer attentionNums;
	private Integer followerNums;
	private Integer favouiteNums;
	private String  userType ;
	private Integer sex;
	private String  address;
	private String  idNo;
	private Integer way;
	private Integer userThirdType;
	private String  writeDate ;
	private String  isActive;
	private String  userToken;
	private String  isNp;
	/**
	 * 用户角色 1：普通用户 2：演职人员
	 */
	private String userRole ;
	/**
	 * 演员类型 1：普通演员 2：可配音演员
	 */
	private String userSubRole;
	
	private String isNavy ; 
	private String isVip ; 
	private String isManager ; 
	private String openId ; 
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public Integer getRewardMount() {
		return rewardMount;
	}
	public void setRewardMount(Integer rewardMount) {
		this.rewardMount = rewardMount;
	}
	public Integer getAttentionNums() {
		return attentionNums;
	}
	public void setAttentionNums(Integer attentionNums) {
		this.attentionNums = attentionNums;
	}
	public Integer getFollowerNums() {
		return followerNums;
	}
	public void setFollowerNums(Integer followerNums) {
		this.followerNums = followerNums;
	}
	public Integer getFavouiteNums() {
		return favouiteNums;
	}
	public void setFavouiteNums(Integer favouiteNums) {
		this.favouiteNums = favouiteNums;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public Integer getWay() {
		return way;
	}
	public void setWay(Integer way) {
		this.way = way;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserSubRole() {
		return userSubRole;
	}
	public void setUserSubRole(String userSubRole) {
		this.userSubRole = userSubRole;
	}
	public String getIsNavy() {
		return isNavy;
	}
	public void setIsNavy(String isNavy) {
		this.isNavy = isNavy;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public String getIsManager() {
		return isManager;
	}
	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}
	public Integer getUserThirdType() {
		return userThirdType;
	}
	public void setUserThirdType(Integer userThirdType) {
		this.userThirdType = userThirdType;
	}
	public Integer getCoupon() {
		return coupon;
	}
	public void setCoupon(Integer coupon) {
		this.coupon = coupon;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getIsNp() {
		return isNp;
	}
	public void setIsNp(String isNp) {
		this.isNp = isNp;
	}
	
}
