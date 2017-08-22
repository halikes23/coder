package com.cz.coder.common.util;

public class RandomUtil {
	/**
	 * 
	 * @Title: buildRandomString 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 随机生成包含大小写字母和数字指定长度的字符串
	 * @param @param length
	 * @param @return    设定文件  
	 * @return String    返回类型 （大小写加数字）
	 */
	public static String buildRandomString( Integer length ) {
		
		StringBuilder rst = new StringBuilder() ;
		
		Character[] chars = new Character[62];
		
		for( int i = 0 ; i < 26 ; i ++ ){
			chars[i] = Character.toChars(i + 65)[0] ;
		}
		
		for( int i = 0 ; i < 26 ; i ++ ){
			chars[i + 26] = Character.toChars(i + 97)[0] ;
		}
		
		for( int i = 0 ; i < 10 ; i ++ ){
			chars[i + 52] = Character.toChars(i + 48)[0] ;
		}
		
		for( int i = 0 ; i < length ; i ++ ){
			
			Integer num = Integer.parseInt( Math.round( Math.random() * 61) + "") ;
			
			char c = chars[num] ;
			
			rst.append(c) ;
			
		}
//		System.out.println(rst);
		return rst.toString() ;

		
	}
	
	
	/**
	 * 
	 * @Title: randomStr 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description:  返回随机字符串，同时包含数字、大小写字母
	 * @param @param len 字符串长度，不能小于4
	 * @param @return    设定文件  
	 * @return String    随机字符串大写字母加数字
	 */
	public static String randomStr(int len){
	  
		if(len < 4){
	      throw new IllegalArgumentException("字符串长度不能小于4");
		}
		//数组，用于存放随机字符
		char[] chArr = new char[len];
		//为了保证必须包含数字、大小写字母
//		chArr[0] = (char)('0' + StdRandom.uniform(0,10));
//		chArr[1] = (char)('A' + StdRandom.uniform(0,26));
//		chArr[2] = (char)('a' + StdRandom.uniform(0,26));
		
		
		char[] codes = { '0','1','2','3','4','5','6','7','8','9',
		                 'A','B','C','D','E','F','G','H','I','J',
		                 'K','L','M','N','O','P','Q','R','S','T',
		                 'U','V','W','X','Y','Z'};
		//charArr[3..len-1]随机生成codes中的字符
		for(int i = 0; i < len; i++){
		    chArr[i] = codes[StdRandom.uniform(0,codes.length)];
		}
		
		//将数组chArr随机排序
		for(int i = 0; i < len; i++){
		    int r = i + StdRandom.uniform(len - i);
		    char temp = chArr[i];
		    chArr[i] = chArr[r];
		    chArr[r] = temp;
		}
		
		return new String(chArr);
	}
	/**
	 * 
	 * @Title: getRandomStrWithCharAndTime 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 指定长度随机字符串+6位数字
	 * @param @param length
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String getRandomStrWithCharAndTime(int length ){
		String str = buildRandomString(length) ; 
		String date =String.valueOf( System.currentTimeMillis() %1000000 ) ; 
		StringBuilder builder = new StringBuilder() ; 
		return builder.append( str ).append(date).toString() ;
	}
	
	public static void main(String[] args) {
		// System.out.println(buildRandomString(40)  );
		for (int i = 0; i < 200; i++) {
			System.out.println(i+"-->"+getRandomStrWithCharAndTime(6));
		}
		
	}
	
}
