package com.fq.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;



public class HttpUtil {
	/**
	 * 
	 * @param url
	 * @param paramters
	 * @param charSet
	 * @param connectTimeOut
	 */
	public static String doPost (String url , Object paramters ,String charSet,int connectTimeOut){
		String responseStr = "";
		PostMethod postRequest = new PostMethod(url.trim());
		List<NameValuePair> list = new ArrayList<NameValuePair> ();
		int statusCode = 0;
		HttpClient httpclient = new HttpClient();
		try{
			 httpclient.getParams().setParameter(
		 	    		HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
			 httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectTimeOut);
			Method[] ms = paramters.getClass().getMethods();
			for ( int i = 0 ; i < ms.length ; i ++ ){
				Method m = ms[i];
				String name = m.getName();
				if(name.startsWith("get")){
					String param=name.substring(3,name.length());
					param=param.substring(0,1).toLowerCase()+param.substring(1,param.length());
					if(param.equals("class")){
						continue;
					}
				
					Object value =  m.invoke(paramters, null);
					if(value != null){
						NameValuePair nvp = new NameValuePair(param,value.toString()) ;
						list.add(nvp);
					}
				}
			}
			NameValuePair[] nvps = new NameValuePair[list.size()];
			postRequest.setRequestBody(list.toArray(nvps));
			statusCode = httpclient.executeMethod(postRequest);
			BufferedReader reader = new BufferedReader(new InputStreamReader(postRequest.getResponseBodyAsStream(),"UTF-8"));  
			StringBuffer stringBuffer = new StringBuffer();  
			String str = "";  
			while((str = reader.readLine())!=null){  
			    stringBuffer.append(str);  
			}  
			responseStr = stringBuffer.toString();
			 if(statusCode<HttpURLConnection.HTTP_OK || statusCode>=HttpURLConnection.HTTP_MULT_CHOICE){
	                System.err.println("失败返回码[" + statusCode + "]");
	                responseStr="{\"rspCode\":\""+statusCode+"\"}";
	          }
		}catch (Exception e) {
			// TODO: handle exception
			responseStr="{\"rspCode\":\"链接异常,请检查网络\"}";
		}
		return responseStr;
	}
}
