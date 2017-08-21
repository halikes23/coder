package com.fq.common.util;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import sun.misc.*;
@Service
public class Base64StringUtil {
	/**
	 * 
	 * @Title: getBase64 
	 * @Description: 加密
	 * @param @param str
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * 
	 * @Title: getFromBase64 
	 * @Description: 解密
	 * @param @param s
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
