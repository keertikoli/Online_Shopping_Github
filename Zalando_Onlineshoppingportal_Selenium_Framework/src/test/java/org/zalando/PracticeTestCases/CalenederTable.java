package org.zalando.PracticeTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenederTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		String requiredDate = "20";
		String requiredMonth = "January";
		String requiredYear = "2023";
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		 String[] str = actualMonthYear.split(" ");
		 String actualMonth = str[0];
		 String actualYear = str[1];
		 
		 while(!(actualMonth.equals(requiredMonth) && actualYear.equals(requiredYear))) {
			 driver.findElement(By.xpath("//span[text()='Next']")).click();
			 actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			  str = actualMonthYear.split(" ");
			 actualMonth = str[0];
			  actualYear = str[1];
		 }
		 driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click();	
	

	}

}
