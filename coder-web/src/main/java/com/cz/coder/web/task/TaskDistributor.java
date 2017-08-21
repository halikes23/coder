package com.fq.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fq.exception.JnwtvException;


/**
 * 任务分发器
 * @author zhen.cheng
 *
 */
public abstract class TaskDistributor<T> {
	
	public List<T> distribute(Map<String,Object> param , Integer pageSize){
		
		if(pageSize == null ) pageSize = 5000 ;
		List<T> dataList = new ArrayList<T>() ;
		
		Integer totalCount = getTotalCount(param) ;
		
		Integer pageCount ;
		
		if( totalCount % pageSize == 0 ){
			pageCount = totalCount / pageSize;
		}else{
			pageCount = totalCount / pageSize + 1 ; 
		}
		
		for( int i = 0 ; i < pageCount  ; i ++ ){
			
			PageInfo pageInfo = new PageInfo () ;
			pageInfo.setBegin(i*pageSize);
			pageInfo.setPageSize(pageSize);
			pageInfo.setDataCount(totalCount);
			
			T data = prepareData(param,pageInfo);
			dataList.add(data) ;
		}
		
		return dataList ;
		
	}
	
	public abstract Integer getTotalCount(Map<String,Object> param) throws JnwtvException;
	
	public abstract T prepareData(Map<String,Object> params , PageInfo pageInfo) throws JnwtvException;
	
}
