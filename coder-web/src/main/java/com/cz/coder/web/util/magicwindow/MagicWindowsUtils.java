package com.fq.util.magicwindow;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fq.common.constant.CommonConstant;
import com.fq.common.constant.RetCode;
import com.fq.common.util.HttpHelper;
import com.fq.dao.entity.po.sina.MagicContentBook;
import com.fq.dao.entity.po.sina.MagicContentPO;
import com.fq.dao.entity.po.sina.SinaAppCatePO;
import com.fq.dao.entity.po.sina.SinaContentCatePO;
import com.fq.dao.entity.po.sina.SinaMetaPO;
import com.fq.dao.entity.po.sina.SinaMlinkPO;
import com.fq.dao.entity.po.sina.SinaPO;
import com.fq.dao.entity.po.sina.SinaPopularizePO;
import com.fq.dao.entity.po.sina.SinaPopularizePO1;
import com.fq.dao.entity.po.sina.SinaTagsPO;
import com.fq.dao.entity.vo.sina.SinaAppCateVO;
import com.fq.dao.entity.vo.sina.SinaContentCateVO;
import com.fq.exception.JnwtvException;
import com.fq.properties.MagicWindowProperites;
import com.fq.util.DateFormatUtil;
import com.orsoncharts.util.json.JSONArray;

import net.sf.json.JSONObject;

/**
 * 魔窗工具类
 * @author zhen.cheng
 *
 */
public class MagicWindowsUtils {

	private final static Logger logger = LoggerFactory.getLogger(MagicWindowsUtils.class) ;
	
	private final static String KEY_CONTENT_TYPE = "Content-Type" ;
	
	private final static String SYSTEM_ENCODING = System.getProperty("sun.jnu.encoding") ;
	
	private final static String CONTENT_TYPE_UPLOAD = "application/json;charset=utf-8" ;
	
	private final static String CONTENT_TYPE = "application/json;charset=utf-8" ;
	
	private final static String MAGICWINDOW_TOKEN_URL = "https://api.mlinks.cc/token" ;
	
	private final static String MAGICWINDOW_DELETE_URL = "https://api.mlinks.cc/api/content/delete" ;
	private final static String MAGICWINDOW_CARTOON_DELETE_URL = "https://api.mlinks.cc/api/v2/content/delete" ;
	
	private final static String MAGICWINDOW_VALIDATION_URL = "https://api.mlinks.cc//api/content/validation" ;
	
	private final static String MAGICWINDOW_ADD_URL = "https://api.mlinks.cc/api/content/upsert" ;
	
	private final static String MAGICWINDOW_ADD_CONTENT_URL = "https://api.mlinks.cc/api/v2/content/upsert" ;
	
	private final static String MAGICWINDOW_TOKEN_CONTENT =  "{\"account_key\":\"%s\",\"secret_code\":\"%s\"}" ;
	
	private final static String KEY_MAGICWINDOW_TOKEN = "Magic-Token" ;
	
	private final static String KEY_ACCOUNT_KEY = "Account-Key" ;
	private final static String KEY_PRODUCT_KEY = "Product-Key" ;
	
	private final static String KEY_CACHE_CONTROL = "Cache-Control" ;
	
	private final static String SUCCESS_CODE = "0" ;
	
	/**
	 * 获取魔窗token
	 * @return
	 * @throws JnwtvException
	 */
	private final static String getMogicWindowToken() throws JnwtvException{
		
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE) ;
		
		String content = String.format(MAGICWINDOW_TOKEN_CONTENT, MagicWindowProperites.ACCOUNT_KEY , MagicWindowProperites.SECRET_CODE);
		
		String json = HttpHelper.doPost(MAGICWINDOW_TOKEN_URL, content , requestProperties, CommonConstant.ENCODE_UTF8) ;
		
		JSONObject jObjResponse= JSONObject.fromObject(json) ;
		
		String token =  jObjResponse.getString("access_token") ;
		
