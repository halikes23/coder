package com.cz.coder.common.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	private final static String NAME= "剧能玩";
	private final static String SHCOLLAGEN= "30%";
	private final static String PERCENT= "0%";
	// 验证是否为空
	public static boolean isNull (String str){
		return str==null || "".equals(str.trim());
	}
	
	
	public static String join( List<?> objs , String splitSymbol , String left , String right ){
		
		StringBuilder rst = new StringBuilder() ;
		
		for( int i = 0 ; i < objs.size() ; i ++ ){
			if( i != 0 ){
				rst.append( splitSymbol ) ;
			}
			rst.append( left ).append( objs.get( i ) ).append( right ) ;
			
		}
		
		
		return rst.toString() ;
	}
	/**
	 * 
	* 函数功能说明 截取字符串长度
	* jingkun.chen 2015-8-27 
	* @参数：@param str
	* @参数：@return 
	* @return String
	 */
	
	public static  String  subString(String str  , int len){
		if (str != null && str.length() > len ) {
			return str.substring(0, len)+"......";
		}else {
			return str;
		}
		
	}
	
	/**
	 * 
	* 函数功能说明  验证用户名是否合法
	* jingkun.chen 2015-8-27 
	* @参数：@param str
	* @参数：@return 
	* @return boolean
	 */
	public static boolean  nameRulers(String str){
		return str.replaceAll(" ", "").contains(NAME);
	}
	
	/**
	 * 
	 * @Title: unicode2String 
	 * @Description: unicode 2 String 编码格式非标准格式
	 * @param @param unicode
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\\\\\u");
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}
		return string.toString();
	}
	
	public static String unicode2StringNomal(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}
		return string.toString();
	}
	
	/**
	 * 
	 * @Title: string2Unicode 
	 * @Description: String 2 unicode
	 * @param @param string
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	 public static String string2Unicode(String string) {
	  
	     StringBuffer unicode = new StringBuffer();
	     for (int i = 0; i < string.length(); i++) {
	         // 取出每一个字符
	         char c = string.charAt(i);
	         // 转换为unicode
	         unicode.append("\\u" + Integer.toHexString(c));
	     }
	     return unicode.toString();
	 }
	/**
	 * 
	 * @Title: getPercentage 
	 * @Description: 获取两个double数据的百分比
	 * @param @param d1
	 * @param @param d2
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public static String getPercentageByNumberFormat(double d1 , double d2){
		
		NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
	    
		format.setMinimumFractionDigits(2);// 设置小数位
	    
	    String a1 = format.format(d1 / d2 ) ;
	    
		return a1;
	}
	/**
	 * 
	 * @Title: getPercentageByDecimalFormat 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: i1 / i2 
	 * @param @param i1
	 * @param @param i2
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String getPercentageByDecimalFormat(int i1 , int i2){
		if ( i1 > i2 ) {
			i1 = i2 ;
		}
		if ( i2 == 0 ) {
			return SHCOLLAGEN ; 
		}
		double d1 = i1*100 ;
		double d2 = i2 ;
		double percentage = Math.ceil( d1 / d2 ) / 100;
		
		// 转换成百分比
		DecimalFormat df1 = new DecimalFormat( PERCENT );
		
		return df1.format( percentage )   ;
		
	}
	/**
	 * 
	 * @Title: subStringByStartIndex 
	 * @author chen.zhao 
	 * @Description: 函数功能说明 ： 截取字符串长度(按设置起始位置截取)
	 * @param @param str
	 * @param @param startIndex
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 */
	public static String  subStringByStartIndex(String str, int startIndex){
		if (str.length()<startIndex) {
			return str;
		}else {
			return str.substring(startIndex);
		}
	}
	
	public static String  subStringByStart7End(String str, int startIndex , int endIndex){
		if (str.length()<startIndex) {
			return str;
		}else {
			return str.substring(startIndex,endIndex);
		}
	}
	
	
	/**
	 * 
	 * @Title: getSystermUserNick 
	 * @Description: 获取系统用户昵称
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 */
	public static String getSystermUserNick(){
		
		return  "j"+System.currentTimeMillis() / 1000L ;
	}
	 
	
	/**
	 * a~b之间的随机数
	 * @param a
	 * @param b
	 * @return
	 */
	public static  int  getLoginReward(int a , int b){
		return (int)(a+Math.random()*(b-a+1));
	}
	/**
	 * 
	 * @Title: checkLoginSendOscarVote 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 登录赠送选票随机方法
	 * @param @param loginCount
	 * @param @return    设定文件  
	 * @return boolean    返回类型
	 */
	
	public static boolean checkLoginSendOscarVote(int loginCount){
		if ( loginCount == 0  ) {
			return true ; 
		}
		if ( 	loginCount % 2 == 0 ) {
			return false ; 
		} 
		return true;
	}
	
    public static String getTel() {  
        String first=String.valueOf(getNum(2,9));  
        return first + System.currentTimeMillis() / 1000L ;  
    }  

    public static int getNum(int start,int end) {  
        return (int)(Math.random()*(end-start+1)+start);  
    }  
    
    /**
	 * 
	 * @Title: compareVersion 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0 
	 * @param @param objVersion 目标版本号
	 * @param @param tagVersion 标准版本号
	 * @param @return    设定文件  
	 * @return int    返回类型
	 */
	public static int compareVersion(String objVersion, String tagVersion) {  
		if (objVersion == null || tagVersion == null) {  
			return -1 ; 
		}
		if ( org.apache.commons.lang.StringUtils.equals(objVersion , tagVersion ) ) {
			return 0 ; 
		}
		String[] versionArray1 = objVersion.split("\\.");//注意此处为正则匹配，不能用"."；  
		String[] versionArray2 = tagVersion.split("\\.");  
		int idx = 0;  
		int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
		int diff = 0;  
		while (idx < minLength  
		        && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
		        && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
		    ++idx;  
		}  
		//如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
		diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
		return diff;  
	}
	
	
	/**
	    * 
	    * @Title: creatTxtFile 
	    * @author chen.zhao 
	    * @Description: 创建文本文件
	    * @param @throws IOException    设定文件  
	    * @return void    返回类型
	    */
	    public static File creatTxtFile(String title , String id) throws IOException{
		 String path = "D:/test/" + title + id + ".txt" ;
		 File filename = new File(path);
	  	 if (filename.exists()) {
	  		  filename.createNewFile();
	  		  System.err.println(filename + "已存在！ ");
				}else {
					  System.err.println(filename + "已创建！ ");
				}
				return filename;
	    }
		
	  /**
	  * 
	  * @Title: writeTxtFile 
	  * @author chen.zhao 
	  * @Description: 写文件
	  * @param @param newStr
	  * @param @throws IOException    设定文件  
	  * @return void    返回类型
	  */
	 public static boolean writeTxtFile(String newStr , File filename) throws IOException{
	     //先读取原有文件，然后进行写入操作
	     String filein = newStr + "<p></p>" + "<p></p>";
	     RandomAccessFile mm = null;
	     try {
	         mm = new RandomAccessFile(filename, "rw");
	         mm.writeBytes(filein);
	     } catch (IOException e1) {
	         e1.printStackTrace();
	     } finally {
	         if (mm != null) {
	             try {
	                 mm.close();
	             } catch (IOException e2) {
	                 e2.printStackTrace();
	             }
	         }
	     }
			return true ;
	 }
	
	 /**
	  * 
	  * @Title: getBitsOfDecimal 
	  * @author chen.zhao 
	  * @Description: 判断一个小数的小数位数并返回位数
	  * @param @param str
	  * @param @return    设定文件  
	  * @return int    返回类型
	  */
	public static int  getBitsOfDecimal(String str) {
		//正则表达式判断是否为小数
		Pattern p=Pattern.compile("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+");
		Matcher m=p.matcher(str);
		boolean b=m.matches();
		//是小数则判断位数
		if (b) {
			int bitPos =  str.indexOf(".") ;
			int numOfBits = str.length() - bitPos - 1 ;
			return numOfBits ;
		}else {
			return 0 ; 
		}
	}
	 
    public static void main(String[] args) throws IOException {
//		List<String> lst = new ArrayList<String>() ;
//		
//		lst.add( "a" ) ;
//		lst.add( "b" ) ;
		
//		String rst= StringUtils.join( lst , ",", "'", "'") ;
//		System.out.println( rst );
//	    String test = "uincode测试编码";
//	     String unicode = string2Unicode(test);
//	      
//	     String string = unicode2String(unicode) ;
//	      
//	     System.out.println("unicode"+unicode);
//	      
//	     System.out.println("string"+string);
//	     System.out.println("取整"+(int) Math.floor(33/10) );
//	    System.out.println("aa"+unicode2StringNomal("\u2600-\u27ff"));
//		System.out.println("剧能玩账号"+ StringUtils.getSystermUserNick());
//		System.out.println("用户账号"+ StringUtils.getTel());
//    	System.out.println(compareVersion("1.23" , "2.1"));
    	
    	// System.out.println(b.getAge().equals(0));
    	
	}
    
}
