package com.cz.coder.common.constant;

public enum RetCodeEnum {

	SUCCESS("0","成功") ;
	
	private String code ;
	private String codeMsg ;
	
	private RetCodeEnum(String code , String codeMsg){
		this.code = code ;
		this.codeMsg = codeMsg ;
	}

	public String getCode() {
		return code;
	}

	public String getCodeMsg() {
		return codeMsg;
	}
	
}
