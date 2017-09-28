package com.codepandas.jspalpel.spy;

public abstract class BaseInfo {

	private String ip ;
	
	private String infoType ;
	
	private Integer processNo ;
	
	protected BaseInfo(String infoType , String ip , Integer processNo){
		this.ip = ip ;
		this.processNo = processNo ;
		this.infoType = infoType ;
	}

	public String getIp() {
		return ip;
	}

	public Integer getProcessNo() {
		return processNo;
	}
	
	protected String getInfoType(){
		return this.getInfoType() ;
	}
	
	public abstract String getData() ;
	
}
