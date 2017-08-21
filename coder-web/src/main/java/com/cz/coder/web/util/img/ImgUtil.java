package com.fq.util.img;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fq.common.util.HttpHelper;
import com.fq.properties.FileProperties;
import com.fq.util.Auth;
import com.fq.util.InterfaceUtil;
import com.fq.util.JnwtvStringUtils;

import net.sf.json.JSONObject;
@Service
public class ImgUtil {
	private final static String IMAGE_INFO = "&imageInfo" ;
	private final static Logger logger = LoggerFactory.getLogger( InterfaceUtil.class ) ;
	
	private final static String IMAGE_MOGR2_HEADER = "?imageMogr2/auto-orient" ;
	private final static String CROP = "crop" ;
	private final static String SLASH = "/" ;
	private final static String X = "x" ;
	private final static String A = "a" ;
	private final static String EP = "!" ;
	/**
	 * 
	 * @Title: getQiNiuToken 
	 * @Description: 获取qiniuToken
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
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
	
	/**
	 * 
	 * @Title: getUrlByQiNiuKey 
	 * @Description: 获取图片url
	 * @param @param qiniuKey
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getUrlByQiNiuKey( String qiniuKey , String baseUrl )  {
		
		try{ 
			Auth auth = Auth.create( FileProperties.QINIU_ACCESS_KEY , FileProperties.QINIU_SECRET_KEY );
			if ( baseUrl == null ) {
				baseUrl = FileProperties.QINIU_BASE_URL ; 
			}
			String url = baseUrl + qiniuKey ;
			// 指定图片存放有效期50年，2015-9-14
			url = auth.privateDownloadUrlWithDeadline(url , 2997426444l); 
			
			return url ;
		}catch(Exception e){
			logger.error( "图片url转化错误：" , e ) ;
			// 若有异常，返回加载失败图片url
			String url = "http://7xjwy0.media1.z0.glb.clouddn.com/6e656263-9699-4b67-976e-a700d949e2ec?e=2997426444&token=26DGa3kCJGxrrdsFbfYIcZGTZ_5nrWkg5wBeMAdp:wXMMYW_1zYtoaPgUq6Fuszk3hTE=";
			return url ;
		}
		
	}
	
	/**
	 * 
	 * @Title: getImageInfoByQiniuKey 
	 * @Description: 根据qiniukey查询照片的长和宽
	 * @param @param qiniukey
	 * @param @return    设定文件  
	 * @return Map<String,Integer>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static ImgInfo getImageInfoByQiniuKey(String qiniukey){
		ImgInfo rst = new ImgInfo() ;
		String url = getUrlByQiNiuKey(qiniukey , null )+IMAGE_INFO ;
		String imgInfo = null ;
		try {
			imgInfo = HttpHelper.doPost(url , new HashMap<String, String>() , "utf8");
		} catch (IOException e) {
			logger.error("",e);
		}
		
		JSONObject jsObj = JSONObject.fromObject(imgInfo) ;
		Integer width = jsObj.getInt("width") ;
		Integer height = jsObj.getInt("height") ;
		
		rst.setHeight(height);
		rst.setWidth(width);
		
		return rst ;
	}
	
	
	/**
	 * 
	 * @Title: getVframeUrlByQiNiuKeyString 
	 * @Description: 获取图片截图
	 * @param @param qiniuKey
	 * @param @param videoAppend
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getVframeUrlByQiNiuKeyString (String qiniuKey , String videoAppend) {
		try{
			Auth auth = Auth.create(FileProperties.QINIU_ACCESS_KEY, FileProperties.QINIU_SECRET_KEY);
	        StringBuilder sb = new StringBuilder();
	        sb.append(FileProperties.QINIU_BASE_URL).append(qiniuKey).append( videoAppend );
	        return auth.privateDownloadUrlWithDeadline(sb.toString(),2997426444l);
		}catch(Exception e){
			logger.error( "图片url转化错误：" , e ) ;
			// 若有异常，返回加载失败图片url
			String url = "http://7xjwy0.media1.z0.glb.clouddn.com/6e656263-9699-4b67-976e-a700d949e2ec?e=2997426444&token=26DGa3kCJGxrrdsFbfYIcZGTZ_5nrWkg5wBeMAdp:wXMMYW_1zYtoaPgUq6Fuszk3hTE=";
			return url ;
		}
	}
	
	/**
	 * 
	* 函数功能说明  
	* jingkun.chen 2015-9-7 
	* @参数：@param qiniuKey
	* @参数：@param path
	* @参数：@return 
	* @return String
	 */
	public static String getThumbUrlByQiNiuKey(String qiniuKey , String path , String baseUrl ){
		
		try {
			if ( baseUrl == null ) {
				baseUrl = FileProperties.QINIU_BASE_URL ; 
			}
			Auth auth = Auth.create( FileProperties.QINIU_ACCESS_KEY , FileProperties.QINIU_SECRET_KEY );
			String url = baseUrl + qiniuKey+path ;
//			url = auth.privateDownloadUrl(url, 4575715200L);
//			long deadLine = System.currentTimeMillis() / 1000L + 60*60*24*30*12*50L;
//			url = auth.privateDownloadUrl(url , 3600 * 24 * 30 * 12 * 20) ;
			// 指定图片存放有效期50年 
			url = auth.privateDownloadUrlWithDeadline(url , 2997426444l);
			return url;
		} catch (Exception e) {
			logger.error("错误日志：",e);
			throw e ;
		}
		
	} 
	
