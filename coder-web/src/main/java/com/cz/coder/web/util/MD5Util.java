package com.fq.util;

import java.security.MessageDigest;

public class MD5Util {
	/**
	 * 
	 * @Title: encrypt 
	 * @Description: Md5加密（大写）
	 * @param @param s
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public final static String encrypt(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	/**
	 * 
	 * @Title: encrypt4Small 
	 * @Description: Md5加密小写
	 * @param @param s
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public final static String encrypt4Small(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    public static void main(String[] args) {
        System.out.println(MD5Util.encrypt("医生_13918439139"));
        System.out.println(MD5Util.encrypt4Small("30MTQ5NDIzODQ0OTQ3Ng"));
    }
}
