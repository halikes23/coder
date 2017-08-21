package com.fq.dao.entity.vo.report;


public class TradeConsumeReportVO implements Comparable<String>{

	private String beginDate ;
	private String registerCnt ;
	private String clientType ;
	private String clientChannel ;
	private String clientChannelName ;
	private String cycle1 ;
	private String cycle7 ;
	private String cycle30 ;
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getRegisterCnt() {
		return registerCnt;
	}
	public void setRegisterCnt(String registerCnt) {
		this.registerCnt = registerCnt;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getCycle1() {
		return cycle1;
	}
	public void setCycle1(String cycle1) {
		this.cycle1 = cycle1;
	}
	public String getCycle7() {
		return cycle7;
	}
	public void setCycle7(String cycle7) {
		this.cycle7 = cycle7;
	}
	public String getCycle30() {
		return cycle30;
	}
	public void setCycle30(String cycle30) {
		this.cycle30 = cycle30;
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
	public int compareTo(String o) {
		
		String key = beginDate + "_" + clientType ;
		
		return o.compareTo(key);
	}
	
	
	
	
}
