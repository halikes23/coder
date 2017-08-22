package com.cz.coder.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 时间格式化工具
 * @author zhen.cheng
 *
 */
public class DateFormatUtil {
	public static String DATA_FORMAT_Y_M_D = "yyyy-MM-dd HH:mm:ss" ;
	
	public final static DateFormat dateTimeFormate = new SimpleDateFormat("yyyyMMddHHmmss") ;
	
	public final static DateFormat dateFormat = new SimpleDateFormat( "yyyyMMdd" ) ;
	
	public final static DateFormat DATE_FORMAT_DT = new SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	public final static DateFormat dateTimeFormatinDB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
	
	public static String DATA_FORMAT_M_D_H_M_S = "MM-dd HH:mm:ss" ;
	
	public final static DateFormat DATE_FORMAT_TM = new SimpleDateFormat("HH:mm:ss") ;
	
	public final static DateFormat dateTimeFormatinSSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS") ;
	
	
	
	
	/**
	 * 生成yyyyMMddHHmmss时间字符串
	 * @return
	 */
	public final static String CREATE_FULL_DATETIME_STR(){
		return dateTimeFormate.format( new Date() ) ;
	}
	
	/**
	 * 生成yyyyMMdd日期字符串
	 * @return
	 */
	public final static String CREATE_FULL_DATE_STR(){
		return dateFormat.format( new Date() ) ;
	}
	
	/**
	 * 生成yyyy-MM-dd时间字符串
	 * @return
	 */
	public final static String CREATE_FULL_DATE_FORMATIN_STR(){
		return DATE_FORMAT_DT.format( new Date() ) ;
	}
	/**
	 * 生成yyyy-MM-dd HH:mm:ss日期字符串
	 * @return
	 */
	public final static String CREATE_FULL_DATE_STR_DB(){
		return dateTimeFormatinDB.format( new Date() ) ;
	}
	
