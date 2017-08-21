package com.fq.properties;

import java.util.Properties;

import com.fq.constant.ThirdConsoleConstant;
import com.fq.util.ConfigUtil;

public class MagicWindowProperites {

	//account_key
	public final static String ACCOUNT_KEY ;
	//secret_code
	public final static String SECRET_CODE ;
	
	public final static String PRODUCT_KEY;
	
	static{
		Properties prop = ConfigUtil.readProperty( ThirdConsoleConstant.CFG_BASE_PATH +"MagicWindow.properties" ) ;
		
		ACCOUNT_KEY = prop.get("ACCOUNT_KEY").toString();
		SECRET_CODE = prop.get("SECRET_CODE").toString();
		PRODUCT_KEY = prop.get("PRODUCT_KEY").toString();
		
	}
}
