package com.fq.dao.entity.po;

public class ServerPO {
	
	private String serviceName;
	
	private String serviceUrl;
	
	private String dataSourceFlag;

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

	public String getDataSourceFlag() {
		return dataSourceFlag;
	}

	public void setDataSourceFlag(String dataSourceFlag) {
		this.dataSourceFlag = dataSourceFlag;
	}

	public ServerPO(String serviceName, String serviceUrl, String dataSourceFlag) {
		super();
		this.serviceName = serviceName;
		this.serviceUrl = serviceUrl;
		this.dataSourceFlag = dataSourceFlag;
	}
	
}
