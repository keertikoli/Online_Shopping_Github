package org.Zalando_Online_Shopping_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackorderPage {
@FindBy(xpath = "//span[text()='Track Order']")
private WebElement trackOrderButton;
@FindBy(id = "exampleOrderId1")
private WebElement orderIdTextField;
@FindBy(id = "exampleBillingEmail1")
private WebElement emailIdTextField;
@FindBy(xpath = "//button[text()='Track']")
private WebElement trackSubmitButton;


public TrackorderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	public void trackOrderActions(String orderId,String email) {
		trackOrderButton.click();
		orderIdTextField.sendKeys(orderId);
		emailIdTextField.sendKeys(email);
		trackSubmitButton.click();
	}
}
