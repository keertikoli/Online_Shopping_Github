package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusPage {
@FindBy(xpath = "//select[@class='fontkink']")
private WebElement requiredDropdown;
@FindBy(name = "remark")
private WebElement remarkTextField;
@FindBy(name = "submit2")
private WebElement submitButton;

WebDriverUtility webDriverUtility;

public StatusPage(WebDriver driver,WebDriverUtility webDriverUtility) {
	this.webDriverUtility=webDriverUtility;
	PageFactory.initElements(driver, this);
}

public void statusDropDown(String text) {
	 webDriverUtility.dropDown(requiredDropdown, text);
//	 requiredDropdown.click();
}
public void remarkAction(String text) {
	remarkTextField.sendKeys(text);
	submitButton.click();
}
}
