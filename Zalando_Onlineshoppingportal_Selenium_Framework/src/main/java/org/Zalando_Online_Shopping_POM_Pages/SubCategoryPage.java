package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
@FindBy(xpath = "//input[@placeholder='Enter SubCategory Name']")
private WebElement subCategoryTectField;
@FindBy(name = "submit")
private WebElement subCategorySubmitButton;
@FindBy(xpath = "//i[@class='icon-chevron-right shaded']")
private WebElement subCategoryEditButton;
@FindBy(xpath = "//table//tbody/tr[last()]/td[2]")
private WebElement subCategorytext;

WebDriverUtility webDriverUtility= new WebDriverUtility();

public SubCategoryPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	public void subCategoryActions(String subCategoryName) {
		//subCategoryTectField.click();
		subCategoryTectField.sendKeys(subCategoryName);
		subCategorySubmitButton.click();
		subCategoryEditButton.click();
		}
	public String subCategoryGetText() {
		return subCategorytext.getText();
	}
			
	}
	

