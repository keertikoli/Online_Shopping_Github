package org.OnlineShoppingGeneralTestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		driver.findElement(By.name("category")).sendKeys("Clothing");
		driver.findElement(By.name("description")).sendKeys("All Brands of cloths are availaible");
		driver.findElement(By.name("submit")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("100");

		WebElement text = driver.findElement(By.xpath("//td[text()='Clothing']"));
		if (text.equals("Clothing")) {
			System.out.println("Category is created");
		} else {
			System.out.println("Category is not created");
		}

		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='category']"));
		Select s1 = new Select(dropdown2);
		s1.selectByVisibleText("Clothing");
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Tshirts");
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='category']"));
		Select s2 = new Select(dropdown3);
		s2.selectByVisibleText("Clothing");
		WebElement dropdown4 = driver.findElement(By.id("subcategory"));
		Select s3 = new Select(dropdown4);
		s3.selectByVisibleText("Tshirts");
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys("For kids");

		driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys("trends");

		driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys("1000");

		driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys("900");

		driver.findElement(By.xpath("//textarea[@name='productDescription']")).sendKeys("comfortable");

		driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys("0");

		WebElement dropdown5 = driver.findElement(By.xpath("//select[@name='productAvailability']"));
		Select s4 = new Select(dropdown5);
		s4.selectByVisibleText("In Stock");

		driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys("C:\\Users\\rishikesh\\Pictures\\Bug1.PNG");
		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\Users\\rishikesh\\Pictures\\Bug2.PNG");
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\Users\\rishikesh\\Pictures\\bug3.PNG");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("kee@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.name("product")).sendKeys("for kids");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(3000);
		Alert a = driver.switchTo().alert();
		a.accept();
		driver.findElement(By.name("billingaddress")).sendKeys("katraguppe");
		driver.findElement(By.id("bilingstate")).sendKeys("karnataka");
		driver.findElement(By.id("billingcity")).sendKeys("bangalore");
		driver.findElement(By.id("billingpincode")).sendKeys("436543");
		driver.findElement(By.name("shippingaddress")).sendKeys("katraguppe");
		driver.findElement(By.id("shippingstate")).sendKeys("karnataka");
		driver.findElement(By.id("shippingcity")).sendKeys("bangalore");
		driver.findElement(By.id("shippingpincode")).sendKeys("436543");
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("(//a[normalize-space(text()='Order Management')])[7]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'icon-edit')])[1]")).click();
		Set<String> child = driver.getWindowHandles();
		for(String b:child) {
			driver.switchTo().window(b);
		}
	    WebElement drp = driver.findElement(By.name("status"));
		Select sx= new Select(drp);
		sx.selectByVisibleText("Delivered");
		driver.findElement(By.name("remark")).sendKeys("happily deleverd");
		driver.findElement(By.name("submit2")).click();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("kee@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Track Order']")).click();
		driver.findElement(By.id("exampleOrderId1")).sendKeys("34");
		driver.findElement(By.id("exampleBillingEmail1")).sendKeys("kee@gmail.com");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Track')]")).click();
	}
}
//FileUtility fileUtility = new FileUtility();
//JavaUtility javaUtility = new JavaUtility();
//WebDriverUtility webDriverUtility = new WebDriverUtility();
//ExcelUtlity excelUtlity = new ExcelUtlity();
//int random = javaUtility.getRandomNumber(1000);
//String browser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "browser");
//String url = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");
//String timeouts = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "timeouts");
//long longTimeout = (long) javaUtility.convertStringIntoDataType(timeouts, DataType.LONG);
//WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, longTimeout, url);
//LoginPage loginPage = new LoginPage(driver);
//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//String password = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");
//loginPage.adminLogin(username, password);
//CommonPage commonPage = new CommonPage(driver);

//System.out.println(text);
//if (text.equals(uniqueClothName)) {
//	System.out.println("Category is created");
//} else {
//	System.out.println("Category is not created");
//}

//System.out.println(text2);
//if (text2.equals(uniqueClothName)) {
//	System.out.println("SubCategory is created");
//} else {
//	System.out.println("SubCategory is not created");
//}

//String productName = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productName");
//String productCompany = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productCompany");
//String productpricebd = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productpricebd");
//String productprice = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productprice");
//String productDescription = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productDescription");
//String productShippingcharge = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productShippingcharge");
//InsertProductPage insertProductPage = new InsertProductPage(driver);


