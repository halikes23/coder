package com.fq.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.alipay.api.internal.util.StringUtils;
import com.fq.constant.ThirdConsoleConstant;
import com.fq.util.collection.CircularLinkedList;
import com.fq.util.collection.RandomList;
import com.sun.star.uno.RuntimeException;

public class ProjectComment {

	public static RandomList<String> PROJECT_COMMENTS ;
	
	public static void load() {
		
		PROJECT_COMMENTS = new RandomList<String>() ;
		
		File file = new File(ThirdConsoleConstant.CFG_BASE_PATH + "/PC.txt") ;
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file)) ;
			String line = null ;
			while( !StringUtils.isEmpty( line =reader.readLine() ) ){
				PROJECT_COMMENTS.add(line);
			}
		}catch(FileNotFoundException e){
			throw new RuntimeException("",e) ;
		}catch(IOException e){
			throw new RuntimeException("",e) ;
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("",e) ;
				}
			}
		}
		
	}
	
}