	/**
	 * 
	* 函数功能说明  
	* jingkun.chen 2015-9-7 
	* @参数：@param qiniuKey
	* @参数：@param path
	* @参数：@return 
	* @return String
	 */
	public static String getThumbUrlByQiNiuKey(String qiniuKey , String path ){
		
		try {
			Auth auth = Auth.create( FileProperties.QINIU_ACCESS_KEY , FileProperties.QINIU_SECRET_KEY );
			String url = FileProperties.QINIU_BASE_URL + qiniuKey+path ;
//			url = auth.privateDownloadUrl(url, 4575715200L);
//			long deadLine = System.currentTimeMillis() / 1000L + 60*60*24*30*12*50L;
//			url = auth.privateDownloadUrl(url , 3600 * 24 * 30 * 12 * 20) ;
			// 指定图片存放有效期50年 
			url = auth.privateDownloadUrlWithDeadline(url , 2997426444l);
			return url;
		} catch (Exception e) {
			logger.error("错误日志：",e);
			throw e ;
		}
		
	} 
	
	/**
	 * 
	* 函数功能说明   获取缩略图Url
	* jingkun.chen 2015-9-7 
	* @参数：@param width
	* @参数：@param height
	* @参数：@return 
	* @描述：限定缩略图的宽最多为<Width>，高最多为<Height>，进行等比缩放，
	* 		不裁剪。如果只指定 w 参数则表示限定宽（长自适应），只指定 h 参数则表示限定长（宽自适应）。
	* 		它和模式0类似，区别只是限定宽和高，不是限定长边和短边。从应用场景来说，
	* 		模式0适合移动设备上做缩略图，模式2适合PC上做缩略图。
	* @return String
	 */
	public static  String getThumbUrlPath(Integer width  ){
		
		return "?imageView2/1/w/"+width ;
	}
	/*
	 * 
	 * @Title: getModel1ThumbUrlPath 
	 * @Description: 限定缩略图的宽最少为<Width>，高最少为<Height>，进行等比缩放，居中裁剪。
	 * 				  转后的缩略图通常恰好是 <Width>x<Height> 的大小（有一个边缩放的时候
	 * 				  会因为超出矩形框而被裁剪掉多余部分）。如果只指定 w 参数或只指定 h 参数，代表限定为长宽相等的正方图。
	 * @param @param width
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static  String getModel1ThumbUrlPath(Integer width , Integer height ){
		
		return "?imageView2/1/w/"+width+"/h/"+height ;
	}
	
	public static  String cut(Integer x , Integer y , Integer width , Integer height ){
		StringBuilder rst = new StringBuilder();
		rst.append(IMAGE_MOGR2_HEADER).append(SLASH)
			.append(CROP).append(SLASH)
			.append(EP).append(width)
			.append(X).append(height)
			.append(A).append(x)
			.append(A).append(y);
		return rst.toString() ;
	}
	
	/**
	 * 
	 * @Title: getUniformThumbPath 
	 * @Description: <mode> 为零的
	 * @param @param longEdge
	 * @param @param shortEdge
	 * @param @return    设定文件 
	 * @描述：限定缩略图的长边最多为<LongEdge>，短边最多为<ShortEdge>，进行等比缩放，不裁剪。
	 * 		如果只指定 w 参数则表示限定长边（短边自适应），只指定 h 参数则表示限定短边（长边自适应）。 
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String getUniformThumbPath (Integer longEdge , Integer shortEdge ) {
		return "?imageView2/0/w/"+longEdge+"/h/"+shortEdge ;
		}
	/**
	 * 
	 * @Title: videoAppend 
	 * @Description: 获取影片
	 * @param @param longEdge
	 * @param @param shortEdge
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String getVideoAppend ( Integer width , Integer height  ) {
		return "?vframe/jpg/offset/0.001/" ;
//		return "?vframe/jpg/offset/0.001/w/"+ width +"/h/"+height ;
		
	}
	
	/**
	 * 
	 * @Title: checkStringIsQiniukey 
	 * @Description: 验证字符串是否是Qiniukey
	 * @param @param url
	 * @param @return    设定文件  
	 * @return boolean    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static boolean checkStringIsQiniukey( String url ){
		
		if (JnwtvStringUtils.isEmpty(url)  ) {
			
			return false ;
			
		}
		// 验证 字符串是否是qiniukey
		if ( url.startsWith("http:")) {
			
			return false ;
			
		}
		
		return true ; 
		
	}
	/**
	 * 
	 * @Title: filterEmoji 
	 * @Description: 表情符号过滤
	 * @param @param source
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String filterEmoji(String source) {  
        if(source != null)
        {
        	// 对Unicode字符进行大小写不敏感的匹配
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find()) 
            {
                source = emojiMatcher.replaceAll("【表情】");
                return source ; 
            }
        return source;
       }
       return source;  
    }
	/**
	 * 
	 * @Title: filterEmoji4User 
	 * @Description: 表情符号屏蔽
	 * @param @param source
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String filterEmoji4User(String source , String replace) {  
        if(source != null)
        {
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find()) 
            {
                source = emojiMatcher.replaceAll(replace);
                return source ; 
            }
        return source;
       }
       return source;  
    }
	
    /**
     * 检测是否有emoji字符
     * @param source
     * @return 一旦含有就抛出
     */
    public static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }
        
        int len = source.length();
 
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
 
            if (!isNotEmojiCharacter(codePoint)) {
                //do nothing，判断到了这里表明，确认有表情字符
                return true;
            }
        }
 
        return false;
    }
    /**
     * 
     * @Title: isNotEmojiCharacter 
     * @Description: 验证所有字节是否属于表情
     * @param @param codePoint
     * @param @return    设定文件  
     * @return boolean    返回类型 
     * @author jingkun.chen cjk_jing@163.com 
     * @throws
     */
    private static boolean isNotEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
 
    /**
     * 过滤emoji 或者 其他非文字类型的字符
     * @param source
     * @return
     */
    public static String doFilterEmoji(String source) {
    	
        if (StringUtils.isBlank(source)) {
            return StringUtils.EMPTY ;
        }
        StringBuilder buf = null;
 
        int len = source.length();
 
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
 
            if (isNotEmojiCharacter(codePoint)) {
            	
            	buf = ( buf == null ? new StringBuilder(len) : buf ) ;
 
                buf.append(codePoint);
            }
        }
 
        if (buf == null) {
            return StringUtils.EMPTY ; //如果没有找到 emoji表情，则返回源字符串
        } else {
            if (buf.length() == len) {//这里的意义在于尽可能少的toString，因为会重新生成字符串
                return source;
            } else {
                return buf.toString();
            }
        }
 
    }
	
	
