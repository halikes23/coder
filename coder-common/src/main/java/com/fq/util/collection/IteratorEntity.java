package com.fq.util.collection;

public class IteratorEntity<T> {

	private IteratorEntity<T> next ;
	
	private IteratorEntity<T> prev ;
	
	private T obj ;
	
	private Long index ;
	
	
	IteratorEntity(T obj){
		this.obj = obj ;
	}

	IteratorEntity<T> getNext() {
		return next;
	}

	void setNext(IteratorEntity<T> next) {
		this.next = next;
	}

	IteratorEntity<T> getPrev() {
		return prev;
	}

	void setPrev(IteratorEntity<T> prev) {
		this.prev = prev;
	}

	T getObj() {
		return obj;
	}

	void setObj(T obj) {
		this.obj = obj;
	}

	Long getIndex() {
		return index;
	}

	void setIndex(Long index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "IteratorEntity [next=" + next.getObj() + ", prev=" + prev.getObj() + ", obj="
				+ obj + "]";
	}
	
	
	
}
