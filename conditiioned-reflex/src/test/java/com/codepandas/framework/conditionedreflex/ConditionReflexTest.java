package com.codepandas.framework.conditionedreflex;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.codepandas.framework.conditionedreflex.equal.AutoIncrIntegerModuleEqualCondition;

public class ConditionReflexTest {

	@Test
	public void testChange(){
		
		Condition<Integer> condition = AutoIncrIntegerModuleEqualCondition.build(5, 1, 0) ;
		
		TestReflex reflex = new TestReflex() ;
		
		ConditionReflex conditionReflex = ConditionReflexFactory.build(condition, reflex) ;
		
		boolean isTriggered = conditionReflex.change(5,1);
		
		Assert.assertFalse(isTriggered);
		Assert.assertFalse(reflex.getIsTriggered());
		
		isTriggered = conditionReflex.change(1,2);
		Assert.assertTrue(isTriggered);
		Assert.assertTrue(reflex.getIsTriggered());
		
		isTriggered = conditionReflex.change(5,3);
		
	}
	
	
	class TestReflex implements Reflex<Integer,Integer>{

		private boolean isTriggered ;
		
		public void action(Integer triggledCondition,Integer code) {
			System.out.println("trigger condition : " + triggledCondition.toString() + " code:" + code);
			isTriggered = true ;
		}
		
		public boolean getIsTriggered(){
			return this.isTriggered ;
		}
		
	}
	
}
