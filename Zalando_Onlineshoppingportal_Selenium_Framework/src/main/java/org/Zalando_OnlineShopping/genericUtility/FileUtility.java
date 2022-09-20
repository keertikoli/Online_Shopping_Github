package org.Zalando_OnlineShopping.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists reusable methods to handle property File
 * 
 * @author rishikesh
 *
 */
public final class FileUtility {
	/**
	 * This method is used to fetch the data from property file
	 * 
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	private Properties properties;

	public String getDataFromPropertyFile(String propertyFilePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(key).trim();
		return value;
	}

	/**
	 * This method is used to initialize the property file
	 * 
	 * @param propertyFilePath
	 * @throws IOException
	 */
	public void initializePropertyFile(String propertyFilePath) throws IOException {
		FileInputStream fis = new FileInputStream(propertyFilePath);
		properties = new Properties();
		properties.load(fis);
	}

}
