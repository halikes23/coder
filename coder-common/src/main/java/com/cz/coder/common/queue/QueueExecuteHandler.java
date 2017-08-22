package com.cz.coder.common.queue;

public interface QueueExecuteHandler<E> {

	int execute(E e) throws Exception;
	
}
