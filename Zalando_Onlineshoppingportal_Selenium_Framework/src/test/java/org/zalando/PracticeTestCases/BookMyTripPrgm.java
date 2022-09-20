package org.zalando.PracticeTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyTripPrgm {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MakeMyTrip");
		String fromCityCode = sheet.getRow(1).getCell(0).getStringCellValue();
	    String toCityCode = sheet.getRow(1).getCell(1).getStringCellValue();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			   driver.findElement(By.xpath("//span[text()='From']")).click();
			   driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromCityCode);
			   driver.findElement(By.xpath("//div[text()='"+fromCityCode+"']")).click();
			   
			   
			   driver.findElement(By.xpath("//span[text()='To']")).click();
			   driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toCityCode);
			   driver.findElement(By.xpath("//div[text()='"+toCityCode+"']")).click();
			   
			   driver.findElement(By.xpath("//a[text()='Search']")).click();
			   

	}

}
