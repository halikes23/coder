package com.codepandas.framework.conditionedreflex;

public class ConditionReflexFactory {

	public static ConditionReflex build(Condition condition,Reflex reflex){
		return new ConditionReflex(condition,reflex) ;
	}
	
}
