package com.fq.util;

import java.util.HashMap;
import java.util.Iterator;

import net.sf.json.JSONObject;

public class JnwStringUtils {
	 /** 
     * 将json格式的字符串解析成Map对象 <li> 
     * json格式：{"name":"admin","retries":"3fff","testname" 
     * :"ddd","testretries":"fffffffff"} 
     */  
    public static HashMap<String, String> toHashMap(Object object)  
    {  
        HashMap<String, String> data = new HashMap<String, String>();  
        // 将json字符串转换成jsonObject  
        JSONObject jsonObject = JSONObject.fromObject(object);  
        Iterator it = jsonObject.keys();  
        // 遍历jsonObject数据，添加到Map对象  
        while (it.hasNext())  
        {  
            String key = String.valueOf(it.next());  
            String value = jsonObject.get(key).toString();  
            data.put(key, value);  
        }  
        return data;  
    }
}
