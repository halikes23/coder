package com.cz.coder.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.cz.coder.common.constant.RetCode;
import com.cz.coder.common.exception.JnwtvException;

public class DateUtil {

	/**
	 * 获取昨天的Date
	 * @return
	 */
	public final static Date getLastDay(){
		return DateUtil.getLastDay(new Date()) ;
	}
	
	/**
	 * 获取上一日Date
	 * @param date
	 * @return
	 */
	public final static Date getLastDay(Date date){
		Calendar c = Calendar.getInstance() ;
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -1) ;
		return c.getTime() ;
	}
	
	/**
	 * 校验时间字符串是否符合时间格式化对象定义的格式
	 * 注：dateFormat的lenient属性决定了检查是否是宽松的
	 * @param date
	 * @param dateFormat
	 * @throws JnwtvException
	 */
	public final static void checkDateString( String date , DateFormat dateFormat ) throws JnwtvException{
		try {
			dateFormat.parse(date);
		} catch (ParseException e) {
			throw new JnwtvException(RetCode.WRONG_DATE_FORMAT) ;
		} 
	}
	
}
