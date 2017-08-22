package com.cz.coder.common.util;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookUtil {
	private static final Logger logger = LoggerFactory.getLogger(BookUtil.class);
	private static final String LOCALL_NOVEL_PATH = "/data/jnwtv/file/novel/qyAndHwNovelChapter/" ; //小说章节内容存储路径
	private static final String LOCALL_NOVEL_COVERIMG_PATH = "/data/jnwtv/file/novel/qyAndHwNovelImg/" ;//小说封面图存储路径
	private static final String LOCALL_NOVEL_YM_COVERIMG_PATH = "/data/jnwtv/file/novel/yueMingNovelImg/" ;//阅明小说封面图存储路径
	private static final String LOCALL_NOVEL_YM_CHAPTER_PATH = "/data/jnwtv/file/novel/yueMingNovelChapter/" ;//阅明小说章节存储路径
	private static final String LOCALL_NOVEL_ZS_CHAPTER_PATH = "/data/jnwtv/file/novel/zhuiShuNovelChapter/" ;//追书小说章节存储路径
	
	/**
	 * 
	 * @Title: jsonStringToList 
	 * @author chen.zhao 
	 * @Description: 
	 * @param @param rsContent
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return List<Map<String,String>>    返回类型
	 */
	public static List<Map<Object, Object>> jsonStringToList(String rsContent) throws Exception{
        JSONArray arry = JSONArray.fromObject(rsContent);
        List<Map<Object, Object>> rsList = new ArrayList<Map<Object, Object>>();
        for (int i = 0; i < arry.size(); i++)
        {
            JSONObject jsonObject = arry.getJSONObject(i);
            Map<Object, Object> map = new HashMap<Object, Object>();
            for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();)
            {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                map.put(key, value);
            }
            rsList.add(map);
        }
        return rsList;
    }
	
		/**
		 * 
		 * @Title: createTxPath 
		 * @author chen.zhao 
		 * @Description: 创建本地TXT文本路径
		 * @param @param title
		 * @param @param id
		 * @param @return    设定文件  
		 * @return String    返回类型
		 */
		public static String createTxPath(String bId , String cId , String bookSource)throws Exception{
			try {
				//根据小说Id+章节Id ，创建文件名
				 String path = null ;
				 switch (bookSource) {
				case "1":
					path = LOCALL_NOVEL_PATH + bId + cId + ".txt" ;
					break;
				case "2":
					path = LOCALL_NOVEL_PATH + bId + cId + ".txt" ;
					break;
				case "3":
					path = LOCALL_NOVEL_YM_CHAPTER_PATH +  bId + cId + ".txt" ;
					break;
				case "4":
					path = LOCALL_NOVEL_ZS_CHAPTER_PATH +  bId + cId + ".txt" ;
					break;	
				}	
				 return path ;
			} catch (Exception e) {
				logger.error("本地小说章节存储失败" , e );
				throw new RuntimeException(e) ;
			}
			
		}
		/**
		 * 
		 * @Title: createImgPath 
		 * @author chen.zhao 
		 * @Description: 创建本地图片存储路径
		 * @param @param id
		 * @param @return    设定文件  
		 * @return String    返回类型
		 */
		public static String createImgPath(String id  , String bookSource )throws Exception{
			try {
				String path = null ;
				 switch (bookSource) {
				case "1":
					path = LOCALL_NOVEL_COVERIMG_PATH +  id + ".jpg" ;
					break;
				case "2":
					path = LOCALL_NOVEL_COVERIMG_PATH +  id + ".jpg" ;
					break;
				case "3":
					path = LOCALL_NOVEL_YM_COVERIMG_PATH +  id + ".jpg" ;
					break;	
				case "4":
					path = LOCALL_NOVEL_COVERIMG_PATH +  id + ".jpg" ;
					break;	
				}	
				
				 return path ;
				 
			} catch (Exception e) {
				logger.error("小说本地图片存储失败" , e );
				throw new RuntimeException(e) ;
			}
			 
		}
		/**
	    * 
	    * @Title: creatTxtFile 
	    * @author chen.zhao 
	    * @Description: TXT文本写入内容(以utf-8编码)
	    * @param @throws IOException    设定文件  
	    * @return void    返回类型
	    */
	    public static File creatTxtFile(String path , String content ,String encoding) throws IOException{
	    	BufferedWriter writer = null;
	    	File file = new File(path);
	    	try {
				if (file.exists()) {
					System.err.println(file + "已存在！ ");
				}else {
					 file.createNewFile();
					 System.err.println(file + "已创建！ ");
				}
				writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file), encoding));  
		        writer.write(content);  
			} catch (Exception e) {
				logger.error("小说本地文件创建失败" , e );
			}finally{
				writer.close();
			}
	    	return file;
	    }
	    /**
	     * 
	     * @Title: textSize 
	     * @author chen.zhao 
	     * @Description: 计算文本字数（utf-8编码的中文）
	     * @param @param path
	     * @param @return    设定文件  
	     * @return int    返回类型
	     */
	    public static int  textSize(String  path ) {  
	        File f= new File(path);  
	        return (int) (f.length()/3) ;
			
	    }  
	    /**
	     * 
	     * @Title: readInputStream 
	     * @author chen.zhao 
	     * @Description: TODO
	     * @param @param inStream
	     * @param @return
	     * @param @throws Exception    设定文件  
	     * @return byte[]    返回类型
	     */
	    public static byte[] readInputStream(InputStream inStream) throws Exception{  
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        //创建一个Buffer字符串  
	        byte[] buffer = new byte[1024];  
	        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
	        int len = 0;  
	        //使用一个输入流从buffer里把数据读取出来  
	        while( (len=inStream.read(buffer)) != -1 ){  
	            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
	            outStream.write(buffer, 0, len);  
	        }  
	        //关闭输入流  
	        inStream.close();  
	        //把outStream里的数据写入内存  
	        return outStream.toByteArray();  
	    }  
	    /**
	     * 
	     * @Title: download 
	     * @author chen.zhao 
	     * @Description: 将下载文件写入到本地存储路径
	     * @param @param urlString
	     * @param @param filename
	     * @param @throws Exception    设定文件  
	     * @return void    返回类型
	     */
	    public static void download(String urlString, String filename) throws Exception {
	    	FileOutputStream outStream = null ;
	    	try {
	    		 //new一个URL对象  
		        URL url = new URL(urlString);  
		        //打开链接  
		        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
		        //设置请求方式为"GET"  
		        conn.setRequestMethod("GET");  
		        //超时响应时间为5秒  
		        conn.setConnectTimeout(5 * 1000);  
		        //通过输入流获取图片数据  
		        InputStream inStream = conn.getInputStream();  
		        //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
		        byte[] data = readInputStream(inStream);  
		        //new一个文件对象用来保存图片，默认保存当前工程根目录  
		        File imageFile = new File(filename);  
		        //创建输出流  
		        outStream = new FileOutputStream(imageFile);  
		        //写入数据  
		        outStream.write(data);  
			} catch (Exception e) {
				logger.info("下载趣阅网小说文件存储到本地异常："  , e ) ;
			}finally{
			     //关闭输出流  
		        outStream.close();  
			}
	    	
	    }   
	    /**
		  * 
		  * @Title: ceilNum 
		  * @author chen.zhao 
		  * @Description: 向上取整，获取价格
		  * @param @param a
		  * @param @param b
		  * @param @return    设定文件  
		  * @return int    返回类型
		  */
		 public static Integer ceilNum(Integer price ,  Integer wordNum , Integer num ){
			 if (price == 0 || price == null  || wordNum == 0  ) {
				int  priceNum = 0 ;
				return  priceNum;
			}else {
				double a1 = wordNum ;
				double b1 = num ;
				Integer priceNum = ((int) Math.ceil(a1/b1)) * price ; 
				return priceNum;
			}
				
		 }
		 
}