//String productimage1 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productimage1");
//String productimage2 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productimage2");
//String productimage3 = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase1", "productimage3");


//loginPage.adminLogout();


//FileUtility fileUtility = new FileUtility();
//String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//
//	String email = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "email");
//	String passworduser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passworduser");
//	
//	String productname = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"productname");
//	UserPage userPage = new UserPage(driver);
//	
//	String productPrice = userPage.productPriceText();
//	System.out.println(productPrice);
	
//	String billingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"billingaddress");
//	String bilingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"bilingstate");
//	String billingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"billingcity");
//	String billingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"billingpincode");
//	String shippingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"shippingaddress");
//	String shippingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"shippingstate");
//	String shippingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"shippingcity");
//	String shippingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//			"shippingpincode");
//	CheckOutPage checkOutPage = new CheckOutPage(driver);
	
//	String parentWindow = webDriverUtility.switchWindowBasedOnWindow(driver);

	
	
	
//	FileUtility fileUtility = new FileUtility();
//	String url = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");
//	
//	loginPage.adminLogin(username, password);
//	
//	String orderId = orderManagementPage.OrderIdText();
//	StatusPage statusPage = new StatusPage(driver,webDriverUtility);
	
//	String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
	
//	String email = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "email");
//	String url2 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//	webDriverUtility.openBrowserWithApplication(browser, longTimeout, url2);
//	TrackorderPage trackorderPage = new TrackorderPage(driver);
	
//	String pass = webDriverUtility.getcurrenrUrl(driver);
//	String passedurl = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passedurl");
	
//	if(pass.equals(passedurl)) {
//		System.out.println("Testcase is pass");
//	}
//	else {
//		System.out.println("Testcase is fail");
//	}

