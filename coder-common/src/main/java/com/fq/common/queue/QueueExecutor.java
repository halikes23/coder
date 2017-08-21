package com.fq.common.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueExecutor<E> {

	private final static Logger logger = LoggerFactory.getLogger(QueueExecutor.class) ; 
	
	private BlockingQueue<E> queue = new LinkedBlockingQueue<E>();
	
	private QueueExecuteHandler<E> queueExecuteHandler ;
	
	public void start(){
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
				while(true){
					execute();
				}
			}
		});
		thread.start();
		
	}
	
	public void add(E e){
		queue.add(e) ;
	}
	
	public void execute(){
		try {
			E e = queue.take(); // take() 线程阻塞
			queueExecuteHandler.execute(e) ;
		} catch (InterruptedException e) {
			logger.error("",e);
		} catch (Exception e){
			logger.error("",e);
		}
	}

	public QueueExecuteHandler<E> getQueueExecuteHandler() {
		return queueExecuteHandler;
	}

	public void setQueueExecuteHandler(QueueExecuteHandler<E> queueExecuteHandler) {
		this.queueExecuteHandler = queueExecuteHandler;
	}
	
}
