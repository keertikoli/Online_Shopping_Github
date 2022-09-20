package org.zalando.PracticeTestCases;

import org.Zalando_OnlineShopping.genericUtility.DataType;
import org.Zalando_OnlineShopping.genericUtility.FileUtility;
import org.Zalando_OnlineShopping.genericUtility.IconstantUtility;
import org.Zalando_OnlineShopping.genericUtility.JavaUtility;
import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;



public class Launchingemptybrowser {

	public static void main(String[] args) throws Throwable {
		FileUtility fileUtility = new FileUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		String browser=fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH,"browser");
		String url=fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH,"url");
		String timeouts=fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH,"timeouts");
		long longTimeout = (long) javaUtility.convertStringIntoDataType(timeouts, DataType.LONG);
		
		WebDriver driver =webDriverUtility.openBrowserWithApplication(browser,longTimeout, url);
		webDriverUtility.closeBrowser(driver);
	}

}
