package org.zalando.PracticeTestCases;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_OnlineShopping.genericUtility.ListenerImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotPracactice extends BaseClass {
@Test
public void screenshot() {
	ListenerImplementation.stest.assignAuthor("Rishikesh");
	ListenerImplementation.stest.assignCategory("Regression");
	Assert.fail();
}
}
