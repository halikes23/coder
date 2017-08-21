package com.fq.util.demo;

public class Demo {

	public final  static String NAME="康复宝"; 
	public static void main(String args[]){
		containsDemo("asd康 复 宝qwedada");
		indexDemo("asd康 复 宝dasdf");
		
	}
	public static void  containsDemo(String str){
		if (str.replaceAll(" ", "").contains("康复宝")) {
			System.out.println("contains输入参数无效！0"+str.trim()); 
			System.out.println(str.replaceAll(" ", "").contains("康复宝"));
		}else {
			System.out.println("contains输入参数有效！1"+str.trim());
			System.out.println(str.replaceAll(" ", "").contains("康复宝"));
		}
		
	}
	public static void indexDemo(String str){
		if (str.replaceAll(" ", "").indexOf(NAME)>=0) {
			System.out.println("indexDemo失败："+str.replaceAll(" ", ""));
			System.out.println(str.indexOf(NAME)  );
		}else {
			System.out.println("indexDemo成功："+str.replaceAll(" ", ""));
			System.out.println(str.indexOf(NAME) );
		}
	}
	
	
	
	
}
