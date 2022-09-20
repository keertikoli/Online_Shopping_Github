package org.zalando.PracticeTestCases;

import java.lang.reflect.Method;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgExecution1 extends BaseClass {
	@Test(groups = "sanity", retryAnalyzer = org.Zalando_OnlineShopping.genericUtility.ImplimatationOfIRetryAnalyzer.class)
	public void testScript1(Method mtd) {
//	Assert.fail();
		Reporter.log(mtd.getName() + "Current thread Id is" + Thread.currentThread().getId(), true);
	}
}
