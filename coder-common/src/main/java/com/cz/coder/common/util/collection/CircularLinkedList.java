package com.cz.coder.common.util.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 循环链表
 * @author zhen.cheng
 *
 * @param <T>
 */
public class CircularLinkedList<T> implements Iterator<T> {
	
	private final static Logger logger = LoggerFactory.getLogger(CircularLinkedList.class) ;

	private IteratorEntity<T> current ;
	
	private Map<Long,IteratorEntity<T>> map = new HashMap<Long,IteratorEntity<T>>() ;
	
	private Long size = 0L ;
	
	public void addAll(T ... objs){
		for(T obj : objs){
			add(obj);
		}
	}
	
	public void add(T obj){
		synchronized (size) {
			IteratorEntity<T> newCurrent = new IteratorEntity<T>(obj) ;
			if( current == null ){
				current = newCurrent ;
				newCurrent.setNext(current);
				newCurrent.setPrev(current);
				
			}else{
				newCurrent.setNext(current.getNext());
				newCurrent.setPrev(current);
				current.getNext().setPrev(newCurrent);
				current.setNext(newCurrent);
				next();
				
			}
			current.setIndex(size);
			map.put(size, current) ;
			
			size ++ ;
		}
		
	}
	
	@Override
	public void remove() {
		if(current == null){
			return ;
		}
		
		synchronized (size) {
			if( current.getPrev().equals(current) && current.getNext().equals(current) ){
				// 只有一个元素 
				current = null ;
			}else{
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				next();
			}
			map.remove(current.getObj()) ;
			size -- ;
		}
		
	}

	@Override
	public boolean hasNext() {
		if( current == null ){
			return false ;
		}
		return true;
	}

	@Override
	public T next() {
		if(current == null){
			return null ;
		}else{
			current = current.getNext() ;
			return current.getObj();
		}
	}
	
	public void move(Long index){
		if(map.get(index)!= null){
			current = map.get(index) ;
		}
		
	}
	
	public Long getCurrentIndex(){
		return current.getIndex() ;
	}
	
	
}
