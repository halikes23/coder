package com.fq.rule.file;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 漫画封面命名规则
 * @author MaiBenBen
 *
 */
public class LiveCartoonCoverFileNameRule implements IFileNameRule<String> {

	private final static String PREFIX = "LCP" ;
	
	private final static String BASIC_PATH = "/data/jnwtv/qiniu/resource/" ;
	
	private final static DateFormat DATA_FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private final static String SYMBOL_POINT = "." ;
	
	@Override
	public Result build(String suffix) {
		
		Result result = new Result() ;
		
		StringBuilder fileName = new StringBuilder();
		StringBuilder fullFileName = new StringBuilder() ;
		Date now = new Date() ;
		
		// 8位随机数 左侧补0
		String num = String.format("%08d", Math.round(Math.random()*100000000))  ;
		
		fileName.append(PREFIX).append(DATA_FORMAT_YYYYMMDDHHMMSS.format(now)).append( num ).append(SYMBOL_POINT).append(suffix) ;
		fullFileName.append(BASIC_PATH).append(fileName) ;
	
		result.setFileName(fileName.toString());
		result.setFullFileName(fullFileName.toString());
		
		return result;
	}

}
