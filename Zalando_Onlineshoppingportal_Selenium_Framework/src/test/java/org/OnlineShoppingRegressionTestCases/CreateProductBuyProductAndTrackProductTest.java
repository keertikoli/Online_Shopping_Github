package org.OnlineShoppingRegressionTestCases;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_Online_Shopping_POM_Pages.TabNames;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateProductBuyProductAndTrackProductTest extends BaseClass {
	@Test

	public void endToEndTestCase() {
		commonPage.clickRequiredTab(TabNames.Create_Category, webDriverUtility);
		createCategoryPage.createCategotyActions(uniqueClothName, descriptionArea);
		commonPage.dropDownOfSelCat("100");
		text = createCategoryPage.categoryText();
		Reporter.log(text, true);
		Assert.assertEquals(text, uniqueClothName);
		Reporter.log("Category is created", true);
		commonPage.clickRequiredTab(TabNames.Sub_Category, webDriverUtility);
		commonPage.dropDownOfSelsubCat(uniqueClothName);
		subCategoryPage.subCategoryActions("Tshirts");
		commonPage.dropDownOfSelCat("100");
		text2 = subCategoryPage.subCategoryGetText();
		Reporter.log(text2, true);
		Assert.assertEquals(text2, uniqueClothName);
		Reporter.log("SubCategory is created", true);
		commonPage.clickRequiredTab(TabNames.Insert_Product, webDriverUtility);
		commonPage.dropDownOfSelsubCat(uniqueClothName);
		commonPage.subCategotyDropDown("Tshirts");
		insertProductPage.insertProductActions(productName, productCompany, productpricebd, productprice,
				productDescription, productShippingcharge);
		commonPage.dropDownOfSelInsert("In Stock");
		insertProductPage.insertImageActions(productimage1, productimage2, productimage3);
		webDriverUtility.getUrl(driver, url1);
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
		webDriverUtility.getUrl(driver, url);
		loginPage.adminLogin(username, password);
		orderManagementPage.orderManagaementActions();
		orderManagementPage.selectDropDownOrderMan("100");
		orderManagementPage.clickOnLastOption();
		webDriverUtility.switchWindowBasedOnUrlContain(driver, "updateorder.php?");
		statusPage.statusDropDown("Delivered");
		statusPage.remarkAction("happily deleverd");
		webDriverUtility.acceptAlert(driver);
		String orderId = orderManagementPage.OrderIdText();
		Reporter.log(orderId, true);
		webDriverUtility.closeopenedBrowser(driver);
		webDriverUtility.switchWindowBasedOnUrlContain(driver, parentWindow);
		webDriverUtility.getUrl(driver, url1);
		trackorderPage.trackOrderActions(orderId, email);
		Assert.assertEquals(pass, expectedurl);
		Reporter.log("Testcase is passed", true);
	}
}
