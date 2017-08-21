package com.fq.util.demo;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Key {

	private int hashCode ;
	private String id ;
	private String functionId ;
	
	private Key(){
		
	}
	
	public static Key buildKey( String id , String functionId  ){
		
		Key key = new Key() ;
		key.hashCode = (id + "_" + functionId).hashCode() ;
		
		System.out.println( key.hashCode );
		key.id = id ;
		key.functionId = functionId ;
		return key ;
		
	}
	
	@Override
	public int hashCode(){
		
		return hashCode ;
		
	}
	
	@Override
	public boolean equals( Object obj ){
		
		if( obj == null || ! Key.class.isInstance(obj) ){
			return false ;
		}
		
		Key compareKey = (Key)obj ;
		if( compareKey.id.equals( this.id ) && compareKey.id.equals( this.functionId ) ){
			return true ;
		}
		return false ;
		
	}
	
	public static void main(String[] args) {
		Key key1 = Key.buildKey("1", "1") ;
		Key key2 = Key.buildKey("1", "2 123123") ;
		
		System.out.println( key1.hashCode() );
		System.out.println( key2.hashCode() );
		
	}
	
	
}
