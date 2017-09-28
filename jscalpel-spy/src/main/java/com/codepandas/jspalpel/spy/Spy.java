package com.codepandas.jspalpel.spy;

public interface Spy<Info extends BaseInfo> {

	void register() ;
	
	void collection() ;
	
	Info response() ;
	
}
