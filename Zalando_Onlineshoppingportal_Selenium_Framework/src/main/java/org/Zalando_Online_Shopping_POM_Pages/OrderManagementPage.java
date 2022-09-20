package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderManagementPage {
@FindBy(xpath = "//a[normalize-space(text()='Order Management')]/following-sibling::ul[@class='collapse unstyled']/preceding-sibling::a")
private WebElement orderManagementButton;
@FindBy(xpath = "//a[contains(.,'Today')]")
private WebElement todaysOrderButton;
@FindBy(xpath = "//table//tbody/tr[last()]/td[last()]/a")
private WebElement lastTodaysOrderButton;
@FindBy(xpath = "//tbody//tr[2]//td[@class='fontkink']")
private WebElement todaysOrderText;
@FindBy(xpath = "//select")
private WebElement selectDropDown;

WebDriverUtility webDriverUtility= new WebDriverUtility();

public OrderManagementPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
 public void orderManagaementActions() {
	 orderManagementButton.click();
	 todaysOrderButton.click();
 }
 public void selectDropDownOrderMan(String text) {
	 webDriverUtility.dropDown(selectDropDown, text);
 }
 public void clickOnLastOption() {
	 lastTodaysOrderButton.click();
 }
 public String OrderIdText() {
	 return todaysOrderText.getText();
 }
}
