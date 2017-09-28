package com.codepandas.framework.conditionedreflex.equal;

import org.junit.Assert;
import org.junit.Test;

import com.codepandas.framework.conditionedreflex.Condition;


public class AutoIncrIntegerModuleEqualConditionTest {

	@Test
	public void testTriggle(){
		Condition<Integer> condition = AutoIncrIntegerModuleEqualCondition.build(5, 0, 0) ;
		Object isTriggled = condition.trigget(5) ;
		Assert.assertNotNull(isTriggled);
		
		isTriggled = condition.trigget(1) ;
		Assert.assertNull(isTriggled);
		
		isTriggled = condition.trigget(4) ;
		Assert.assertNotNull(isTriggled);
	}
	
}
