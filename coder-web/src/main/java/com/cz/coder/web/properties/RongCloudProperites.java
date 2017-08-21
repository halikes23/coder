package com.fq.properties;

import java.util.Properties;

import com.fq.constant.ThirdConsoleConstant;
import com.fq.util.ConfigUtil;

public class RongCloudProperites {

	
	public final static String APP_KEY   ;
	
	public final static String APP_SECRET  ;
	
	static{
		Properties prop = ConfigUtil.readProperty( ThirdConsoleConstant.CFG_BASE_PATH +"RongCloud.properties" ) ;
		
		APP_KEY = prop.get("APP_KEY").toString();
		APP_SECRET = prop.get("APP_SECRET").toString();
	
	}
}
