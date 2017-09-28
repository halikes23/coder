package com.codepandas.framework.conditionedreflex;

public class ConditionReflex {

	private Reflex<Object,Object> reflex ;
	
	private Condition<Object> condition ;
	
	ConditionReflex(Condition<Object> condition,Reflex<Object,Object> reflex){
		this.reflex = reflex ;
		this.condition = condition ;
	}
	
	public boolean change(Object value,Object context) {
		
		Object triggeredCondition = this.condition.trigget(value) ;
		if(triggeredCondition != null){
			this.reflex.action(triggeredCondition,context) ;
			return true ;
		}
		return false ;
		
	}
	
}
