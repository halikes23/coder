package com.fq.rule.file;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 影片报表命名规则
 * @author MaiBenBen
 *
 */
public class MovieReportFileNameRule implements IFileNameRule<String>{

	private final static String PREFIX = "M" ;
	
	private final static String SUFFIX = ".csv" ;
	
	private final static String FILE_SPLIT = "/" ;
	
	private final static String BASIC_PATH = "/data/jnwtv/file/report/movie/" ;
	
	private final static DateFormat DATA_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
	private final static DateFormat DATA_FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Override
	public Result build(String mId) {
		
		Result result = new Result() ;
		
		StringBuilder fileName = new StringBuilder();
		StringBuilder fullFileName = new StringBuilder() ;
		Date now = new Date() ;
		
		mId = String.format("%08d", Integer.parseInt(mId)) ;
		
		// 8位随机数 左侧补0
		String num = String.format("%08d", Math.round(Math.random()*100000000))  ;
		
		fileName.append(PREFIX).append(mId).append(DATA_FORMAT_YYYYMMDDHHMMSS.format(now)).append( num ).append(SUFFIX) ;
		fullFileName.append(BASIC_PATH).append(DATA_FORMAT_YYYYMMDD.format(now)).append(FILE_SPLIT).append(fileName) ;
	
		result.setFileName(fileName.toString());
		result.setFullFileName(fullFileName.toString());
		
		return result;
	}
	
}
