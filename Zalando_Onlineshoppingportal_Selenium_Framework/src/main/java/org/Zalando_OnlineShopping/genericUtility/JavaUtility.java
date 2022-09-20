package org.Zalando_OnlineShopping.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists all java reusable actions
 * 
 * @author rishikesh
 *
 */
public final class JavaUtility {
	/**
	 * This method is used to generate the random number
	 * 
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}

	/**
	 * This method is used to convert the string into any DataTypes based on the
	 * Stratergy
	 * 
	 * @param data
	 * @param stratergy
	 * @return
	 */
	public Object convertStringIntoDataType(String data, DataType stratergy) {
		Object obj = null;
		if (stratergy.toString().equalsIgnoreCase("long")) {
			obj = Long.parseLong(data);
		} else if (stratergy.toString().equalsIgnoreCase("int")) {
			obj = Integer.parseInt(data);
		} else if (stratergy.toString().equalsIgnoreCase("double")) {
			obj = Double.parseDouble(data);
		}
		return obj;
	}

	/**
	 * This method is to set the Date Format for the screenshot file
	 * 
	 * @return
	 */
	public String currentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate = sdf.format(date);
		return actualDate;

	}
}
