package com.fq.dao.entity.vo.user;

public class AddNewUserVO {
	
	private String  account;
	private String  pwd ;
	private String  userNick = "jnw";
	private Integer jpoint = 0;
	public Integer getJpoint() {
		return jpoint;
	}
	public void setJpoint(Integer jpoint) {
		this.jpoint = jpoint;
	}
	private Integer rewardMount = 0;
	private Integer attentionNums = 0;
	private Integer followerNums = 0;
	private Integer favouiteNums = 0;
	private String  userRole ;
	private String  address ;
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
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public AddNewUserVO(String account, String pwd, String userRole) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.userRole = userRole;
	}
	public AddNewUserVO() {}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
