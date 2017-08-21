package com.fq.util.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

	private Map<Key, Integer> counts ;
	
	public void put( String acctId , String functionId , Integer count){
		counts.put(Key.buildKey(acctId, functionId), count ) ;
		
	}
	
	public void addCount( String id , String functionId ){
		
		Key key = Key.buildKey( id , functionId);
		
		Integer count = counts.get( key ) ;
		
		if( count == null ){
			counts.put( key , 1 ) ;
		}else{
			counts.put( key , count + 1) ;
		}
		
	}
	
	public void setZero( String id , String functionId ){
		Key key = Key.buildKey( id , functionId);
		
		Integer count = counts.get( key ) ;
		
		if( count != null ){
			counts.put( key , 0 ) ;
		}
	}
	
	public Integer get( String id , String functionId ){
		
		Key key = Key.buildKey( id , functionId);
		
		Integer count = counts.get( key ) ;
		
		return count == null ? 0 : count ;
		
	}
	
	public void init( List<Count> list ){
		counts = new HashMap<Key, Integer>() ;
		for( Count count : list ){
			this.put(count.acctId , count.functionId , count.count) ;
		}
	}
	
	public static void main(String[] args) {
		
		Context context = new Context() ;
		
		Count count1 = new Count();
		count1.acctId = "1" ;
		count1.functionId = "2" ;
		count1.count = 5 ;	
		
		Count count2 = new Count();
		count1.acctId = "2" ;
		count1.functionId = "2" ;
		count1.count = 3 ;
		
		context.init( Arrays.asList( new Count[]{ count1 , count2 } ) ) ;
		
		System.out.println( context.get( "1" , "2" ) );
		
		
	}
	
	
}

class Count{
	
	public String acctId ;
	public String functionId ;
	public Integer count ;
	
}
