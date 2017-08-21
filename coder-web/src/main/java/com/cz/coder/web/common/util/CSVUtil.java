package com.cz.coder.web.common.util;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.csvreader.CsvWriter;

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

}
