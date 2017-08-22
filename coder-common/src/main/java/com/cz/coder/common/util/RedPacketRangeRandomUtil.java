package com.cz.coder.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedPacketRangeRandomUtil {

	
	public static IRandomBean random( IRandomBean ... data ){
		return randomlist( Arrays.asList(data) ) ; 
	}
	
	public static IRandomBean randomlist( List< IRandomBean> data ){
		
		IRandomBean rst = null ;
		
		Integer total = 0 ;
		
		List<IRandomBean> beans = new ArrayList<IRandomBean>() ;
		 
		for(IRandomBean bean : data){
			total += bean.getCount() ;
			if(bean.getCount() > 0){
				beans.add(bean) ;
			}
		}
		
		if(beans.size() == 1){
			return beans.get(0) ;
		}
		
		double random = Math.random() * total;
		System.out.println( "random:"+random );
		
		Integer count = 0 ;
		
		for( IRandomBean bean : beans ){
			int max = count + bean.getCount() ;
			
			if( random >= count && random <= max ){
				rst = bean ;
				break ;
			}
			count += bean.getCount() ;
		}
		
		return rst ;
		
	}
	
}
