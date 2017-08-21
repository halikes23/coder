package com.cz.coder.web.common.properties;

import java.io.File;
import java.util.Properties;

import com.cz.coder.web.common.constant.CoderWebConstant;
import com.fq.util.ConfigUtil;

/**
 * 文件参数信息
 * @author zhen.cheng
 *
 */
public class FileProperties {
	
	// 头像图片存储基本路径
	public final static String HEAD_IMG_BASE_DIR =  File.separator + "jnwtv_head_imgs" + File.separator ;
	
	public final static String HEAD_IMG_BASE_URL  ;
	
	public final static String QINIU_BASE_URL   ;
	
	public final static String QINIU_ACCESS_KEY   ;
	
	public final static String QINIU_SECRET_KEY  ;
	
	public final static String QINIU_BUCKET  ;
	
	public final static String IMG_WIDTH_SMALL   ;
	
	public final static String IMG_WIDTH_MIDDLE  ;
	
	public final static String HEAD_WIDTH  ;
	
	public final static String QINIU_BASE_URL_MAGIC_UNLOCK = "http://magicunlock.jnwtv.com/" ;
	
	public final static String QINIU_BASE_URL_MAGIC_LOCK = "http://magiclock.jnwtv.com/" ;
	static{
		
		Properties prop = ConfigUtil.readProperty( CoderWebConstant.CFG_BASE_PATH +"File.properties" ) ;
		
		HEAD_IMG_BASE_URL = prop.get("FILE.QINIU_HEAD_BASE_URL").toString();
	
		QINIU_BASE_URL = prop.get("FILE.QINIU_BASE_URL").toString();
		
		QINIU_ACCESS_KEY=prop.get("FILE.QINIU_ACCESS_KEY").toString();
		
		QINIU_SECRET_KEY = prop.getProperty("FILE.QINIU_SECRET_KEY").toString() ;
		
		QINIU_BUCKET = prop.get("FILE.QINIU_BUCKET").toString() ;
		
		IMG_WIDTH_SMALL  = prop.get("FILE.IMG_WIDTH_SMALL").toString() ;
		
		IMG_WIDTH_MIDDLE = prop.get("FILE.IMG_WIDTH_MIDDLE").toString() ;
		
		HEAD_WIDTH = prop.get("FILE.HEAD_WIDTH").toString() ;
		
	}
}
