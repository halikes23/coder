package com.codepandas.framework.conditionedreflex;

public interface Reflex<T,C> {

	public void action(T triggeredCondition,C context) ;
	
}
