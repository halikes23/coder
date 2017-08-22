package com.cz.coder.common.cache;

public interface ICache<Key,Value> {

	public void init() ;
	
	public void flush(Class<? extends ICacheFlusher> flusherClass,Object param);
	
	public Value get(Key key);
	
	public void sort(Object obj) ;
	
	public String show() ;
	
	public void del(Key key) ; 
	
}
