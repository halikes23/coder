package com.codepandas.framework.conditionedreflex.equal;

import com.codepandas.framework.conditionedreflex.Condition;

/**
 * 该类是线程安全的
 * @author cz
 *
 */
public class AutoIncrIntegerModuleEqualCondition implements Condition<Integer>{

	private Integer currentNum ;
	
	private IntegerModuleEqualCondition integerModuleEqualCondition ;
	
	public static AutoIncrIntegerModuleEqualCondition build(Integer module , Integer remainder, Integer currentNum){
		
		return new AutoIncrIntegerModuleEqualCondition(module, remainder, currentNum) ;
		
	}
	
	private AutoIncrIntegerModuleEqualCondition(Integer module , Integer remainder, Integer currentNum){
		
		this.currentNum = currentNum ;
		
		integerModuleEqualCondition = IntegerModuleEqualCondition.build(module, remainder) ;
		
	}
	
	/**
	 * 方法会阻塞
	 */
	public synchronized Object trigget(Integer incrNum) {
		
		currentNum += incrNum ;
		
		return this.integerModuleEqualCondition.trigget(currentNum) ;
		
	}

	protected Integer getCurrentNum() {
		return currentNum;
	}
	
}
