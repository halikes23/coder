package com.fq.util.pingpp;

import java.util.Date;

public class PingppUtil {

	/**
	 * 
	 * @Title: getOrderNo 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 获取订单编号
	 * @param @return    设定文件  
	 * @return String    返回类型
	 */
	public static String getOrderNo(){
		return  new Date().getTime() + Main.randomString(7); 
	}
	
}
