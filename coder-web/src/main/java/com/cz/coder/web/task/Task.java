package com.fq.task;

import com.fq.common.constant.RetCodeEnum;

public interface Task<T> {

	public RetCodeEnum execute(T data) throws Exception ;
	
	public RetCodeEnum doExecute(T data) throws Exception ;
	
}
