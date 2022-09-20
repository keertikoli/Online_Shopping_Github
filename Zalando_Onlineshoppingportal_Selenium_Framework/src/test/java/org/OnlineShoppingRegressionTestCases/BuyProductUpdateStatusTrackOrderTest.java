package org.OnlineShoppingRegressionTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_OnlineShopping.genericUtility.IconstantUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BuyProductUpdateStatusTrackOrderTest extends BaseClass {
	@Test
	public void updateOrder() throws FileNotFoundException, IOException, InterruptedException {
		webDriverUtility.getUrlAction(driver, url1);
		loginPage.LoginUser();
		loginPage.signUpActions(userLoginEmail, userLoginPassword);
		loginPage.userSubmitAction();
		userPage.searchProductAction(searchProductName);
		userPage.productClickAction();
		String productPrice = userPage.productPriceText();
		Reporter.log(productPrice, true);
		userPage.addtoCartaAction();
		webDriverUtility.acceptAlert(driver);
		checkOutPage.checkoutActions(billingaddress, bilingstate, billingcity, billingpincode, shippingaddress,
				shippingstate, shippingcity, shippingpincode);
		String parentWindow = webDriverUtility.switchWindowBasedOnWindow(driver);
		webDriverUtility.getUrl(driver, url);
		loginPage.adminLogin(username, password);
		orderManagementPage.orderManagaementActions();
		orderManagementPage.selectDropDownOrderMan("100");
		orderManagementPage.clickOnLastOption();
		webDriverUtility.switchWindowBasedOnUrlContain(driver, "updateorder.php");
		String orderId = orderManagementPage.OrderIdText();
		statusPage.statusDropDown("Delivered");
		statusPage.remarkAction(remarkTextField);
		webDriverUtility.acceptAlert(driver);
		Reporter.log(orderId, true);
		webDriverUtility.closeopenedBrowser(driver);
		webDriverUtility.switchWindowBasedOnUrlContain(driver, parentWindow);
		webDriverUtility.getUrlAction(driver, url1);
		trackorderPage.trackOrderActions(orderId, email);
		loginPage.userLogoutTab();
		String pass = webDriverUtility.getcurrenrUrl(driver);
		expectedurl = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "paasedurl2");
		Assert.assertEquals(pass, expectedurl);
		Reporter.log("Testcase is pass", true);
		webDriverUtility.getUrlAction(driver, url);
		loginPage.adminLogin(username, password);
	}
}
