package org.Zalando_Online_Shopping_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {
	@FindBy(name = "productName")
	private WebElement productnameTextField;
	@FindBy(name = "productCompany")
	private WebElement productCompanyTextField;
	@FindBy(name = "productpricebd")
	private WebElement productpricebdTextField;
	@FindBy(xpath="//input[@name='productprice']")
	private WebElement productpriceTextField;
	@FindBy(xpath="//textarea[@name='productDescription']")
	private WebElement productDescriptionTextField;
	@FindBy(xpath="//input[@name='productShippingcharge']")
	private WebElement productShippingchargeTextField;
	@FindBy(name = "productimage1")
	private WebElement productImageInsertOption;
	@FindBy(name = "productimage2")
	private WebElement productimage2ImageInsertOption;
	@FindBy(name = "productimage3")
	private WebElement productimage3ImageInsertOption;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement insertSubmitButton;
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement insertDropDown;
	
	public InsertProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void insertProductActions(String productName, String productCompany, String productpricebd,
			String productprice, String productDescription, String productShippingcharge) {
		productnameTextField.sendKeys(productName);
		productCompanyTextField.sendKeys(productCompany);
		productpricebdTextField.sendKeys(productpricebd);
		productpriceTextField.sendKeys(productprice);
		productDescriptionTextField.sendKeys(productDescription);
		productShippingchargeTextField.sendKeys(productShippingcharge);
	}
	public void insertImageActions(String productimage1,String productimage2,String productimage3) {
		productImageInsertOption.sendKeys(productimage1);
		productimage2ImageInsertOption.sendKeys(productimage2);
		productimage3ImageInsertOption.sendKeys(productimage3);
	}
	public String insertDropDownSel() {
		return insertDropDown.getText();
	}
}
