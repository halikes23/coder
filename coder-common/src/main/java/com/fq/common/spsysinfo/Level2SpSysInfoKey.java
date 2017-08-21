package com.fq.common.spsysinfo;

import com.fq.common.constant.CommonConstant;

/**
 * key1,key2缓存KEY
 * @author zhen.cheng
 *
 */
public class Level2SpSysInfoKey {

	private Level2SpSysInfoKey(){}
	
	private String key1 ;
	private String key2 ;
	
	public final static Level2SpSysInfoKey build(String key1 , String key2){
		
		Level2SpSysInfoKey key = new Level2SpSysInfoKey() ;
		
		key.key1 = key1 ;
		key.key2 = key2 ;
		
		return key ;
		
	}
	
	@Override
	public int hashCode(){
		
		StringBuilder key = new StringBuilder() ;
		key.append(key1).append(CommonConstant.SYMBOL_UNDERLINE).append(key2);
		return key.toString().hashCode() ;
		
	}
	
	@Override
	public boolean equals(Object c){
		
		if( c == null ){
			return false ;
		}
		if( !Level2SpSysInfoKey.class.isInstance(c) ){
			return false ;
		}
		Level2SpSysInfoKey compareKey = (Level2SpSysInfoKey)c;
		if( !( compareKey.getKey1().equals(this.getKey1()) &&  
			   compareKey.getKey2().equals(this.getKey2()) ) ){
			return false ;
		}else{
			return true ;
		}
		
	}

	String getKey1() {
		return key1;
	}

	String getKey2() {
		return key2;
	}
	
	
	
}
