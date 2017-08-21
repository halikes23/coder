package com.fq.common.queue;

public interface QueueExecuteHandler<E> {

	int execute(E e) throws Exception;
	
}
