package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
@FindBy(xpath = "//input[@placeholder='Search here...']")
private WebElement searchButton;
@FindBy(xpath = "//input[@placeholder='Search here...']/following-sibling::button")
private WebElement searchTab;
@FindBy(xpath = "//div[@class='product-info']//div[@class='row']//span[@class='price']")
private WebElement productPrice;
@FindBy(xpath = "//img[@src='admin/productimages/73/Bug1.PNG']")
private WebElement productTab;
@FindBy(xpath = "//a[text()=' ADD TO CART']")
private WebElement addToCartButton; 

WebDriverUtility webDriverUtility= new WebDriverUtility();

public UserPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	public void searchProductAction(String productname) {
		searchButton.sendKeys(productname);
		searchTab.click();	
	}
	public void productClickAction() {
		productTab.click();
	}
	public String productPriceText() {
		 return productPrice.getText();
	}
	public void addtoCartaAction() {
		addToCartButton.click();
	}
	
}
