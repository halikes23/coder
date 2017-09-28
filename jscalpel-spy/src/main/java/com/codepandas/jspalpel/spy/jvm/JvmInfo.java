package com.codepandas.jspalpel.spy.jvm;

import com.codepandas.jspalpel.spy.BaseInfo;

public class JvmInfo extends BaseInfo {

private final static String INFO_TYPE_JVM = "JVM_INFO" ;
	
	public JvmInfo(String ip , Integer processNo){
		super(INFO_TYPE_JVM,ip,processNo) ;
	}
	
	@Override
	public String getData() {
		return null;
	}

}
