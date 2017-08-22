package com.cz.coder.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtil {

	private final static Logger logger = LoggerFactory.getLogger(ZipUtil.class) ;
	
	/**
	 * zip压缩 自动生成目录，将文件移入目录后，进行压缩
	 * @param zipFileName zip文件名 不要加.zip
	 * @param files
	 * @return
	 * @throws IOException 
	 */
	public static File zip(String zipFileName , List<File> files) throws IOException{
		
		String packageName = zipFileName.substring(zipFileName.lastIndexOf("/") + 1,zipFileName.length()) ;
		
		File zipFile = new File(zipFileName+".zip");
		ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFile)) ;
		BufferedOutputStream bo = new BufferedOutputStream(zipWriter);
		try {
			zipWriter.putNextEntry(new ZipEntry(packageName + "/"));
			for( File file : files ){
				zipWriter.putNextEntry(new ZipEntry(packageName+"/"+file.getName()));
				FileInputStream in = new FileInputStream(file);  
	            BufferedInputStream bi = new BufferedInputStream(in);  
	            int length; 
	            byte[] buffer = new byte[10*1024] ;
	            try{
	            	 while ((length = bi.read(buffer)) != -1) {  
	 	                bo.write(buffer,0,length); // 将字节流写入当前zip目录  
	 	               bo.flush();
	 	            }  
	            }catch(Exception e){
	            	throw e ;
	            }finally{
	            	bi.close();  
		            in.close(); // 输入流关闭  
	            }
	           
	            
			}
		} catch (IOException e) {
			logger.error("",e);
		}finally{
			if(bo!=null){
				
				bo.close(); 
			}
			if(zipWriter != null){
				zipWriter.close();
			}
			
		}
		return zipFile ;
		
	}
	
}
