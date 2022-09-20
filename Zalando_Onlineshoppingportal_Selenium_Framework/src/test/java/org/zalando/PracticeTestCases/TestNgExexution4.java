package org.zalando.PracticeTestCases;

import java.lang.reflect.Method;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgExexution4 extends BaseClass{
	@Test(groups ="regression")
	public void testScript4(Method mtd) {
		Reporter.log(mtd.getName() + " Current thread Id is " +Thread.currentThread().getId(),true);
}
}

