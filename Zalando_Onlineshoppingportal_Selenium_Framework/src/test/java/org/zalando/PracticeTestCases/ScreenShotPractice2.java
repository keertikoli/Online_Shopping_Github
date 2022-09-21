package org.zalando.PracticeTestCases;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_OnlineShopping.genericUtility.ListenerImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenShotPractice2 extends BaseClass {
	@Test
public void Screenshot() {
 	ListenerImplementation.stest.assignAuthor("Keerti");
	ListenerImplementation.stest.assignCategory("Smoke");
	ListenerImplementation.stest.info("Browser Launched Successfully");
	ListenerImplementation.stest.info("LoginSuccessfully");
	ListenerImplementation.stest.info("Home Page Displayed Successfully");
	Assert.fail();
}
}     
