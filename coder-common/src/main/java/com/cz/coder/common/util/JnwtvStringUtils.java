package com.cz.coder.common.util;

import java.text.DecimalFormat;

public class JnwtvStringUtils {

	public static boolean isEmpty(String str){
		
		return str == null || str.trim().length() == 0;
		
	}
	public static String getPercentageByDecimalFormat(Integer i1 , Integer i2){
		
		if ( i1 > i2 ) {
			i1 = i2 ;
		}
		
		double d1 = i1 ;
		double d2 = i2 ;
		if (d1 > d2  ) {
			return "100%"   ;
		}
		double percentage = d1 / d2 ;

		DecimalFormat df1 = new DecimalFormat("0.00%");
		
		return df1.format( percentage )   ;
		
	}
	

}