	/**
	 * 
	 * @Title: CREATE_FULL_DATETIME_STR_SSS 
	 * @author chen.zhao 
	 * @Description: 生成yyyy-MM-dd HH:mm:ss:SSS日期字符串 
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public final static String CREATE_FULL_DATETIME_STR_SSS(){
		return dateTimeFormatinSSS.format( new Date() ) ;
	}
	
	/** 
	 * 时间戳转换成日期格式字符串 
	 * @param seconds 精确到秒的字符串 
	 * @param formatStr 日期格式
	 * @return 
	 */  
	public static String timeStamp2Date(String seconds,String format) {  
		if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
			return "";  
		}  
		if(format == null || format.isEmpty()) format = DATA_FORMAT_Y_M_D ;  
		SimpleDateFormat sdf = new SimpleDateFormat(format);  
		return sdf.format(new Date(Long.valueOf(seconds+"000")));  
	 }  
	 /** 
	  * 日期格式字符串转换成时间戳 
	  * @param date 字符串日期 
	  * @param format 如：yyyy-MM-dd HH:mm:ss 
	  * @return 
	  */  
	public static String date2TimeStamp(String dateStr,String format){  
	    try {
		   	if ( null == format) {
				format = "yyyy-MM-dd HH:mm:ss" ;
			}
		   	if ( StringUtils.isBlank( dateStr )   ) {
		   		 dateStr=CREATE_FULL_DATE_STR_DB() ;
			} 
		        SimpleDateFormat sdf = new SimpleDateFormat(format);  
		        return String.valueOf(sdf.parse(dateStr).getTime()/1000);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return "0";  
	}  
	/**
	 * 
	 * @Title: dateAndTime2TimeStamp 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 根据日期和时间获取时间戳
	 * @param @param dateStr
	 * @param @param timeStr
	 * @param @param format
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return long    返回类型
	 */
	public static long dateAndTime2TimeStamp(String dateStr , String timeStr ,String format) throws Exception{  
	    try {
	    	if ( null == format) {
				format = "yyyy-MM-dd HH:mm:ss" ;
			}
	    	if ( dateStr == null || 
	    			timeStr == null ) {
	    		SimpleDateFormat sdf = new SimpleDateFormat(format);  
	    		return sdf.parse(dateStr).getTime()/1000;  
			}
	    	StringBuilder openDtBuilder = new StringBuilder(dateStr) ;
			openDtBuilder.append(" ").append( timeStr ) ;  
			return Long.parseLong( DateFormatUtil.date2TimeStamp( openDtBuilder.toString() , DateFormatUtil.DATA_FORMAT_Y_M_D ) ) ; 
	    } catch (Exception e) {  
	        throw e ; 
	    }
	}
	/**
	 * 
	 * @Title: changeDateFormat 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 修改时间格式
	 * @param @param dateStr
	 * @param @param oldFormat
	 * @param @param newFormat
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String changeDateFormat(String dateStr , String oldFormat , String newFormat ){
		
		return DateFormatUtil.timeStamp2Date(DateFormatUtil.date2TimeStamp( dateStr , oldFormat  ) , newFormat ) ; 
	}
	
	/** 
	 * 取得当前时间戳（精确到秒） 
	 * @return 
	 */  
	public static String timeStamp(){  
	    long time = System.currentTimeMillis();  
	    String t = String.valueOf(time/1000);  
	    return t;  
	}  
	/**
	 * 
	 * @Title: getSomeDayDate 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 获取某一天的日期格式
	 * @param @param day
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getSomeDayDate(int day ){
		 
		Calendar   cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE,   day);
		String someDay = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		return someDay ; 
	 }
	
	
	/**
	 * 生成HH:mm:ss日期字符串
	 */
	public final static String CREATE_FULL_DATE_STR_TM(){
		return DATE_FORMAT_TM.format( new Date() );
	}
	/**
	 * 
	 * @Title: getVipOutDt 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 计算VIP会员到期时间
	 * @throws
	 */
	public final static String getVipOutDt( String startDate ,  Integer timeLimit ){
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.MONTH , timeLimit);
		calendar.setTimeInMillis(Long.parseLong( DateFormatUtil.date2TimeStamp(startDate, "yyyy-MM-dd"))*1000 ) ;
		calendar.add(Calendar.DAY_OF_MONTH, timeLimit ) ;
		
		return  dt.format( calendar.getTime()) ;
	}
	
	
	/**
	 * 
	 * @Title: getVipRemainDays 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 计算会员剩余天数
	 * @param @param vipOutDt
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public final static int getVipRemainDays(String vipOutDt) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Calendar cal = Calendar.getInstance();    
		cal.setTime(sdf.parse(vipOutDt));    
		long outDt = cal.getTimeInMillis();                 
		cal.setTime(sdf.parse(DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR()));    
		long now = cal.getTimeInMillis();         
		long between_days=(outDt-now)/(1000*3600*24);  
		System.out.println(between_days);
		return (int)between_days ; 
	}
	/**
	 * 0：7
	 * @Title: getWeekOneDayDate
	 * @author chen.zhao
	 * @Description: 获取当前周的某一天yyyyMMdd
	 * @param @param 
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	
	public static String getWeekOneDayDate( int dayNum){
		
		Calendar calendar = Calendar.getInstance();
		
		//获取本周的第一天(周日)
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); 
		
		//获取本周的某一天
		calendar.add(Calendar.DATE, dayNum );
		
		//时间格式化
		String date = (new SimpleDateFormat("yyyyMMdd")).format(calendar.getTime());
		
		return date;
	} 
	/**
	 * 
	 * @Title: checkUserRegisterDate 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 对比时间是否在规定时间范围内
	 * @param @param registerDate
	 * @param @return    设定文件  
	 * @return boolean    返回类型 true:在规定范围内；false:不在范围
	 */
	public static boolean checkUserRegisterDate(String registerDate , String standardDate ){
		if ( registerDate == null ) {
			return false ; 
		}
		
		String date = registerDate.substring( 0 , 19 ) ; 
		if ( Long.parseLong( date2TimeStamp( date , null ) ) > Long.parseLong( date2TimeStamp( standardDate , null) ) ) {
			return true ; 
		}
		return false ; 
	}
	/**
	 * 
	 * @Title: daysBetween 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 计算两个字符串格式的日期之间的填相差天数
	 * @param @param smdate 较小日期
	 * @param @param bdate 较大日期
	 * @param @return
	 * @param @throws ParseException    设定文件  
	 * @return int    返回类型
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{  
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	     Calendar cal = Calendar.getInstance();    
	     cal.setTime(sdf.parse(smdate));    
	     long time1 = cal.getTimeInMillis();                 
	     cal.setTime(sdf.parse(bdate));    
	     long time2 = cal.getTimeInMillis();         
	     long between_days=(time2-time1)/(1000*3600*24);  
		return Integer.parseInt(String.valueOf(between_days)) + 1 ;     
	}
	
	/**
	 * 
	 * @Title: daysBetween 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 日期格式计算两个日期相差几天
	 * @param @param smdate 较小日期
	 * @param @param bdate 较大日期
	 * @param @return
	 * @param @throws ParseException    设定文件  
	 * @return int    返回类型
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException    
	{	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		smdate=sdf.parse(sdf.format(smdate));  
		bdate=sdf.parse(sdf.format(bdate));  
		Calendar cal = Calendar.getInstance();    
		cal.setTime(smdate);    
		long time1 = cal.getTimeInMillis();                 
		cal.setTime(bdate);    
		long time2 = cal.getTimeInMillis();         
		long between_days=(time2-time1)/(1000*3600*24);  
		return Integer.parseInt(String.valueOf(between_days));           
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(daysBetween("2017-06-13" , "2017-06-14") ); 
	}
	
}
