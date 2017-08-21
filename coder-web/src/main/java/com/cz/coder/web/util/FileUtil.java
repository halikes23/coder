package com.fq.util;

import com.sun.star.lang.IllegalArgumentException;
/**
 * 获取文件的后缀
 * @author MaiBenBen
 *
 */
public class FileUtil {
	
	public static String getFileSuffix(String fileName) throws IllegalArgumentException {
		
		Integer idx = fileName.lastIndexOf(".") ;
		
		if( idx == -1 ){
			throw new IllegalArgumentException() ;
		}
		
		String suffix = fileName.substring(idx + 1) ;
		
		return suffix ;
		
	}
	
}
