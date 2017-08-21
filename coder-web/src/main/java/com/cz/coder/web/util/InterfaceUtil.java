package com.fq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fq.properties.FileProperties;
@Service
public class InterfaceUtil {

	private final   Logger logger = LoggerFactory.getLogger( InterfaceUtil.class ) ;
	

	// 生成七牛token
	public String getQiNiuToken() throws Exception {
		
		try{ 
			Auth auth = Auth.create( FileProperties.QINIU_ACCESS_KEY , FileProperties.QINIU_SECRET_KEY );
			String qiniuToken = auth.uploadToken( FileProperties.QINIU_BUCKET ) ; 
			return qiniuToken ;
		}catch(Exception e){
			logger.error( "七牛token生成异常" , e ) ;
			throw e ;
		}
		
	}
	
	//生成七牛Url
	public String getUrlByQiNiuKey( String qiniuKey )  {
		
		try{ 
			Auth auth = Auth.create( FileProperties.QINIU_ACCESS_KEY , FileProperties.QINIU_SECRET_KEY );
			String url = FileProperties.QINIU_BASE_URL + qiniuKey ;
//			url = auth.privateDownloadUrl(url, 4575715200L);
//			url = auth.privateDownloadUrl(url) ;
			url = auth.privateDownloadUrlWithDeadline(url , 2997426444l); 
			return url ;
		}catch(Exception e){
			logger.error( "图片url转化错误：" , e ) ;
			// 若有异常，返回加载失败图片url
			String url = "http://7xjwy0.media1.z0.glb.clouddn.com/6e656263-9699-4b67-976e-a700d949e2ec?e=2997426444&token=26DGa3kCJGxrrdsFbfYIcZGTZ_5nrWkg5wBeMAdp:wXMMYW_1zYtoaPgUq6Fuszk3hTE=";
			return url ;
		}
		
	}
	
	// 生成视频七牛截图url
	public String getVframeUrlByQiNiuKeyString (String qiniuKey) {
		try{
			Auth auth = Auth.create(FileProperties.QINIU_ACCESS_KEY, FileProperties.QINIU_SECRET_KEY);
	        StringBuilder sb = new StringBuilder();
	        sb.append(FileProperties.QINIU_BASE_URL).append(qiniuKey).append("?vframe/jpg/offset/1/w/480/h/480");
	        return auth.privateDownloadUrlWithDeadline(sb.toString(),2997426444l);
		}catch(Exception e){
			logger.error( "图片url转化错误：" , e ) ;
			// 若有异常，返回加载失败图片url
			String url = "http://7xjwy0.media1.z0.glb.clouddn.com/6e656263-9699-4b67-976e-a700d949e2ec?e=2997426444&token=26DGa3kCJGxrrdsFbfYIcZGTZ_5nrWkg5wBeMAdp:wXMMYW_1zYtoaPgUq6Fuszk3hTE=";
			return url ;
		}
	}
}
