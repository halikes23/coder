package com.fq.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.fq.constant.ThirdConsoleConstant;

/**
 * csv工具类
 * @author zhen.cheng
 *
 */
public class CSVUtil {

	private final static Logger logger = LoggerFactory.getLogger(CSVUtil.class) ;
	
	public final static void write(List<?> list,String head[] , String[] properties,String fileName , Class<?> clazz) throws Exception{
		
		CsvWriter writer = new CsvWriter(fileName,',',Charset.forName("utf-8"));
		
		write(writer, list, head ,properties, clazz);
	}
	
	public final static void write(List<?> list,String head[], String[] properties,OutputStream out , Class<?> clazz ) throws Exception{
		
		CsvWriter writer = new CsvWriter(out ,',',Charset.forName("utf-8")) ;
		
		write(writer, list, head , properties ,clazz);
		
	}
	
	private final static void write(CsvWriter writer ,List<?> list,String head[] , String[] properties , Class<?> clazz) throws Exception{
		try{
			
			Method[] ms = clazz.getDeclaredMethods() ;
			
			List<Method> methods = new ArrayList<Method>() ;
			
			for( String property : properties ){
				Method method ;
//				if(property.startsWith("is")){
//					method = clazz.getDeclaredMethod(property) ;
//				}else{
					method = clazz.getDeclaredMethod( "get" + property.substring(0,1).toUpperCase() + property.substring(1) ) ;
//				}
				methods.add(method) ;
			}
			
			writer.writeRecord(head);
			for(Object obj : list){
				String[] record = new String[methods.size()];
				for( int i = 0 ; i < methods.size() ; i ++ ){
					Method method = methods.get(i) ;
					Object v = method.invoke(obj) ;
					if( v != null ){
						record[i] = v.toString() ;
					}
				}
				writer.writeRecord(record);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("",e);
		}finally{
			if(writer != null){
				writer.flush();
				writer.close();
			}
		}
	}
	/**
	 * 
	 * @Title: readerCSV 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 读取csv文件
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Set<String>    返回类型
	 */
	public static List<String> readerCSV() throws Exception {
		try {
			CsvReader csvReader = new CsvReader(  ThirdConsoleConstant.CFG_BASE_PATH + "nick.csv" ,  ',' , Charset.forName("GBK")) ; 
			csvReader.readHeaders() ;
			List<String> nameList = new ArrayList<String>() ; 
			while(csvReader.readRecord()){
//				System.out.println(csvReader.getRaswRecord());
				nameList.add( csvReader.getRawRecord() ) ; 
			}
			logger.info("本次添加备选昵称量："+nameList.size() ) ; 
			return nameList ;
			
		} catch (Exception e) {
			logger.info("csv读取异常", e )  ;
			throw e ; 
		}
		
	 
	}
	public static void main(String[] args) throws Exception {
		readerCSV() ; 
	}

}