//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//driver.findElement(By.id("inputEmail")).sendKeys(username);
//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//driver.findElement(By.id("inputPassword")).sendKeys(password);
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
//int random = javaUtility.getRandomNumber(100);
//driver.findElement(By.name("category")).sendKeys("Clothing"+" "+random);
//driver.findElement(By.name("description")).sendKeys("All Brands of cloths are availaible");
//driver.findElement(By.name("submit")).click();
//WebElement select = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//webDriverUtility.dropDown(select, "100");
//driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']")).click();
//String text = driver.findElement(By.xpath("//table//tbody/tr[last()]/td[2]")).getText();
//System.out.println(text);
//if (text.equals("Clothing"+" "+random)) {
//	System.out.println("Category is created");
//} else {
//	System.out.println("Category is not created");
//}
//driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
//WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='category']"));
//webDriverUtility.dropDown(dropdown2, "Clothing"+" "+random);
//driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Tshirts");
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']")).click();
//WebElement select2 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//webDriverUtility.dropDown(select2, "100");
//String text2 = driver.findElement(By.xpath("//table//tbody/tr[last()]/td[2]")).getText();
//System.out.println(text2);
//if (text2.equals("Clothing" +random)) {
//	System.out.println("SubCategory is created");
//} else {
//	System.out.println("SubCategory is not created");
//}
//driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
//WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='category']"));
//webDriverUtility.dropDown(dropdown3, "Clothing"+" "+random);
//WebElement dropdown4 = driver.findElement(By.id("subcategory"));
//webDriverUtility.dropDown(dropdown4, "Tshirts");
//driver.findElement(By.name("submit")).click();
//String productName = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 0);
//driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);
//String productCompany = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 1);
//driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys(productCompany);
//String productpricebd = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 2);
//driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys(productpricebd);
//String productprice = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 3);
//driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys(productprice);
//String productDescription = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 4);
//driver.findElement(By.xpath("//textarea[@name='productDescription']")).sendKeys(productDescription);
//String productShippingcharge = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1",3, 5);
//driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys(productShippingcharge);
//WebElement dropdown5 = driver.findElement(By.xpath("//select[@name='productAvailability']"));
//webDriverUtility.dropDown(dropdown5, "In Stock");
//String productimage1 = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1", 1, 0);
//driver.findElement(By.xpath("//input[@id='productimage1']"))
//		.sendKeys(productimage1);
//String productimage2 = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1", 1, 1);
//driver.findElement(By.xpath("//input[@name='productimage2']"))
//		.sendKeys(productimage2);
//String productimage3 = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase1", 1, 2);
//driver.findElement(By.xpath("//input[@name='productimage3']"))
//		.sendKeys(productimage3);
//driver.findElement(By.xpath("//button[@name='submit']")).click();
//driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//driver.findElement(By.xpath("//a[text()='Logout']")).click();
//String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//driver.get(url1);
//driver.findElement(By.xpath("//a[text()='Login']")).click();
//String email = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "email");
//driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
//String passworduser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passworduser");
//driver.findElement(By.id("exampleInputPassword1")).sendKeys(passworduser);
//driver.findElement(By.xpath("//button[text()='Login']")).click();
//String productname = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 1, 0);
//driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(productname);
//driver.findElement(By.xpath("//input[@placeholder='Search here...']/following-sibling::button")).click();
//String productPrice = driver
//		.findElement(By.xpath("//a[text()='" + productname + "']/parent::h3/following-sibling::div/span"))
//		.getText();
//System.out.println(productPrice);
//driver.findElement(By.xpath("//a[text()='" + productname + "']")).click();
//driver.findElement(By.xpath("//a[text()=' ADD TO CART']")).click();
//driver.switchTo().alert().accept();
//String billingaddress = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 3, 0);
//driver.findElement(By.name("billingaddress")).sendKeys(billingaddress);
//String bilingstate = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 3, 1);
//driver.findElement(By.id("bilingstate")).sendKeys(bilingstate);
//String billingcity = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 3, 2);
//driver.findElement(By.id("billingcity")).sendKeys(billingcity);
//String billingpincode = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 3, 3);
//driver.findElement(By.id("billingpincode")).sendKeys(billingpincode);
//String shippingaddress = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 5, 0);
//driver.findElement(By.name("shippingaddress")).sendKeys(shippingaddress);
//String shippingstate = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 5, 1);
//driver.findElement(By.id("shippingstate")).sendKeys(shippingstate);
//String shippingcity = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 5, 2);
//driver.findElement(By.id("shippingcity")).sendKeys(shippingcity);
//String shippingpincode = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase3", 5, 3);
//driver.findElement(By.id("shippingpincode")).sendKeys(shippingpincode);
//driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
//driver.findElement(By.xpath("//input[@type='submit']")).click();
//String parentWindow = driver.getWindowHandle();
//String url2 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");
//driver.get(url2);
//String username2 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//driver.findElement(By.id("inputEmail")).sendKeys(username2);
//String password2= fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");
//driver.findElement(By.id("inputPassword")).sendKeys(password2);
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath(
//		"//a[normalize-space(text()='Order Management')]/following-sibling::ul[@class='collapse unstyled']/preceding-sibling::a"))
//		.click();
//driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();
//WebElement w = driver.findElement(By.xpath("//select"));
//Select sy = new Select(w);
//sy.selectByVisibleText("100");
//driver.findElement(By.xpath("//table//tbody/tr[last()]/td[last()]/a")).click();
//webDriverUtility.switchWindowBasedOnUrlContain(driver, "updateorder.php");
//String orderId = driver.findElement(By.xpath("//tbody//tr[2]//td[@class='fontkink']")).getText();
//WebElement drp = driver.findElement(By.xpath("//select[@required='required']"));
//Select sx = new Select(drp);
//sx.selectByVisibleText("Delivered");
//driver.findElement(By.name("remark")).sendKeys("happily deleverd");
//driver.findElement(By.name("submit2")).click();
//driver.switchTo().alert().accept();
//System.out.println(orderId);
//webDriverUtility.closeopenedBrowser(driver);
//driver.switchTo().window(parentWindow);
//String url3 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//driver.get(url3);	
//driver.findElement(By.xpath("//span[text()='Track Order']")).click();
//driver.findElement(By.id("exampleOrderId1")).sendKeys(orderId);
//driver.findElement(By.id("exampleBillingEmail1")).sendKeys(email);
//driver.findElement(By.xpath("//button[text()='Track']")).click();
//String pass = driver.getCurrentUrl();
//String passedurl = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passedurl");
//if(pass.equals(passedurl)) {
//	System.out.println("Testcase is pass");
//}
//else {
//	System.out.println("Testcase is fail");
//}


