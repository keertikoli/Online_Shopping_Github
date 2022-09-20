package org.zalando.PracticeTestCases;

import java.io.IOException;

import org.Zalando_OnlineShopping.genericUtility.ExcelUtlity;
import org.Zalando_OnlineShopping.genericUtility.IconstantUtility;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPrct {
	@Test(dataProvider = "getData")
	
	public void testCase1(String city,String pincode) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("City is:"+city);
		System.out.println("pincode is:"+pincode);
		System.out.println();	
	}

	@DataProvider
    public Object[][] getData() throws EncryptedDocumentException, IOException{
 	   ExcelUtlity excelUtlity=new ExcelUtlity();
 	   excelUtlity.openExcel(IconstantUtility.EXCEL_PATH);
 	   String obj[][] = excelUtlity.getMultipleData("DataProvider");
 	   return obj;	   	   
    }

}
