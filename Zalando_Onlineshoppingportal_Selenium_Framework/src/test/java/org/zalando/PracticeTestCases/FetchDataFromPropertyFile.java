package org.zalando.PracticeTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// step1:convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");

		// step2:create the object for properties
		Properties property = new Properties();
		
		// step3:load the keys
		property.load(fis);
		
		// step4:fetch the data
		String url = property.getProperty("url").trim();
		String browser = property.getProperty("username").trim();

		System.out.println(url);
		System.out.println(browser);

	}

}
