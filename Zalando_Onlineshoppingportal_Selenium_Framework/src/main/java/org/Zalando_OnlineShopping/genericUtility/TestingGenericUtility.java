package org.Zalando_OnlineShopping.genericUtility;

/**
 * This class consist of Random number object for the Dublicates
 * 
 * @author rishikesh
 *
 */
public final class TestingGenericUtility {
	/**
	 * This method is to generate the Random number for the Dublicates
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int randomNumber = new JavaUtility().getRandomNumber(1000);
		String data = new ExcelUtlity().getDataFromExcel(IconstantUtility.EXCEL_PATH, "TestCase2", 1, 1);
		System.out.println(data);

		String browser = new FileUtility().getDataFromPropertyFile(IconstantUtility.PROPERTY_PATH, "browser");
		System.out.println(browser);

	}
}