//	public  static  void main(String args[]){
//		
//		String param = cut(0,500,1000,1000);  
//		System.out.println(param);
//	}
	public static void main(String[] args) throws Exception {
		String qiniuKey = "LCP_14_159_1_1481697002084.jpg" ;
		ImgInfo imgInfo = ImgUtil.getImageInfoByQiniuKey(qiniuKey);	
		String url = ImgUtil.getUrlByQiNiuKey(qiniuKey , null ) ;
		logger.info(""+imgInfo.getHeight());
		if( imgInfo.getHeight() > 1000 ){
			int cutPoint = 0;
			while(cutPoint < imgInfo.getHeight() ){
				String params = ImgUtil.cut(0, cutPoint, imgInfo.getWidth(), 1000) ;
				String cutedUrl = ImgUtil.getThumbUrlByQiNiuKey(qiniuKey,params , null);
				
				logger.info(cutedUrl);
				
				String cutedFileName = buildCutFileName(qiniuKey,cutPoint);
				//QiniuUtil.fetch(cutedUrl, "jnwtv01", "testcut"+cutPoint+".jpg") ;
				cutPoint += 1000 ;
				System.out.println( cutedFileName );
				
			}
		}
	}
	
	public static String buildCutFileName(String oriName , int cutPoint){
		StringBuilder rst = new StringBuilder();
		
		String[] parts = oriName.split("_", -1) ;
		
		for(int i = 0 ; i < parts.length ; i ++ ){
			
			if(i == 4){
				rst.append(cutPoint).append("_") ;
			}
			rst.append(parts[i]) ;
			if(i != parts.length - 1){
				rst.append("_");
			}
			
		}
		
		return rst.toString() ;
	}
	
	

	
	
}
