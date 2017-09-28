package com.codepandas.framework.conditionedreflex.equal;

import com.codepandas.framework.conditionedreflex.Condition;

public class IntegerModuleEqualCondition implements Condition<Integer>{

	private int module ;
	
	private EqualCondition equalCondition ;
	
	private Integer value ;
	
	private IntegerModuleEqualCondition(int module , int remainder){
		this.module = module ;
		equalCondition = EqualCondition.build(remainder) ;
	}
	
	public static IntegerModuleEqualCondition build(int module , int remainder){
		return new IntegerModuleEqualCondition(module,remainder) ;
	}
	
	public Object trigget(Integer value) {
		Object triggeredCondition = this.equalCondition.trigget( value % module ) ;
		if( triggeredCondition != null ){
			return value ;
		}
		return null ;
		
	}

	public Object getTriggeredCircumstance() {
		return value;
	}
	
	
	
}
