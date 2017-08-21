package com.fq.dao.entity.po;

/**
 * 
 * @ClassName PersonalRankPO  
 * @Description 个人榜单PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-24
 */
public class PersonalRankPO {

	private Integer rankNo ;  	// 排序
	private Integer userSn ;	// 用户id
	private Integer rankRecent ;	// 最近一周打赏量
	private Integer rankTotal ;// 总赏金
	private Integer sendMost ;// 打赏最多的人打赏的量
	private Integer rankNums4 ;// 0
	private Integer rankNums5 ;// 0
	private String sendMostAccount ;	// 打赏最多的人的账号
	private String  account ; 	// 被打赏人的账户
	
	public Integer getRankNo() {
		return rankNo;
	}
	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public Integer getRankRecent() {
		return rankRecent;
	}
	public void setRankRecent(Integer rankRecent) {
		this.rankRecent = rankRecent;
	}
	public Integer getRankTotal() {
		return rankTotal;
	}
	public void setRankTotal(Integer rankTotal) {
		this.rankTotal = rankTotal;
	}
	public Integer getSendMost() {
		return sendMost;
	}
	public void setSendMost(Integer sendMost) {
		this.sendMost = sendMost;
	}
	public Integer getRankNums4() {
		return rankNums4;
	}
	public void setRankNums4(Integer rankNums4) {
		this.rankNums4 = rankNums4;
	}
	public Integer getRankNums5() {
		return rankNums5;
	}
	public void setRankNums5(Integer rankNums5) {
		this.rankNums5 = rankNums5;
	}
	public String getSendMostAccount() {
		return sendMostAccount;
	}
	public void setSendMostAccount(String sendMostAccount) {
		this.sendMostAccount = sendMostAccount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
