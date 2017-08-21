package com.fq.message.sender;

public interface IMessageSender<T> {

	public void send( String title , String content , T target ) throws Exception;
	
}
