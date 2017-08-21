package com.fq.entity.vo.wallet;
/**
 * 用户红包对象实体类
 * @author chen.zhao 
 *
 */
public class UserRedPacketVO {
	
	private Integer ureId ; // 红包ID
	
	private String account  ; // 用户账号
	
	private Integer cashAmt ; // 红包金额 （分）
	
	private Integer inviteNum ; // 邀请用户数量
	
	private String  usedState ; // 使用类型 ： 0 ：不可用 ； 1 ：已使用  ； 2 ：未使用
	
	private String way ; // 获取红包的方式  ： 1 ： 邀请好友 ； 2  ： 被邀请
	
	private String createDt ;  // 创建日期
	
	private String createTm ; // 创建时间
	
	private String batchNo ; // 红包结算批次号
	
	private Integer limitNum ; // 该红包人数限制
	
	private String openDt ; //  拆红包日期
	
	private String openTm  ; // 拆红包时间 
	
	private String rprdId ; // 红包配置类型表主键
	

	public Integer getUreId() {
		return ureId;
	}

	public void setUreId(Integer ureId) {
		this.ureId = ureId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(Integer cashAmt) {
		this.cashAmt = cashAmt;
	}

	public Integer getInviteNum() {
		return inviteNum;
	}

	public void setInviteNum(Integer inviteNum) {
		this.inviteNum = inviteNum;
	}

	public String getUsedState() {
		return usedState;
	}

	public void setUsedState(String usedState) {
		this.usedState = usedState;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
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

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getOpenTm() {
		return openTm;
	}

	public void setOpenTm(String openTm) {
		this.openTm = openTm;
	}
	
	public String getRprdId() {
		return rprdId;
	}

	public void setRprdId(String rprdId) {
		this.rprdId = rprdId;
	}

	
 }
