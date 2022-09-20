package org.OnlineShoppingRegressionTestCases;

import org.Zalando_OnlineShopping.genericUtility.BaseClass;
import org.Zalando_Online_Shopping_POM_Pages.CreateCategoryPage;
import org.Zalando_Online_Shopping_POM_Pages.SubCategoryPage;
import org.Zalando_Online_Shopping_POM_Pages.TabNames;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateCategorySubCategoryInsertProductTest extends BaseClass {
	@Test
	public void CreateProductTest() {
		webDriverUtility.verifyCurrentPage(driver, "Shopping Portal", "admin page is verified");
		CreateCategoryPage createCategoryPage = new CreateCategoryPage(driver);
		SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
		commonPage.clickRequiredTab(TabNames.Create_Category, webDriverUtility);
		createCategoryPage.createCategotyActions(uniqueClothName, descriptionArea);
		commonPage.dropDownOfSelCat("100");
		String text = createCategoryPage.categoryText();
		Reporter.log(text, true);
		Assert.assertEquals(text, uniqueClothName);
		Reporter.log("Category is created", true);
		commonPage.clickRequiredTab(TabNames.Sub_Category, webDriverUtility);
		commonPage.dropDownOfSelsubCat(uniqueClothName);
		subCategoryPage.subCategoryActions("Tshirts");
		commonPage.dropDownOfSelCat("100");
		String text2 = subCategoryPage.subCategoryGetText();
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
	}
}
