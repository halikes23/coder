package com.fq.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassUtil
 * 
 * @author P
 * 
 */

public class ClassUtil {

	public static final String TYPE_STRING = "java.lang.String";  
	
	public static final String TYPE_INTEGER = "java.lang.Integer";  
    
	public static final String TYPE_DOUBLE = "java.lang.Double";  
    
	public static final String TYPE_FLOAT = "java.lang.Float";  
    
	public static final String TYPE_BOOLEAN = "java.lang.Boolean";  
    
	public static final String TYPE_CHARACTER = "java.lang.Character";  
    
	public static final String TYPE_SHORT = "java.lang.Short";  
    
	public static final String TYPE_LONG = "java.lang.Long";  
    
	public static final String TYPE_BYTE = "java.lang.Byte";
	/**
	 * 获取Form属性以及value ,组成键值Map返回
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	
	public static Map<String, String> object2Map(Object obj) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Method[] ms = obj.getClass().getMethods();
		for (int i = 0; i < ms.length; i++) {
			Method m = ms[i];
			String name = m.getName();
			if (!m.getReturnType().toString().equals("class java.lang.String")) {
				continue;
			}
			if (name.startsWith("get")) {
				String param = name.substring(3, name.length());
				param = param.substring(0, 1).toLowerCase()
						+ param.substring(1, param.length());
				if (param.equals("class")) {
					continue;
				}
				Object value = m.invoke(obj, null);
				map.put(param, value == null ? "" : value.toString());
			}
		}
		return map;
	}

	/**
	 * 根据Class 获取Class里所有的私有属性
	 * 并且设置对于的值
	 * @param obj
	 * @return List<String>
	 * @throws IllegalAccessException 
	 * @throws Exception 
	 */
	public static <T> Object attributeInClass(Class<T> cls) throws Exception {
		Object obj = cls.newInstance();
		Method[] methods = cls.getMethods();
		for (Method m : methods) {
			String methodName = m.getName();
			if (methodName.startsWith("get")) {
				String att = methodName.substring(3, methodName.length());
				att = att.substring(0, 1).toLowerCase()+ att.substring(1, att.length());
				if (att.equals("class")) {
					continue;
				}
				Field field =  cls.getDeclaredField(att);
				Class<?> classType = field.getType(); 
				field.setAccessible(true);
				Object object = setFieldType(classType,1);  
				field.set(obj, object);
			}
		}
		return obj;
	}
	
	public static Object setFieldType(Class<?> classType,Object object) {  
        
        String typeString = classType.getName();  
          
        if(typeString.equals(TYPE_INTEGER) || classType.equals(Integer.TYPE)) {  
            return Integer.parseInt(object.toString());  
        }else if(typeString.equals(TYPE_STRING)) {  
            return object.toString();  
        }else if(typeString.equals(TYPE_LONG) || classType.equals(Long.TYPE)) {  
            return Long.parseLong(object.toString());  
        }else if(typeString.equals(TYPE_BOOLEAN) || classType.equals(Boolean.TYPE)) {  
            return Boolean.parseBoolean(object.toString());  
        }else if(typeString.equals(TYPE_BYTE) || classType.equals(Byte.TYPE)) {  
            return Byte.parseByte(object.toString());  
        }else if(typeString.equals(TYPE_CHARACTER) || classType.equals(Character.TYPE)) {  
            return object.toString().charAt(0);  
        }else if(typeString.equals(TYPE_DOUBLE) || classType.equals(Double.TYPE)) {  
            return Double.parseDouble(object.toString());  
        }else if(typeString.equals(TYPE_FLOAT) || classType.equals(Float.TYPE)) {  
            return Float.parseFloat(object.toString());  
        }else if(typeString.equals(TYPE_SHORT) || classType.equals(Short.TYPE)) {  
            return Short.parseShort(object.toString());  
        }else {  
            if(classType.isArray()) {  
                if(object instanceof String) {  
                    return new String[] {object.toString()};  
                }  
                return (String[])object;  
            }  
            return object;  
        }  
    }  

	
	public static void main(String[] args) throws Exception {
		
	}
}
