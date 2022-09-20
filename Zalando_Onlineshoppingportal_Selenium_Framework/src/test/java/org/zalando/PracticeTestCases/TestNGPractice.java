package org.zalando.PracticeTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test
	public void step1Test2() {
		System.out.println("script2");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	@Test
	public void step1Test1() {
		System.out.println("script1");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

}
