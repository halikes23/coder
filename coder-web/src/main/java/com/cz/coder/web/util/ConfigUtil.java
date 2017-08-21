package com.fq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConfigUtil {

	private final static Logger logger = LoggerFactory.getLogger( ConfigUtil.class ) ;
	
	
	/**
	 * 读取Properties文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @return properties 文件类
	 */
	public static Properties readProperty(String filePath) {
         
		Properties prop = new Properties() ;
		
	        System.out.println("--- Properties from Class.getResourceAsStream ---");  
	       
	        try {
	        	InputStream in = new FileInputStream( new File( filePath ) ) ;
				prop.load( in ) ;
				return prop ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null ;
			}
	  
	    }  
	  
  
}
