package com.fq.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fq.common.constant.RetCode;
import com.fq.properties.FileProperties;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

public class QiniuUtil {

	private final static Logger logger = LoggerFactory.getLogger(QiniuUtil.class) ;
	
	// 设置好账号的ACCESS_KEY和SECRET_KEY
//	private final static String ACCESS_KEY = "jwxfQuqBTiy39mEfpU1ahrq4jh043M2hUrrG1Zlf";
//	private final static String SECRET_KEY = "Z-yv96BbR8jzRtViZ0Gmk954chJmk4ifa_lUrrrd";
	// 要上传的空间
//	public final static String bucketname = "jnwtv01";

	private static final Auth auth = Auth.create(FileProperties.QINIU_ACCESS_KEY, FileProperties.QINIU_SECRET_KEY);
	
	
	private static final UploadManager uploadManager = new UploadManager();
	BucketManager bucketManager = new BucketManager(auth) ;
	
	public static void main(String[] args) {
		new QiniuUtil().list() ;
//		try {
//			new QiniuUtil().upload();
//			
//		} catch (IOException e) {
//			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public static String getUpToken() {
		return auth.uploadToken(FileProperties.QINIU_BUCKET);
	}

	public void list(){
		try {
			FileListing fileListing = bucketManager.listFiles(FileProperties.QINIU_BUCKET, null, null, 10, null) ;
			
			FileInfo[] fileinfoes = fileListing.items ;
			for(FileInfo fileinfo : fileinfoes){
				System.out.println(fileinfo.key);
			}
			
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String upload(String fullFileName,String key) throws IOException {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(fullFileName, key, getUpToken());
			if( res.statusCode != 200 ){
				logger.error("七牛上传资源失败",res.bodyString());
				return RetCode.QINIU_SERVER_ERROR ;
			}
			// 打印返回的信息
			return RetCode.SUCCESS ;
			
		} catch (QiniuException e) {
			logger.error("",e);
			return RetCode.QINIU_SERVER_ERROR ;
		}
		
	}

	public static String fetch(String url , String bucketDest , String fileName) throws Exception{
		
//		fetch(from, bucket, key);
		try {
			BucketManager bucketManager = new BucketManager(auth) ;
			DefaultPutRet fetch = bucketManager.fetch(url, bucketDest, fileName);
			if(!fetch.key.equals(fileName)){
				logger.error("该图片路径地址不靠谱,请用本地文件上传！",fetch.hash);
				return RetCode.QINIU_SERVER_ERROR_URL ;
			}
			return RetCode.SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.QINIU_SERVER_ERROR_URL ;
		}
		
	}
	
	
	public static String buildQiniuKey(String nameSpace){
		StringBuilder qiniuKey = new StringBuilder();
		String random = String.valueOf( Math.round( Math.random() * 1000000 ) );
		
		qiniuKey.append(nameSpace).append("_").append(DateFormatUtil.CREATE_FULL_DATETIME_STR() + random );
		
		return qiniuKey.toString() ;
	}
	
}
