package org.Zalando_OnlineShopping.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
   public static ExtentTest stest;
   private ExtentTest test;
   ExtentReports reports;
	@Override //@BT
	public void onStart(ITestContext context) {
    ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
    spark.config().setDocumentTitle("Document title - Online Shopping");
    spark.config().setReportName("Report Name - Admin Module");
    spark.config().setTheme(Theme.DARK);
    
     reports = new ExtentReports();
    reports.attachReporter(spark);
    reports.setSystemInfo("Author", "Keerti");
    reports.setSystemInfo("OS", "Win 10");
    reports.setSystemInfo("Browser", "Chrome");
	}

	@Override //@BM
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;	
	}

	@Override //@AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"pass");		
	}

	@Override //@AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName());
		System.out.println(Thread.currentThread().getId());
		try {
			new WebDriverUtility().screenShot(BaseClass.sdriver,BaseClass.sjavaUtility, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override //@AM
	public void onTestSkipped(ITestResult result) {
		test.skip("Test1 skip");
	}

	@Override //@AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {	
	}

	@Override  //@AT
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
