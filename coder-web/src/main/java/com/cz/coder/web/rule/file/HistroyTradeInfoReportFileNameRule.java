package com.fq.rule.file;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 历史支付查询报表命名规则
 * @author MaiBenBen
 *
 */
public class HistroyTradeInfoReportFileNameRule implements IFileNameRule<String>{

	private final static String PREFIX = "HTI" ;
	
	private final static String SUFFIX = ".csv" ;
	
	private final static String FILE_SPLIT = "/" ;
	
	private final static String BASIC_PATH = "/data/jnwtv/file/report/addheal/" ;
	
	private final static DateFormat DATA_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
	private final static DateFormat DATA_FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Override
	public Result build(String admin) {
		
		Result result = new Result() ;
		
		StringBuilder fileName = new StringBuilder();
		StringBuilder fullFileName = new StringBuilder() ;
		Date now = new Date() ;
		
		// 8位随机数 左侧补0
		String num = String.format("%d", Math.round(Math.random()*100000000) )  ;
		
		fileName.append(PREFIX).append(DATA_FORMAT_YYYYMMDDHHMMSS.format(now)).append( num ).append(SUFFIX) ;
		fullFileName.append(BASIC_PATH).append(fileName) ;
	
		result.setFileName(fileName.toString());
		result.setFullFileName(fullFileName.toString());
		
		return result;
	}
	
}

