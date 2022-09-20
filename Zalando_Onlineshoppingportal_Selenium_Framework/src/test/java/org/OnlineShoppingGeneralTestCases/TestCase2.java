package org.OnlineShoppingGeneralTestCases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) throws Throwable {
	
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		Sheet sheet = wb.getSheet("TestCase2");
		 Random random = new Random();
		 int randomNumber = random.nextInt(1000);
		String fullname = sheet.getRow(1).getCell(0).getStringCellValue()+randomNumber;
		String email = sheet.getRow(1).getCell(1).getStringCellValue()+randomNumber;
		Cell contanctNo = sheet.getRow(1).getCell(2);
		String contact = df.formatCellValue(contanctNo);
		Cell passwrd = sheet.getRow(1).getCell(3);
		String password = df.formatCellValue(passwrd)+randomNumber;
		String url = sheet.getRow(1).getCell(4).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.get(url);
	    driver.findElement(By.xpath("//a[text()='Login']")).click();
	    driver.findElement(By.id("fullname")).sendKeys(fullname);
	    driver.findElement(By.id("email")).sendKeys(email);
	    driver.findElement(By.id("contactno")).sendKeys(contact);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmpassword")).sendKeys(password);
	    driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	    driver.switchTo().alert().accept();
	    Thread.sleep(5000);
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}

//String emailID = email + random + "@gmail.com";
//LoginPage loginpage = new  LoginPage(driver);
// FileUtility fileUtility = new FileUtility();
//JavaUtility javaUtility = new JavaUtility();
//WebDriverUtility webDriverUtility = new WebDriverUtility();
//ExcelUtlity excelUtlity = new ExcelUtlity();
//int random = javaUtility.getRandomNumber(1000);
//String browser = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "browser");
//String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//String timeouts = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "timeouts");
//long longTimeout = (long) javaUtility.convertStringIntoDataType(timeouts, DataType.LONG);
//WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, longTimeout, url1);
//FileUtility fileUtility = new FileUtility();
//String url1 = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "url1");
//String fullname = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "fullname");
//String email = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2","email");
//String contact = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "contact");
//String password = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "password");
//String confirmpassword = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2", "confirmpassword");
//String passworduser = excelUtlity.getDataFromExcelBasedonKey(IconstantUtility.EXCEL_PATH, "TestCase2","passworduser");
//String passedurlNew = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "paasedurl2");
//if (pass.equals(passedurlNew)) {
//System.out.println("Testcase is pass");
//} else {
//System.out.println("Testcase is fail");
//}
//String fullname = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 0);
//driver.findElement(By.id("fullname")).sendKeys(fullname);
//String email = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 1);
//String emailID = email + random + "@gmail.com";
//driver.findElement(By.id("email")).sendKeys(emailID);
//String contact = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 2);
//driver.findElement(By.id("contactno")).sendKeys(contact);
//String password = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 3);
//driver.findElement(By.id("password")).sendKeys(password);
//String confirmpassword = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 5);
//driver.findElement(By.id("confirmpassword")).sendKeys(confirmpassword);
//driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
//driver.switchTo().alert().accept();
//driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailID);
//String passworduser = excelUtlity.getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 5);
//driver.findElement(By.id("exampleInputPassword1")).sendKeys(passworduser);
//driver.findElement(By.xpath("//button[text()='Login']")).click();
//driver.findElement(By.xpath("//a[text()='Logout']")).click();

