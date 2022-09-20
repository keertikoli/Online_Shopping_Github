package org.Zalando_OnlineShopping.genericUtility;

import org.Zalando_Online_Shopping_POM_Pages.CheckOutPage;
import org.Zalando_Online_Shopping_POM_Pages.CommonPage;
import org.Zalando_Online_Shopping_POM_Pages.CreateCategoryPage;
import org.Zalando_Online_Shopping_POM_Pages.InsertProductPage;
import org.Zalando_Online_Shopping_POM_Pages.LoginPage;
import org.Zalando_Online_Shopping_POM_Pages.OrderManagementPage;
import org.Zalando_Online_Shopping_POM_Pages.StatusPage;
import org.Zalando_Online_Shopping_POM_Pages.SubCategoryPage;
import org.Zalando_Online_Shopping_POM_Pages.TrackorderPage;
import org.Zalando_Online_Shopping_POM_Pages.UserPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected String url1;
	protected String username;
	protected String password;
	protected String fullname;
	protected String email;
	protected LoginPage loginPage;
	protected CommonPage commonPage;
	protected WebDriver driver;
	protected WebDriverUtility webDriverUtility;
	protected ExcelUtlity excelUtlity;
	protected FileUtility fileUtility;
	protected InsertProductPage insertProductPage;
	protected int random;
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtility;
	protected String contact;
	protected String confirmpassword;
	protected String passworduser;
	protected String uniqueClothName;
	protected String descriptionArea;
	protected String productName;
	protected String productCompany;
	protected String productpricebd;
	protected String productprice;
	protected String productDescription;
	protected String productShippingcharge;
	protected String productimage1;
	protected String productimage2;
	protected String productimage3;
	protected String passedurlNew;
	protected String emailID;
	protected String url;
	protected UserPage userPage;
	protected CheckOutPage checkOutPage;
	protected String billingaddress;
	protected String bilingstate;
	protected String billingcity;
	protected String billingpincode;
	protected String shippingaddress;
	protected String shippingstate;
	protected String shippingcity;
	protected String shippingpincode;
	protected String expectedurl;
	protected InsertProductPage insertProductPage1;
	protected String parentWindow;
	protected OrderManagementPage orderManagementPage;
	protected StatusPage statusPage;
	protected CreateCategoryPage createCategoryPage;
	protected String text;
	protected String text2;
	protected SubCategoryPage subCategoryPage;
	protected TrackorderPage trackorderPage;
	protected String orderId;
	protected String pass;
	protected String productPrice;
	protected String userpassword;
	protected String userLoginEmail;
	protected String userLoginPassword;
	protected String searchProductName;
	protected String remarkTextField;
	protected TakesScreenshot ts;
	protected JavaUtility javaUtility;

// @Parameters(value="browser")
	@BeforeClass
	public void classsetUp() {
		fileUtility = new FileUtility();
		javaUtility = new JavaUtility();
		sjavaUtility = javaUtility;
		webDriverUtility = new WebDriverUtility();
		excelUtlity = new ExcelUtlity();
		insertProductPage = new InsertProductPage(driver);
		random = javaUtility.getRandomNumber(1000);
		uniqueClothName = "Clothing" + random;
		descriptionArea = "All Brands of cloths are availaible";
		remarkTextField = "Product Delivered Successfully";
		contact = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "contanctNo");
		userpassword = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "password");
		confirmpassword = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2",
				"confirmpassword");
		fullname = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "fullname");
		email = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "email");
		emailID = email + random + "@gmail.com";
		password = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "password");
		productName = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productName");
		productCompany = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productCompany");
		productpricebd = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productpricebd");
		productprice = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productprice");
		productDescription = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productDescription");
		productShippingcharge = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productShippingcharge");
		productimage1 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productimage1");
		productimage2 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productimage2");
		productimage3 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1",
				"productimage3");
		searchProductName = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"productname");
		billingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"billingaddress");
		bilingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "bilingstate");
		billingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "billingcity");
		billingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"billingpincode");
		shippingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"shippingaddress");
		shippingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"shippingstate");
		shippingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "shippingcity");
		shippingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
				"shippingpincode");
		String browser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "browser");
		url = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");
		url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
		username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
		password = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");
		userLoginEmail = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "email");
		userLoginPassword = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passworduser");
		String timeouts = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "timeouts");
		long longTimeout = (long) javaUtility.convertStringIntoDataType(timeouts, DataType.LONG);
		driver = webDriverUtility.openBrowserWithApplication(browser, longTimeout, url);
		sdriver = driver;
		parentWindow = webDriverUtility.switchWindowBasedOnWindow(driver);
		loginPage = new LoginPage(driver);
		commonPage = new CommonPage(driver);
		userPage = new UserPage(driver);
		checkOutPage = new CheckOutPage(driver);
		insertProductPage = new InsertProductPage(driver);
		orderManagementPage = new OrderManagementPage(driver);
		statusPage = new StatusPage(driver, webDriverUtility);
		createCategoryPage = new CreateCategoryPage(driver);
		subCategoryPage = new SubCategoryPage(driver);
		trackorderPage = new TrackorderPage(driver);
	}
	@BeforeMethod
	public void methodSetUp1() {
		loginPage.adminLogin(username, password);
	}
	@AfterMethod
	public void methodTearDown() {
		loginPage.adminLogout();
	}
	@AfterClass
	public void closeBrowser() {
		webDriverUtility.closeBrowser(driver);
	}
}
