package com.fq.dao.entity.vo.common;

public class ToChgIOSAuditModelFlagVO {

	private String serviceName;
	
	private String serviceUrl;

	/**
	 * 
	 * IOS audit flag
	 * When the flag is ON , something like crowd-funding will be hidden ;
	 * When the flag is OFF , something like crowd-funding will be shown ;
	 */
	private String auditModelFlag ;
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getAuditModelFlag() {
		return auditModelFlag;
	}

	public void setAuditModelFlag(String auditModelFlag) {
		this.auditModelFlag = auditModelFlag;
	}
	
	
	
	
}
