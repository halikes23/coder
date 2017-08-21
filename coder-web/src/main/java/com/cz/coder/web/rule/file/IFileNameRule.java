package com.fq.rule.file;

public interface IFileNameRule<T> {

	Result build(T obj) ;
	
}
