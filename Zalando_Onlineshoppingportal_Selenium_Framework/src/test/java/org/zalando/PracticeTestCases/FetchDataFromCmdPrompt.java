package org.zalando.PracticeTestCases;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class FetchDataFromCmdPrompt {
@Test
public void simpleTest() {
	String browser = System.getProperty("b");
	String urlcmd = System.getProperty("u");
	
	System.out.println("Browser Name is<<<<>>>>>>  "+browser);
    System.out.println("Url name is<<<<>>>>>>  "+urlcmd);
    
    WebDriverUtility webDriverUtility=new WebDriverUtility();
    webDriverUtility.openBrowserWithApplication(browser, 10l, urlcmd);
}
}
