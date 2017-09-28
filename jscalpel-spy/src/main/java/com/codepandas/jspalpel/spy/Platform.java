package com.codepandas.jspalpel.spy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Platform {

	private Set<Spy<?>> spies = new HashSet<Spy<?>>() ;
	
	public void register( Spy<?> spy ){
		spies.add(spy) ;
	}
	
	@RequestMapping("/info")
	public void info(){
		StringBuilder rst = new StringBuilder() ;
		for( Spy<?> spy : spies ){
			spy.collection();
			BaseInfo info = spy.response();
			
		}
	}
	
}
