package com.cz.coder.web.util;

import java.security.MessageDigest;

public class PassWordUtil {
/**
 *  16 位加密
 * @param str
 * @return
 * @throws Exception
 */
	public static String MD5(String str)throws Exception{
		
		MessageDigest mdt = MessageDigest.getInstance("MD5");
		mdt.update(str.getBytes());
		byte[] b = mdt.digest();
		int i ;
		StringBuffer sb = new StringBuffer() ;
		for (int offset = 0 ; offset < b.length ; offset++ )
		{
			i = b[offset];
			if(i<0)i+=256;
			if(i<16){
				sb.append("0");
			}
			sb.append(Integer.toHexString(i));
		}
		return sb.toString().substring(8,24);
	}
	/**
	 *  16 位加密
	 * @param str
	 * @return
	 * @throws Exception
	 */
		public static String MD5Pay(String str)throws Exception{
			
			MessageDigest mdt = MessageDigest.getInstance("MD5");
			mdt.update(str.getBytes());
			byte[] b = mdt.digest();
			int i ;
			StringBuffer sb = new StringBuffer() ;
			for (int offset = 0 ; offset < b.length ; offset++ )
			{
				i = b[offset];
				if(i<0)i+=256;
				if(i<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(i));
			}
			return sb.toString();
		}
	public static void main(String[] args)throws Exception {
		String pd = PassWordUtil.MD5("1");
		System.out.println(pd);
	}
}
