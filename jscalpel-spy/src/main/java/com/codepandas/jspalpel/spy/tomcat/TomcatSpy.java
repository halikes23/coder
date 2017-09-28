package com.codepandas.jspalpel.spy.tomcat;

import org.springframework.web.bind.annotation.RestController;

import com.codepandas.jspalpel.spy.Spy;

@RestController
public class TomcatSpy implements Spy<TomcatInfo>{

	public void register() {
		
	}

	public void collection() {
		
	}

	public TomcatInfo response() {
		return null ;
	}

	
	
}