		return token ;
		
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws JnwtvException
	 */
	public final static String delete(String[] ids) throws JnwtvException{
		
		String token = MagicWindowsUtils.getMogicWindowToken() ;
		
		// 设置请求HEAD
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE) ;
		requestProperties.put(KEY_MAGICWINDOW_TOKEN, token) ;
		requestProperties.put(KEY_ACCOUNT_KEY, MagicWindowProperites.ACCOUNT_KEY) ;
		requestProperties.put(KEY_CACHE_CONTROL, "no-cache") ;
		requestProperties.put(KEY_PRODUCT_KEY, MagicWindowProperites.PRODUCT_KEY) ;
		// 设置请求参数
		JSONObject jsonObjReq = JSONObject.fromObject(new Object()) ;
		
		jsonObjReq.put("count", ids.length) ;
		jsonObjReq.put("contents", ids) ;
		jsonObjReq.put("product_key", MagicWindowProperites.PRODUCT_KEY) ;
		
		JSONArray contents = new JSONArray() ;
		
		for( String id : ids ){
			
			Map<String,Object> idObj = new HashMap<String,Object>() ;
			idObj.put("content_id", id) ;
			contents.add(idObj) ;
			
		}
		jsonObjReq.put("contents", contents) ;
		
		String response = HttpHelper.doPost(MAGICWINDOW_CARTOON_DELETE_URL, jsonObjReq.toString() , requestProperties, CommonConstant.ENCODE_UTF8) ;
		
		JSONObject jObjResponse= JSONObject.fromObject(response) ;
		
		String code =  jObjResponse.getString("code") ;
		
		if( !StringUtils.equals(code, SUCCESS_CODE) ){
			logger.error(jObjResponse.getString("message"));
			return RetCode.ACCESS_MAGICWINDOW_API_ERROR ;
		}else{	
			return RetCode.SUCCESS ;
		}
		
		
	}

	
	public final static String add( List< SinaPopularizePO > sinaPopularizePOs ) throws JnwtvException{
		
		String token = MagicWindowsUtils.getMogicWindowToken() ;
		
		// 设置请求HEAD
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE) ;
		requestProperties.put(KEY_MAGICWINDOW_TOKEN, token) ;
		requestProperties.put(KEY_ACCOUNT_KEY, MagicWindowProperites.ACCOUNT_KEY) ;
		requestProperties.put(KEY_CACHE_CONTROL, "no-cache") ;
		
		// 设置请求参数
		JSONObject jsonObjReq = JSONObject.fromObject(new Object()) ;
		jsonObjReq.put("count", sinaPopularizePOs.size() ) ;
		jsonObjReq.put("contents", sinaPopularizePOs ) ;
		
		
		String response = HttpHelper.doPost(MAGICWINDOW_ADD_URL, jsonObjReq.toString() , requestProperties, CommonConstant.ENCODE_UTF8) ;
		
		JSONObject jObjResponse= JSONObject.fromObject(response) ;
		
		String code =  jObjResponse.getString("code") ;
		
		if( !StringUtils.equals(code, SUCCESS_CODE) ){
			logger.error(response);
			return RetCode.ACCESS_MAGICWINDOW_API_ERROR ;
		}
		else{
			return SUCCESS_CODE;
		}
	}
	
	public final static void list(Integer page , Integer size, String transferDay){
		String token = MagicWindowsUtils.getMogicWindowToken() ;
		
		// 设置请求HEAD
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE) ;
		requestProperties.put(KEY_MAGICWINDOW_TOKEN, token) ;
		requestProperties.put(KEY_ACCOUNT_KEY, MagicWindowProperites.ACCOUNT_KEY) ;
		requestProperties.put(KEY_CACHE_CONTROL, "no-cache") ;
		
		// 设置请求参数
		JSONObject jsonObjReq = JSONObject.fromObject(new Object()) ;
		jsonObjReq.put("product_key", MagicWindowProperites.PRODUCT_KEY) ;
		jsonObjReq.put("transfer_day", transferDay) ;
		jsonObjReq.put("page", page) ;
		jsonObjReq.put("size", size ) ;
		
		String response = HttpHelper.doPost(MAGICWINDOW_VALIDATION_URL, jsonObjReq.toString() , requestProperties, CommonConstant.ENCODE_UTF8) ;
		
		System.out.println( response );
		
