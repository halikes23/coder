package com.fq.common.queue;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

	static int count = 0 ;
	public static Integer getCount(){
		return count++;
	}
	
	public static void main(String[] args) {
		final QueueExecutor<Map<String , Object>> executor = new QueueExecutor<Map<String , Object>>() ;
		
		executor.setQueueExecuteHandler(new TestQueueExecuteHandler());
		System.out.println("executor.start()");
		executor.start();
		
		
		
			
			Thread t = new Thread(new Runnable() {
				
				public void run() {
					Map<String , Object > paramMap = new HashMap<String, Object>() ;
					paramMap.put("pId", count ) ; 
					System.out.println("executor.add(paramMap);");
					executor.add(paramMap);
					count ++ ;
				}
			});
			t.start();
		
		
		
		
	}
	
}
