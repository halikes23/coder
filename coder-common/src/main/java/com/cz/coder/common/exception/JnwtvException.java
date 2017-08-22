package com.cz.coder.common.exception;

public class JnwtvException extends RuntimeException{

	private static final long serialVersionUID = 432112778719633964L;
	
	private String retCode ;
	
	private String msg ;
	
	public JnwtvException( String busiCode ){
		this.retCode = busiCode ;
	}
	
	public JnwtvException( String busiCode , String msg){
		this.retCode = busiCode ;
		this.msg = msg ;
	}
	
	public JnwtvException( String busiCode , Throwable trowable ){
		super(trowable);
		this.retCode = busiCode ;
	}

	public String getRetCode() {
		return retCode;
	}

	public String getMsg() {
		return msg;
	}

}
