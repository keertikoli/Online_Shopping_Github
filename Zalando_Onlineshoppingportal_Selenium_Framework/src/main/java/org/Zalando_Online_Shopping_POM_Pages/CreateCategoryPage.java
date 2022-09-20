package org.Zalando_Online_Shopping_POM_Pages;

import org.Zalando_OnlineShopping.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
@FindBy(name = "category")
private WebElement createCategoryTextField;
@FindBy(name = "description")
private WebElement descriptionTextField;
@FindBy(name = "submit")
private WebElement categorySubmitButton;
@FindBy(xpath = "//i[@class='icon-chevron-right shaded']")
private WebElement categoryEditButton;
@FindBy(xpath = "//table//tbody/tr[last()]/td[2]")
private WebElement createCategoryText;


WebDriverUtility webDriverUtility= new WebDriverUtility();

public CreateCategoryPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void createCategotyActions(String uniqueClothName,String descriptionArea) {
	createCategoryTextField.sendKeys(uniqueClothName);
	descriptionTextField.sendKeys(descriptionArea);
	categorySubmitButton.click();
	categoryEditButton.click();
}
public String categoryText() {
	return createCategoryText.getText();
}
}

