package com.fq.util.img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
* @类功能说明： 网络图片下载，并存储到指定文件夹
* @公司名称：桃睦科技
* @作者：jingkun.chen
* @创建时间：2015-8-24 下午3:58:35
 */
@Service
public class ImgDownLoadUtil {

	private final static Logger logger =LoggerFactory.getLogger(ImgDownLoadUtil.class );
	
	public static void main(String[] args){
		
		System.out.println("开始下载 ！！");
		download("http://pic1.nipic.com/2008-09-08/200898163242920_2.jpg", "12.jpg","\\data\\image\\");
		System.out.println("下载成功！！");
	}
	
	
	public static void download(String urlString  , String fileName , String savePath){
		InputStream is = null;
		OutputStream oStream =null;
		try {
			//构造URL
			URL url= new URL(urlString);
			// 打开连接
			URLConnection connection = url.openConnection();
			// 设置请求超时 5s
			connection.setConnectTimeout(5*1000);
			// 输入流
			is = connection.getInputStream();
			// 数据缓冲1K
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			
			// 创建文件夹
			File sFile = new File(savePath);
			if ( !sFile.exists() ) {
				sFile.mkdirs();
			}
			// 输出的文件流
			oStream = new FileOutputStream(sFile.getPath()+ File.separator +fileName);
			// 开始读取
			while ( (len=is.read(bs))!= -1) {
				oStream.write(bs,0,len);
			}
			
		} catch (Exception e) {
			 logger.error("错误日志：",e);
		}finally{// 完毕，关闭所有连接
			try {
				oStream.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("错误日志：",e);
			}
		
		}
		
	}
}
