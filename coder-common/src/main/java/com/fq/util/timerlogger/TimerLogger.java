package com.fq.util.timerlogger;

import java.util.Date;

import org.slf4j.Logger;

public class TimerLogger {

	private Logger logger ;
	
	private Long first ;
	
	private Long begin ;
	
	private Long end ;
	
	private final static String COST_CONTENT_SUFFIX = "{} 执行结束,耗时:{}毫秒 {}秒" ;
	
	private final static String BEGIN_CONTENT_SUFFIX = "{} 执行开始" ;
	
	private TimerLogger(Logger logger){
		first = new Date().getTime() ;
		begin = new Date().getTime() ;
		this.logger = logger ;
	}
	
	public static TimerLogger build(Logger logger){
		return new TimerLogger(logger);
	}
	
	public void begin(){
		this.begin = new Date().getTime() ;
	}
	
	public void begin(String content){
		this.begin = new Date().getTime() ;
		logger.info( BEGIN_CONTENT_SUFFIX , content );
	}
	
	public void endAndNewBegin(String content){
		end(content) ;
		begin = new Date().getTime() ;
	}
	
	public void end(String content){
		end = new Date().getTime();
		Long cost = end - begin ;
		logger.info(COST_CONTENT_SUFFIX,new Object[]{content,cost,cost/1000});
	}
	
	public void endFromFirst(String content){
		end = new Date().getTime();
		Long cost = end - first ;
		logger.info(COST_CONTENT_SUFFIX,new Object[]{content,cost,cost/1000});
	}
	
	public void first(){
		this.first = new Date().getTime() ;
	}
	
	public void first(String content){
		first() ;
		logger.info(content);
	}
	
}
