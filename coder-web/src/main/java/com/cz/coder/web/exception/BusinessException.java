package com.fq.exception;

/**
 * 业务异常
 * @author zhen.cheng
 *
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -2272371257292073769L;
	
	private String code ;
	
	public BusinessException(String code){
		super() ;
		this.code = code ;
	}

	public String getCode() {
		return code;
	}
	
}
