package org.Zalando_OnlineShopping.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the common actions on browser
 * 
 * @author rishikesh
 *
 */
public final class WebDriverUtility {
	private static final WebDriver TakeScreenShot = null;

	/**
	 * this method is for launching the browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchingBrowser(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please enter valid Browser key");
			break;
		}
		return driver;
	}

	/**
	 * This method is for maximizing the browser
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is for browser to wait until the page load
	 * 
	 * @param driver
	 * @param longTimeout
	 */

	public void implicitWait(WebDriver driver, Long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * This method is for getting the url
	 * 
	 * @param driver
	 * @param url
	 */
	public void getUrl(WebDriver driver, String url1) {
		driver.get(url1);
	}

	/**
	 * This method is for launch browser maximize,implicit wait until page load and
	 * navigate to application
	 * 
	 * @param browser
	 * @param longTimeout
	 * @return
	 */
	public WebDriver openBrowserWithApplication(String browser, long longTimeout, String url1) {
		WebDriver driver = launchingBrowser(browser);
		maximizeBrowser(driver);
		implicitWait(driver, longTimeout);
		getUrl(driver, url1);
		return driver;
	}

	/**
	 * this method is used to close the browser
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method is to close the opened browser
	 * 
	 * @param driver
	 */

	public void closeopenedBrowser(WebDriver driver) {
		driver.close();
	}

	/**
	 * This method is to switch the window which contains URL based on partial Text
	 * 
	 * @param driver
	 * @param url
	 */
	public void switchWindowBasedOnUrlContain(WebDriver driver, String url) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String wind : allWindow) {
			driver.switchTo().window(wind);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	/**
	 * This method is to switch the window based on another window
	 * 
	 * @param driver
	 * @return
	 */
	public String switchWindowBasedOnWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}

	/**
	 * This method is to handle the dropDown based on the visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void dropDown(WebElement element, String text) {
		new Select(element).selectByVisibleText(text); 
	}

	/**
	 * This method is to Handle the Alert Popup
	 * 
	 * @param driver
	 * @return
	 */
	public WebDriver acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		return driver;
	}

	/**
	 * This method is to convert the Dynamic Xpath into WebElement
	 * 
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}

	/**
	 * This method is to get the CurrentUrl
	 * 
	 * @param driver
	 * @return
	 */
	public String getcurrenrUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * This method is to get and enter the URL
	 * 
	 * @param driver
	 * @param url
	 */
	public void getUrlAction(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * This method is to verify the pages by applying assertion
	 * 
	 * @param driver
	 * @param expectedText
	 * @param addStatus
	 */
	public void verifyCurrentPage(WebDriver driver, String expectedText, String addStatus) {
		String pagesource = driver.getPageSource();
		Assert.assertTrue(pagesource.contains(expectedText));
		Reporter.log(addStatus, true);
	}

	/**
	 * This method is to take the screenshots
	 * 
	 * @param driver
	 * @param javaUtility
	 * @param className
	 * @return
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver, JavaUtility javaUtility, String className) throws IOException {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/" + className + "_" + currentTime + ".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}

	public String screenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}
}
