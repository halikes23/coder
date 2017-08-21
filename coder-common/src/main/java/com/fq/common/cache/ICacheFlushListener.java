package com.fq.common.cache;

public interface ICacheFlushListener {

	public void flushHandle(Object param) ;
	
	public void start() ;
	
	public void register() ;
	
}
