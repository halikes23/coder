package com.codepandas.framework.conditionedreflex.equal;

import com.codepandas.framework.conditionedreflex.Condition;

public class EqualCondition implements Condition<Object>{

	private Object comparisonObject ;
	
	private EqualCondition( Object comparisonObject ){
		this.comparisonObject = comparisonObject ;
	}
	
	public static EqualCondition build(Object comparisonObject){
		
		return new EqualCondition(comparisonObject);
		
	}
	
	public Object trigget(Object value) {
		if( value == null || comparisonObject == null || ! value.equals(comparisonObject) ){
			return null ;
		}else{
			return value ;
		}
	}

	public Object getTriggeredCircumstance() {
		return comparisonObject;
	}
	
}
