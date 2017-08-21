package com.fq.message.sender;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class MailSender implements IMessageSender<String[]>{

	
	private String host ;
	
	private String port = "25" ;
	
	
	private String transportProtocol ;
	
	private String isSSL = "false" ;
	
	/**
	 * 发送邮箱
	 */
	private String from ;
	
	/**
	 * 发送邮箱密码
	 */
	private String fromPwd ;
	
	/**
	 * 发送邮件
	 */
	public void send(String title, String content, String[] listTo) throws Exception{
		
		Properties props = new Properties();  
        // 开启debug调试  
        props.setProperty("mail.debug", "false");  
        // 发送服务器需要身份验证  
        props.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        props.setProperty("mail.host", host);  
        // 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", transportProtocol);  
        
        props.setProperty("mail.smtp.connectiontimeout", "2000") ;
        
        props.setProperty("mail.smtp.timeout", "2000") ;
        
        
        
        if( "true".equals(isSSL) ){
        	props.put("mail.smtp.ssl.enable", "true");
            
            MailSSLSocketFactory sf = new MailSSLSocketFactory();  
            sf.setTrustAllHosts(true);
            
            props.put("mail.smtp.ssl.socketFactory", sf);  
        }
        
       
        Authenticator auth = new Authenticator() {
        	@Override
        	protected PasswordAuthentication getPasswordAuthentication(){
        		return new PasswordAuthentication(from,fromPwd);
        	}
        	
		};
        
        // 设置环境信息  
        Session session = Session.getInstance(props,auth);  
          
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        msg.setSubject(title);  
        // 设置邮件内容  
        msg.setText(content);  
        // 设置发件人  
        msg.setFrom(new InternetAddress(from)); 
        
        Address[] addresses = new Address[listTo.length];
        for(int i = 0 ; i < listTo.length ; i ++){
        	addresses[i] = new InternetAddress(listTo[i]);
        }
        
        msg.setRecipients(RecipientType.TO, addresses);
          
        Transport transport = session.getTransport();
        try{
        	Transport.send(msg);
        }catch(Exception e){
//        	System.out.println(new String(e.getMessage().getBytes(),Charset.forName("gbk"))); 
        	throw e ;
        }finally{
        	if(transport != null){
        		transport.close();
        	}
        }
		
	}

	public static void main(String[] args) throws Exception {  
		IMessageSender<String[]> sender = new MailSender();
		
		Method setHost = MailSender.class.getMethod("setHost",String.class) ; 
		setHost.invoke(sender, "smtp.163.com") ;
		Method setFrom = MailSender.class.getMethod("setFrom",String.class) ; 
		setFrom.invoke(sender, "jnwtv_console@163.com") ;
		Method setTransportProtocol = MailSender.class.getMethod("setTransportProtocol",String.class) ; 
		setTransportProtocol.invoke(sender, "smtp") ;
		Method setFromPwd = MailSender.class.getMethod("setFromPwd",String.class) ; 
		setFromPwd.invoke(sender, "2016jnwtv") ;
		
		
		sender.send("JNWTV控制台，验证码", "3877",new String[]{ "chengzhen000000@163.com","56651743@qq.com" });
		
    }  
	
	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}

	public String getFromPwd() {
		return fromPwd;
	}

	public void setFromPwd(String fromPwd) {
		this.fromPwd = fromPwd;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIsSSL() {
		return isSSL;
	}

	public void setIsSSL(String isSSL) {
		this.isSSL = isSSL;
	}
	
	
	
}
