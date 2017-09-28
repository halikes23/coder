package com.codepandas.framework.conditionedreflex;

public interface Condition<T> {

	/**
	 * 
	 * @param condition
	 * @return 没有触发必须返回null
	 */
	public Object trigget(T condition);
	
}
