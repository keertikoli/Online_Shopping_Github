package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	private WebDriver driver;
	private String dynamicXpath="//a[text()='%s']";
	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement categoryDropDown;
	@FindBy(xpath = "//select[@name='category']")
	private WebElement subCategoryDropDown;
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement insertDropDown;
	@FindBy(id = "subcategory")
	private WebElement subNameDropDown;

	WebDriverUtility webDriverUtility= new WebDriverUtility();
	
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		public void clickRequiredTab(String tabName,WebDriverUtility webDriverUtility) {
			webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath,tabName, driver).click();
		}
		public void dropDownOfSelCat(String text) {
			webDriverUtility.dropDown(categoryDropDown, text);
}
		public void dropDownOfSelsubCat(String text) {
			webDriverUtility.dropDown(subCategoryDropDown, text);
}
		public void dropDownOfSelInsert(String text) {
			webDriverUtility.dropDown(insertDropDown, text);
}
		public void subCategotyDropDown(String text) {
			webDriverUtility.dropDown(subNameDropDown, text);
		}
}

