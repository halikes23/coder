package com.fq.entity.vo.reward;

public class RewardWithdrawAppVO {

	
	private Integer  rwaId ; // 主键ID
	
	private String  account ; // 用户账号
	
	private String  name ; // 姓名
	
	private Integer withdrawAmt ; // 兑换赏金数量 
	
	private String  mobile ; // 手机号
	
	private String  QQ ; // QQ号
	
	private String  wxId ; // 微信号
	
	private String  zfbAccount ; // 支付宝账号
	
	private String tradeState ; // 提现状态：1：申请中；2：提现成功；3：提现失败；4：已撤销
	
	private String adminAccount ; 
	
	private String  createDt ;  // 变更日期 
	
	private String  createTm ;  // 变更时间 
	
	private String   userNick ; //用户昵称 
	
	private Integer rewardAmt ; //用户可用赏金数
	
	public Integer getRwaId() {
		return rwaId;
	}

	public void setRwaId(Integer rwaId) {
		this.rwaId = rwaId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWithdrawAmt() {
		return withdrawAmt;
	}

	public void setWithdrawAmt(Integer withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public String getZfbAccount() {
		return zfbAccount;
	}

	public void setZfbAccount(String zfbAccount) {
		this.zfbAccount = zfbAccount;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
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

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public Integer getRewardAmt() {
		return rewardAmt;
	}

	public void setRewardAmt(Integer rewardAmt) {
		this.rewardAmt = rewardAmt;
	}
	
	
	
}
