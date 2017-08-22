package com.cz.coder.common.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.util.CollectionUtils;

public class RandomList<T> implements BaseLinkedList<T>{

	private final List<T> list = new ArrayList<T>() ;
	private Random random = new Random() ;
	@Override
	public boolean hasNext() {
		if( CollectionUtils.isEmpty(list) ){
			return false ;
		}
		return true;
	}

	@Override
	public T next() {
		
		Integer range = list.size() ;
		Integer index = random.nextInt(range) ;
		
		return list.get(index);
	}

	@Override
	public void add(T obj) {
		list.add(obj) ;
	}
	
	@Override
	public void remove() {
        throw new UnsupportedOperationException("remove");
	}
	
	
}
