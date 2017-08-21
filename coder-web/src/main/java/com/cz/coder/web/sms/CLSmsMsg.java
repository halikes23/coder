//package com.fq.sms;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.bcloud.msg.http.HttpSender;
//import com.fq.common.sms.SmsMsg;
//import com.fq.properties.GlobalProperties;
//
//@Service
//public class CLSmsMsg implements SmsMsg{
//
//	private final static Logger logger = LoggerFactory.getLogger(SmsMsg.class);
//	
//	//	//	"http://222.73.117.156/msg/HttpBatchSendSM?"
//	private final static String URI=GlobalProperties.SMS_URL;//应用地址
//	private final static String CL_ACCOUNT=GlobalProperties.SMS_USERNAME ;//账号
//	private final static String CL_PWD=GlobalProperties.SMS_PSD;//密码
//	
//	public void sendMsg(String mobile , String msg){			
//		String uri = URI;//应用地址
//		String account = CL_ACCOUNT;//账号
//		String pswd = CL_PWD;//密码
//		String mobiles = mobile;
//		String content = msg;//短信内容
//		boolean needstatus = false;//是否需要状态报告，需要true，不需要false
//		String product = "";//产品ID
//		String extno = "001";//扩展码
//		try {
//			String returnString = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, extno);
//			logger.info(returnString);
//		} catch (Exception e) {
//			logger.error("",e);
//		}
//	}
//	
//	public static void main(String[] args) {
//		String uri = "http://222.73.117.158/msg/main.do"; //  "http://222.73.117.158:80/msg/HttpBatchSendSM";//应用地址
//		String account = "junengw";//账号
//		String pswd = "Jnw158158 ";//密码
//		String mobiles = "15601732620";//手机号码，多个号码使用","分割
//		String content = "创蓝短信验证码：";//短信内容
//		boolean needstatus = true;//是否需要状态报告，需要true，不需要false
//		String product = "";//产品ID
//		String extno = "001";//扩展码
//		try {
//			String returnString = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, extno);
//			System.out.println(returnString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	} 
//
//	
//}
