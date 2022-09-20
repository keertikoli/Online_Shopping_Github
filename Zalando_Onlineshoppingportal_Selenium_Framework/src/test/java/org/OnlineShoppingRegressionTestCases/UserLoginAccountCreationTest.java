package org.OnlineShoppingRegressionTestCases;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_OnlineShopping.genericUtility.IconstantUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UserLoginAccountCreationTest extends BaseClass {
	@Test
	public void userModule() throws InterruptedException {
		webDriverUtility.getUrlAction(driver, url1);
		loginPage.LoginUser();
		loginPage.loginActions(fullname, emailID, contact, userpassword, confirmpassword);
		loginPage.signUp();
		webDriverUtility.acceptAlert(driver);
		loginPage.LoginUser();
		loginPage.signUpActions(emailID, userpassword);
		loginPage.userSubmitAction();
		loginPage.userLogoutTab();
		pass = driver.getCurrentUrl();
		passedurlNew = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "paasedurl2");
		Assert.assertEquals(pass, passedurlNew);
		Reporter.log("Testcase is passed", true);
		webDriverUtility.getUrlAction(driver, url);
		loginPage.adminLogin(username, password);
	}
}