//		JSONObject jObjResponse= JSONObject.fromObject(response) ;
//		
//		String code =  jObjResponse.getString("code") ;
//		
//		if( !StringUtils.equals(code, SUCCESS_CODE) ){
//			logger.error(jObjResponse.getString("message"));
//		}
	}
	/**
	 * 
	 * @Title: addMagicContent 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 发布漫画信息到魔窗
	 * @param @param miContentPOs
	 * @param @return
	 * @param @throws JnwtvException    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public final static String addMagicContent( List< MagicContentPO > miContentPOs ) throws JnwtvException{
			
		String token = MagicWindowsUtils.getMogicWindowToken() ;
		
		// 设置请求HEAD
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE_UPLOAD) ;
		requestProperties.put(KEY_MAGICWINDOW_TOKEN, token) ;
		requestProperties.put(KEY_ACCOUNT_KEY, MagicWindowProperites.ACCOUNT_KEY) ;
		requestProperties.put(KEY_PRODUCT_KEY, MagicWindowProperites.PRODUCT_KEY) ;
		requestProperties.put(KEY_CACHE_CONTROL, "no-cache") ;
		
		// 设置请求参数
		JSONObject jsonObjReq = JSONObject.fromObject(new Object()) ;
		jsonObjReq.put("count", miContentPOs.size() ) ;
		jsonObjReq.put("contents", miContentPOs ) ;
		
		logger.info("魔窗=============== " + getEncoding(jsonObjReq.toString()));
		
		try {
			logger.info("jsonObjectReq:" + new String( jsonObjReq.toString().getBytes(SYSTEM_ENCODING),CommonConstant.ENCODE_UTF8)) ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error("",e) ;
		}
		logger.info("systemEncoding  :" +System.getProperty("sun.jnu.encoding") ) ;
		String response = null;
		try {
			response = HttpHelper.doPost(MAGICWINDOW_ADD_CONTENT_URL, new String( jsonObjReq.toString().getBytes(SYSTEM_ENCODING),CommonConstant.ENCODE_UTF8) , requestProperties, CommonConstant.ENCODE_UTF8);
		} catch (UnsupportedEncodingException e) {
			logger.error("",e) ;
		}
 
		
		JSONObject jObjResponse= JSONObject.fromObject(response) ;
		
		String code =  jObjResponse.getString("code") ;
		
		if( !StringUtils.equals(code, SUCCESS_CODE) ){
			logger.error(response);
			return RetCode.ACCESS_MAGICWINDOW_API_ERROR ;
		}
		else{
			return SUCCESS_CODE;
		}
	}
	/**
	 * 
	 * @Title: cartoonStatistic 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description:漫画统计
	 * @param     设定文件  
	 * @return void    返回类型
	 */
	public void cartoonStatistic() throws Exception{
//			String response = HttpHelper.doPost(MAGICWINDOW_ADD_CONTENT_URL, new String( jsonObjReq.toString().getBytes(SYSTEM_ENCODING),CommonConstant.ENCODE_UTF8) , requestProperties, CommonConstant.ENCODE_UTF8);
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
//		MagicWindowsUtils.delete(new String[]{"movie_001"});
		
//		String uri = "http://qiniu.jnwtv.com/G2016081717095177512489.jpg?e=2997426444" ;
//		
//		SinaMetaPO meta = new SinaMetaPO() ;
//		SinaTagsPO tags = new SinaTagsPO() ;
//		SinaPO sina = new SinaPO() ;
//		SinaMlinkPO mlink = new SinaMlinkPO() ;
//		meta.setSummary( uri ) ;
//		meta.setImage_uri(uri ) ;
//		meta.setContent_image_uri(uri) ;
//		meta.setContent_uri(uri) ;
//		meta.setContent_format("P") ;
//		mlink.setProduct_key( MagicWindowProperites.PRODUCT_KEY ) ;
//		mlink.setShort_uri("http://a.mlinks.cc/AAT6") ;
//		mlink.setClick_behavior("S") ;
//		
//		SinaAppCatePO appcate180301 = new SinaAppCatePO() ;
//		appcate180301.setId( 180301) ;
//		appcate180301.setName("影音") ;
//		SinaAppCatePO appcate180302 = new SinaAppCatePO() ;
//		appcate180302.setId( 180302) ;
//		appcate180302.setName("生活") ;
//		
//		List< SinaAppCatePO > appCatePOs = new ArrayList<>() ;
//		appCatePOs.add(appcate180301) ;
//		appCatePOs.add(appcate180302) ;
//		sina.setApp_cate(appCatePOs ) ;
//		
//		SinaContentCatePO contentCate80404 = new SinaContentCatePO() ;
//		contentCate80404.setId(80404) ;
//		contentCate80404.setName("电影") ;
//		
//		SinaContentCatePO contentCate81101 = new SinaContentCatePO() ;
//		contentCate81101.setId(81101) ;
//		contentCate81101.setName("小说") ;
//		
//		SinaContentCatePO contentCate80402 = new SinaContentCatePO() ;
//		contentCate80402.setId(80402) ;
//		contentCate80402.setName("明星") ;
//		
//		SinaContentCatePO contentCate80405 = new SinaContentCatePO() ;
//		contentCate80405.setId(80405) ;
//		contentCate80405.setName("电视") ;
//		
//		List<SinaContentCatePO> contentCatePOs = new ArrayList<>() ;
//
//		contentCatePOs.add(contentCate80404) ;
//		contentCatePOs.add(contentCate81101) ;
//		contentCatePOs.add(contentCate80402) ;
//		contentCatePOs.add(contentCate80405) ;
//		
//		sina.setContent_cate(contentCatePOs) ;
//		
//		
//		tags.setSina(sina) ;
//		SinaPopularizePO po = new SinaPopularizePO() ;
//		po.setContent( "“总裁，能把你的皮带给我看下么？”且看个性十足的炎景熙如何勾住霸道总裁的心。" ) ;
//		po.setId( "project_003" ) ;
//		po.setTitle( "学生妹和渣男未婚夫小叔的禁忌恋" ) ;
//		po.setTest(0) ;
//		po.setLast_modified_date(System.currentTimeMillis()) ;
//		po.setMeta( meta ) ;
//		po.setMlink(mlink) ;
//		po.setTags(tags) ;
//		
//		List< SinaPopularizePO > pos = new ArrayList<>() ;
//		pos.add(po) ;
//		add(pos) ;
//		
		// list(0,50,"2016/08/17");
		List<MagicContentPO> magicContentPOs = new ArrayList<>() ;
		MagicContentPO magicContentPO = new MagicContentPO() ;
		magicContentPO.setContent("总裁在上 真人漫画") ;
		magicContentPO.setContent_id( "20010") ;
		Map<String , Object> objMap = new HashMap<>() ;
		objMap.put("mw",false) ;
		magicContentPO.setAuthorized_to( objMap ) ;
		magicContentPO.setContent_image_uri( "http://c.mlinks.co/jsvalidator/") ;
		magicContentPO.setImage_uri( "http://c.mlinks.co/jsvalidator/") ;
		magicContentPO.setLong_title( "LongTitle") ;
		List<String> arrayList = new ArrayList<>()  ;
		arrayList.add("100101") ;
		arrayList.add("100102") ;
		arrayList.add("100103") ;
		magicContentPO.setRef_content_ids(arrayList) ;
		magicContentPO.setRendering_type("comic_series") ; // comic_series
		magicContentPO.setShorten_uri("http://a.mlinks.cc/AAT6") ;
		magicContentPO.setSummary( "内容简介" ) ; 
		magicContentPO.setTitle( "总裁在上 （漫画2）") ;
		List<String > tags= new ArrayList<>() ;
		tags.add("m:言情") ;
		tags.add("m:总裁") ;
		tags.add("m:都市") ;
		magicContentPO.setTags( tags ) ; 
		MagicContentBook book = new MagicContentBook() ;
		book.setAuthor("作者姜大牙");
		book.setGenre("言情"); 
		book.setLocked(true) ;
		book.setModified_date(DateFormatUtil.CREATE_FULL_DATE_STR_DB()) ;
		book.setName("总裁在上我在下"); 
		magicContentPO.setBook( book ) ; 
		magicContentPOs.add(magicContentPO) ;
//		addMagicContent( magicContentPOs ) ;
		
//		queryMagicContent() ;
		String[] a = new String[2] ;
		a[0]="10010" ; 
		a[1]="20010" ;
//		delete(a) ;
	}
	
	public static SinaPopularizePO getSinaPopularizePOBySinaPopularizePO1(SinaPopularizePO1 sinaPopularizePO1, 
			List<SinaContentCateVO> sinaContentCateVOs, 
			List<SinaAppCateVO> sinaAppCateVOs) throws Exception{
		//封装SinaMetaPO
		SinaMetaPO sinaMetaPO = new SinaMetaPO();
		sinaMetaPO.setContent_format(sinaPopularizePO1.getContentFormat());
		sinaMetaPO.setContent_image_uri(sinaPopularizePO1.getContentImageUri());
		sinaMetaPO.setContent_uri(sinaPopularizePO1.getContentUri());
		sinaMetaPO.setImage_uri(sinaPopularizePO1.getImageUri());
		sinaMetaPO.setSummary(sinaPopularizePO1.getSummary());
		//封装SinaMlinkPO
		SinaMlinkPO sinaMlinkPO = new SinaMlinkPO();
		sinaMlinkPO.setClick_behavior(sinaPopularizePO1.getClickBehavior());
		sinaMlinkPO.setProduct_key(MagicWindowProperites.PRODUCT_KEY);
		sinaMlinkPO.setShort_uri(sinaPopularizePO1.getShortUri());
		//封装SinaTagsPO
		SinaPO sinaPO = new SinaPO();
		List<SinaAppCatePO> app_cate = new ArrayList<SinaAppCatePO>();
		if(sinaAppCateVOs!=null){
			for(SinaAppCateVO cateVO:sinaAppCateVOs){
				SinaAppCatePO catePO = new SinaAppCatePO();
				catePO.setId(cateVO.getSacId());
				catePO.setName(cateVO.getAppCateName());
				app_cate.add(catePO);
			}
		}
		sinaPO.setApp_cate(app_cate);
		List<SinaContentCatePO> content_cate = new  ArrayList<SinaContentCatePO>();
		if(sinaContentCateVOs!=null){
			for(SinaContentCateVO vo:sinaContentCateVOs){
				SinaContentCatePO po = new SinaContentCatePO();
				po.setId(vo.getSccId());
				po.setName(vo.getContentCateName());
				content_cate.add(po);
			}
		}
		sinaPO.setContent_cate(content_cate);
		SinaTagsPO sinaTagsPO = new SinaTagsPO();
		sinaTagsPO.setSina(sinaPO);
		//封装SinaPopularizePO
		SinaPopularizePO popularizePO = new SinaPopularizePO();
		popularizePO.setId(sinaPopularizePO1.getId());
		popularizePO.setContent(sinaPopularizePO1.getContent());
		long last_modified_date = DateFormatUtil.getTimeInMillis(sinaPopularizePO1.getLastModifiedDate());
		popularizePO.setLast_modified_date(last_modified_date);
		popularizePO.setTest(sinaPopularizePO1.getTest());
		popularizePO.setTitle(sinaPopularizePO1.getTitle());
		popularizePO.setMeta(sinaMetaPO);
		popularizePO.setMlink(sinaMlinkPO);
		popularizePO.setTags(sinaTagsPO);
		return popularizePO;
	}
	
	
	public static void queryMagicContent(){
		String token = MagicWindowsUtils.getMogicWindowToken() ;
		
		// 设置请求HEAD
		Map<String,String> requestProperties = new HashMap<String,String>() ;
		requestProperties.put(KEY_CONTENT_TYPE, CONTENT_TYPE) ;
		requestProperties.put(KEY_MAGICWINDOW_TOKEN, token) ;
		requestProperties.put(KEY_ACCOUNT_KEY, MagicWindowProperites.ACCOUNT_KEY) ;
		requestProperties.put(KEY_PRODUCT_KEY, MagicWindowProperites.PRODUCT_KEY) ;
		requestProperties.put(KEY_CACHE_CONTROL, "no-cache") ;
		
		// 设置请求参数
		
		String uri = "https://api.mlinks.cc//api/v2/content/validation/dc3ce70653ca4ad7807377f940bd405a";
		try {
			HttpHelper.doPost(uri , requestProperties, CommonConstant.ENCODE_UTF8);
		} catch (IOException e) {
			logger.error("",e);
		}
		
	}
	
	public static String getEncoding(String str) {      
	       String encode = "GB2312";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "ISO-8859-1";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	   }

	
	
}
