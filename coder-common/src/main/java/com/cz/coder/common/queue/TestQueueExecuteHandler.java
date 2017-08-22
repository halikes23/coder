package com.cz.coder.common.queue;

import java.util.Map;

public class TestQueueExecuteHandler implements QueueExecuteHandler<Map<String, Object>>{

	public int execute(Map<String, Object> paraMap) throws Exception {
		System.out.println( "e is executed " + paraMap );
		return 0;
	}

}
