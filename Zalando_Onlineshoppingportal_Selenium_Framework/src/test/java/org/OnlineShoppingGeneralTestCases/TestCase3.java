package org.OnlineShoppingGeneralTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		Sheet sheet = wb.getSheet("TestCase3");
		String productname = sheet.getRow(1).getCell(0).getStringCellValue();
		String billingaddress = sheet.getRow(3).getCell(0).getStringCellValue();
		String bilingstate = sheet.getRow(3).getCell(1).getStringCellValue();
		String billingcity = sheet.getRow(3).getCell(2).getStringCellValue();
		Cell billingpncode = sheet.getRow(3).getCell(3);
		String billingpincode = df.formatCellValue(billingpncode);
		String shippingaddress = sheet.getRow(5).getCell(0).getStringCellValue();
		String shippingstate = sheet.getRow(5).getCell(1).getStringCellValue();
		String shippingcity = sheet.getRow(5).getCell(2).getStringCellValue();
		Cell shippingpncode = sheet.getRow(5).getCell(3);
		String shippingpincode = df.formatCellValue(shippingpncode);
		String email = sheet.getRow(7).getCell(0).getStringCellValue();	
		Cell passwrd = sheet.getRow(7).getCell(1);
		String password = df.formatCellValue(passwrd);
		String url = sheet.getRow(7).getCell(2).getStringCellValue();
		String urlAdmin = sheet.getRow(1).getCell(1).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.get(url);
	    driver.findElement(By.xpath("//a[text()='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']/following-sibling::button")).click();
		String productPrice = driver.findElement(By.xpath("//a[text()='"+productname+"']/parent::h3/following-sibling::div/span")).getText();
		System.out.println(productPrice);
	    sheet.createRow(8).createCell(0).setCellValue(productPrice);
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData1.xlsx");
	    wb.write(fos);
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		driver.findElement(By.xpath("//a[text()=' ADD TO CART']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.name("billingaddress")).sendKeys(billingaddress);
		driver.findElement(By.id("bilingstate")).sendKeys(bilingstate);
		driver.findElement(By.id("billingcity")).sendKeys(billingcity);
		driver.findElement(By.id("billingpincode")).sendKeys(billingpincode); 
		driver.findElement(By.name("shippingaddress")).sendKeys(shippingaddress);
		driver.findElement(By.id("shippingstate")).sendKeys(shippingstate);
		driver.findElement(By.id("shippingcity")).sendKeys(shippingcity);
		driver.findElement(By.id("shippingpincode")).sendKeys(shippingpincode);
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String parentWindow = driver.getWindowHandle();
		driver.get(urlAdmin);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[normalize-space(text()='Order Management')]/following-sibling::ul[@class='collapse unstyled']/preceding-sibling::a")).click();
		driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();
		driver.findElement(By.xpath("//table//tbody/tr[last()]/td[last()]/a")).click();
		Set<String> child = driver.getWindowHandles();
		for(String b:child) {
			driver.switchTo().window(b);
		}
	    WebElement drp = driver.findElement(By.xpath("//select[@class='fontkink']"));
		Select sx= new Select(drp);
		sx.selectByVisibleText("Delivered");
		driver.findElement(By.name("remark")).sendKeys("happily deleverd");
		driver.findElement(By.name("submit2")).click();
		driver.switchTo().alert().accept();
		String orderId = driver.findElement(By.xpath("//tbody//tr[2]//td[@class='fontkink']")).getText();
		System.out.println(orderId);
		sheet.createRow(9).createCell(0).setCellValue(orderId);
		wb.write(fos);
		wb.close();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.get(url);
	    driver.findElement(By.xpath("//a[text()='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Track Order']")).click();
		driver.findElement(By.id("exampleOrderId1")).sendKeys(orderId);
		driver.findElement(By.id("exampleBillingEmail1")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Track']")).click();
	}
}
//FileUtility fileUtility = new FileUtility();
//JavaUtility javaUtility = new JavaUtility();
//WebDriverUtility webDriverUtility = new WebDriverUtility();
//ExcelUtlity excelUtlity = new ExcelUtlity();
//String browser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "browser");
//String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//String timeouts = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "timeouts");
//long longTimeout = (long) javaUtility.convertStringIntoDataType(timeouts, DataType.LONG);
//WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, longTimeout, url1);
//String email = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "email");
//String passworduser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passworduser");
//LoginPage loginPage = new LoginPage(driver);
//loginPage.userLoginButton(email, passworduser);
//String productname = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"productname");
//UserPage userPage = new UserPage(driver);

//String billingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"billingaddress");
//String bilingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"bilingstate");
//String billingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"billingcity");
//String billingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"billingpincode");
//String shippingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"shippingaddress");
//String shippingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"shippingstate");
//String shippingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"shippingcity");
//String shippingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3",
//		"shippingpincode");
//CheckOutPage checkOutPage = new CheckOutPage(driver);

//String url = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");

//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//String password = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");


//String passedurl = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "passedurl");
//if(pass.equals(passedurl)) {
//	System.out.println("Testcase is pass");
//}
//else {
//	System.out.println("Testcase is fail");
//}
//String productname = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "productname");
//driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(productname);
//driver.findElement(By.xpath("//input[@placeholder='Search here...']/following-sibling::button")).click();
//String productPrice = driver
//		.findElement(By.xpath("//a[text()='" + productname + "']/parent::h3/following-sibling::div/span"))
//		.getText();
//System.out.println(productPrice);
//driver.findElement(By.xpath("//a[text()='" + productname + "']")).click();
//driver.findElement(By.xpath("//a[text()=' ADD TO CART']")).click();
//driver.switchTo().alert().accept();
//String billingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "billingaddress");
//driver.findElement(By.name("billingaddress")).sendKeys(billingaddress);
//String bilingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "bilingstate");
//driver.findElement(By.id("bilingstate")).sendKeys(bilingstate);
//String billingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3","billingcity");
//driver.findElement(By.id("billingcity")).sendKeys(billingcity);
//String billingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3","billingpincode");
//driver.findElement(By.id("billingpincode")).sendKeys(billingpincode);
//String shippingaddress = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3","shippingaddress");
//driver.findElement(By.name("shippingaddress")).sendKeys(shippingaddress);
//String shippingstate = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "shippingstate");
//driver.findElement(By.id("shippingstate")).sendKeys(shippingstate);
//String shippingcity = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "shippingcity");
//driver.findElement(By.id("shippingcity")).sendKeys(shippingcity);
//String shippingpincode = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase3", "shippingpincode");
//driver.findElement(By.id("shippingpincode")).sendKeys(shippingpincode);
//driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
//driver.findElement(By.xpath("//input[@type='submit']")).click();
//String parentWindow = driver.getWindowHandle();
//String url = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url");
//driver.get(url);
//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//Thread.sleep(3000);
//driver.findElement(By.id("inputEmail")).sendKeys(username);
//String password = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");
//driver.findElement(By.id("inputPassword")).sendKeys(password);
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
//String url2 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//driver.get(url2);	
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
