package org.Zalando_OnlineShopping.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is to retry the failed Test Cases
 * 
 * @author rishikesh
 *
 */
public class ImplimatationOfIRetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int maxRetries = 4;

	@Override
	public boolean retry(ITestResult result) {
		if (count < maxRetries) {
			count++;
			return true;
		}
		return false;
	}
}
