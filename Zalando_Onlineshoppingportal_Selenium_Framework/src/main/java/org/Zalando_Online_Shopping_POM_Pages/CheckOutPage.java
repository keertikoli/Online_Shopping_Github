package org.Zalando_Online_Shopping_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	@FindBy(name = "billingaddress")
	private WebElement billingAdreessTextField;
	@FindBy(id = "bilingstate")
	private WebElement bilingStateTextField;
	@FindBy(id = "billingcity")
	private WebElement billingCityTextField;
	@FindBy(id = "billingpincode")
	private WebElement billingPinCodeTextField;
	@FindBy(name = "shippingaddress")
	private WebElement shippingAddressTextField;
	@FindBy(id = "shippingstate")
	private WebElement shippingStateTextField;
	@FindBy(id = "shippingcity")
	private WebElement shippingCityTextField;
	@FindBy(id = "shippingpincode")
	private WebElement shippingPinCodeTextField;
	@FindBy(xpath = "//button[text()='PROCCED TO CHEKOUT']")
	private WebElement procedeToCheckOutButton;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement procedeToCheckOutSubmitButton;

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void checkoutActions(String billingaddress, String bilingstate, String billingcity, String billingpincode,
			String shippingaddress, String shippingstate, String shippingcity, String shippingpincode) {
		billingAdreessTextField.sendKeys(billingaddress);
		bilingStateTextField.sendKeys(bilingstate);
		billingCityTextField.sendKeys(billingcity);
		billingPinCodeTextField.sendKeys(billingpincode);
		shippingAddressTextField.sendKeys(shippingaddress);
		shippingStateTextField.sendKeys(shippingstate);
		shippingCityTextField.sendKeys(shippingcity);
		shippingPinCodeTextField.sendKeys(shippingpincode);
		procedeToCheckOutButton.click();
		procedeToCheckOutSubmitButton.click();
	}

}
