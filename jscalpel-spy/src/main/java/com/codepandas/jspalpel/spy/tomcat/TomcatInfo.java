package com.codepandas.jspalpel.spy.tomcat;

import com.codepandas.jspalpel.spy.BaseInfo;

public class TomcatInfo extends BaseInfo{

	private final static String INFO_TYPE_TOMCAT = "TOMCAT_INFO" ;
	
	public TomcatInfo(String ip , Integer processNo){
		super(INFO_TYPE_TOMCAT,ip,processNo) ;
	}
	
	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}

}
