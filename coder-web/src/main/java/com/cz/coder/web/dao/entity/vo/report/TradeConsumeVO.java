package com.fq.dao.entity.vo.report;

/**
 * 交易消費統計對象
 * @author zhen.cheng
 *
 */
public class TradeConsumeVO {
	
	/**
	 * 创建日期
	 */
	private String createDate ;
	/**
	 * 开始统计日期（用户注册日期）
	 */
	private String beginDate ;
	/**
	 * 报表周期 1、7、30
	 */
	private Integer reportCycle ;
	/**
	 * 注册人数
	 */
	private Integer registerCnt ;
	/**
	 * 交易人数
	 */
	private Integer tradeCnt ;
	/**
	 * 消费人数
	 */
	private Integer consumeCnt ;
	/**
	 * 终端类型 A:android I:IOS N:未知
	 */
	private String clientType ;
	/**
	 * 渠道
	 */
	private String clientChannel ;
	
	/**
	 * 渠道名称
	 */
	private String clientChannelName ;
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public Integer getReportCycle() {
		return reportCycle;
	}
	public void setReportCycle(Integer reportCycle) {
		this.reportCycle = reportCycle;
	}
	public Integer getRegisterCnt() {
		return registerCnt;
	}
	public void setRegisterCnt(Integer registerCnt) {
		this.registerCnt = registerCnt;
	}
	public Integer getTradeCnt() {
		return tradeCnt;
	}
	public void setTradeCnt(Integer tradeCnt) {
		this.tradeCnt = tradeCnt;
	}
	public Integer getConsumeCnt() {
		return consumeCnt;
	}
	public void setConsumeCnt(Integer consumeCnt) {
		this.consumeCnt = consumeCnt;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientChannel() {
		return clientChannel;
	}
	public void setClientChannel(String clientChannel) {
		this.clientChannel = clientChannel;
	}
	public String getClientChannelName() {
		return clientChannelName;
	}
	public void setClientChannelName(String clientChannelName) {
		this.clientChannelName = clientChannelName;
	}
	@Override
	public String toString() {
		return "TradeConsumeVO [createDate=" + createDate + ", beginDate="
				+ beginDate + ", reportCycle=" + reportCycle + ", registerCnt="
				+ registerCnt + ", tradeCnt=" + tradeCnt + ", consumeCnt="
				+ consumeCnt + ", clientType=" + clientType
				+ ", clientChannel=" + clientChannel + ", clientChannelName="
				+ clientChannelName + "]";
	}
	
	
	
}
