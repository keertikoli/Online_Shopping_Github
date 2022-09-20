package org.zalando.PracticeTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableFormatOrganizationApp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expOrgName = "Test Yentra";
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> organizationList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[@title='Organizations']"));
		for(WebElement org:organizationList) {
			String orgName = org.getText();
			if(orgName.equals(expOrgName)) {
				driver.findElement(By.xpath("//a[text()='Test Yentra']/parent::td/preceding-sibling::td/input")).click();
				break;
			}
		}
         driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
         driver.switchTo().alert().accept();
	}

}
