package org.OnlineShoppingGeneralTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
			driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
				if(text.equals("Clothing")) {
					System.out.println("Category is created");
				}
					else {
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
	}
	}//		String uniqueClothName = "Clothing"+random;
//String descriptionArea = "All Brands of cloths are availaible";

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

//WebElement select = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//webDriverUtility.dropDown(select, "100");
//WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='category']"));
//webDriverUtility.dropDown(dropdown2, uniqueClothName);
//WebElement select2 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//webDriverUtility.dropDown(select2, "100");
//WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='category']"));
//webDriverUtility.dropDown(dropdown3, uniqueClothName);
//WebElement dropdown4 = driver.findElement(By.id("subcategory"));
//webDriverUtility.dropDown(dropdown4, "Tshirts");
//WebElement dropdown5 = driver.findElement(By.xpath("//select[@name='productAvailability']"));
//webDriverUtility.dropDown(dropdown5, "In Stock");
//String username = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "username");
//driver.findElement(By.id("inputEmail")).sendKeys(username);
//String password = fileUtility.getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "password");
//driver.findElement(By.id("inputPassword")).sendKeys(password);
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
//int random = javaUtility.getRandomNumber(100);
//String uniqueClothName = "Clothing"+" "+random;
//driver.findElement(By.name("category")).sendKeys(uniqueClothName);
//String descriptionArea = "All Brands of cloths are availaible";
//driver.findElement(By.name("description")).sendKeys("descriptionArea");
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
//webDriverUtility.dropDown(dropdown2, uniqueClothName);
//driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Tshirts");
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']")).click();
//WebElement select2 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//webDriverUtility.dropDown(select2, "100");
//String text2 = driver.findElement(By.xpath("//table//tbody/tr[last()]/td[2]")).getText();
//System.out.println(text2);
//if (text2.equals("uniqueClothName)) {
//	System.out.println("SubCategory is created");
//} else {
//	System.out.println("SubCategory is not created");
//}
//driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
//WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='category']"));
//webDriverUtility.dropDown(dropdown3, "uniqueClothName);
//WebElement dropdown4 = driver.findElement(By.id("subcategory"));
//webDriverUtility.dropDown(dropdown4, "Tshirts");
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


