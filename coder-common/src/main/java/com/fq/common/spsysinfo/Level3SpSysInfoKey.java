package com.fq.common.spsysinfo;

import com.fq.common.constant.CommonConstant;

/**
 * key1,key2,key3缓存KEY
 * @author zhen.cheng
 *
 */
public class Level3SpSysInfoKey {

	private Level3SpSysInfoKey(){}
	
	private String key1 ;
	private String key2 ;
	private String key3 ;
	
	public final static Level3SpSysInfoKey build( String key1 , String key2 , String key3 ){
		
		Level3SpSysInfoKey key = new Level3SpSysInfoKey() ;
		
		key.key1 = key1 ;
		key.key2 = key2 ;
		key.key3 = key3 ;
		
		return key ;
		
	}
	
	@Override
	public int hashCode(){
		
		StringBuilder key = new StringBuilder() ;
		key.append(key1).append(CommonConstant.SYMBOL_UNDERLINE).append(key2).append(CommonConstant.SYMBOL_UNDERLINE).append(key3);
		return key.toString().hashCode() ;
		
	}
	
	public boolean equals(Object c){
		
		if( c == null ){
			return false ;
		}
		if( !Level3SpSysInfoKey.class.isInstance(c) ){
			return false ;
		}
		Level3SpSysInfoKey compareKey = (Level3SpSysInfoKey)c;
		if( !( compareKey.getKey1().equals(this.getKey1()) &&  
			   compareKey.getKey2().equals(this.getKey2()) &&
			   compareKey.getKey2().equals(this.getKey2()) ) ){
			return false ;
		}else{
			return true ;
		}
		
		
	}

	public String getKey1() {
		return key1;
	}

	public String getKey2() {
		return key2;
	}

	public String getKey3() {
		return key3;
	}
	
	
	
	
}
