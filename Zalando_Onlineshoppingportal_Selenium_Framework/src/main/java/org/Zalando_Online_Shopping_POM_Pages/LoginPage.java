package org.Zalando_Online_Shopping_POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// declaration
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginTab;
	@FindBy(id = "fullname")
	private WebElement fullNameTextField;
	@FindBy(id = "email")
	private WebElement emailTextField;
	@FindBy(id = "contactno")
	private WebElement contactnoTextField;
	@FindBy(id = "password")
	private WebElement passwordTextField;
	@FindBy(id = "confirmpassword")
	private WebElement confirmpasswordTextField;
	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpButton;
	@FindBy(id = "exampleInputEmail1")
	private WebElement enterEmailTextField;
	@FindBy(id = "exampleInputPassword1")
	private WebElement enterPasswordTextField;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement submitButton;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;
	@FindBy(id = "inputEmail")
	private WebElement adminUserNameTextField;
	@FindBy(id = "inputPassword")
	private WebElement adminPasswordTextField;
	@FindBy(name = "submit")
	private WebElement adminsubmitButton;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement logoutDropDownToggle;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutTab;

//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Business library
	public void LoginUser() {
		loginTab.click();
	}
	public void loginActions(String fullname, String emailID, String contact, String password, String confirmpassword) {
		//loginTab.click();
		fullNameTextField.sendKeys(fullname);
		emailTextField.sendKeys(emailID); 
		contactnoTextField.sendKeys(contact);
		passwordTextField.sendKeys(password);
		confirmpasswordTextField.sendKeys(confirmpassword);
	}
	public void signUp() {
		signUpButton.click();
	}
		public void signUpActions( String email, String password)  {
		enterEmailTextField.sendKeys(email);
		enterPasswordTextField.sendKeys(password);
	}
		public void userSubmitAction() {
			submitButton.click();
		}
		public void userLogoutTab() {
			logoutButton.click();
		}
		public void adminLogin(String username,String password) {
			adminUserNameTextField.sendKeys(username);
			adminPasswordTextField.sendKeys(password);
			adminsubmitButton.click();
		}
		public void adminLogout() {
			logoutDropDownToggle.click();
			logoutTab.click();
		}
		public void userLoginButton(String email,String passworduser) {
			loginTab.click();
			enterEmailTextField.sendKeys(email);
			enterPasswordTextField.sendKeys(passworduser);
			submitButton.click();
		}
}
