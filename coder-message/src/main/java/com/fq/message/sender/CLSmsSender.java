package com.fq.message.sender;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bcloud.msg.http.HttpSender;

public class CLSmsSender implements IMessageSender<String>{

	//	"http://222.73.117.156/msg/HttpBatchSendSM?"
//	private final static String URI=GlobalProperties.SMS_URL;//应用地址
//	private final static String CL_ACCOUNT=GlobalProperties.SMS_USERNAME ;//账号
//	private final static String CL_PWD=GlobalProperties.SMS_PSD;//密码
	
	private String uri ;
	private String clAccount ;
	private String clPwd ;
	private final static String EXTNO = "001" ;
	private final static String PRODUCT = "" ;
	
	private final static Logger logger = LoggerFactory.getLogger(CLSmsSender.class) ;
	
	@Override
	public void send(String title, String content, String target)
			throws Exception {
		
		boolean needstatus = false;//是否需要状态报告，需要true，不需要false
		try {
			
//			String returnString = HttpSender.send(uri, clAccount, clPwd, target, content, needstatus, PRODUCT, EXTNO);
			String returnString = HttpSender.batchSend(uri, clAccount, clPwd, target, content, needstatus,PRODUCT, EXTNO);
			logger.info(returnString);
			
		} catch (Exception e) {
			logger.error("",e);
		}
		
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getClAccount() {
		return clAccount;
	}

	public void setClAccount(String clAccount) {
		this.clAccount = clAccount;
	}

	public String getClPwd() {
		return clPwd;
	}

	public void setClPwd(String clPwd) {
		this.clPwd = clPwd;
	}
	
	
	
	
	
}
