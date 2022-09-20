package org.zalando.PracticeTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingmethodChaining {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestData1updat.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		DataFormatter df = new DataFormatter();
		try {
			/*
			 * Sheet sheet = wb.getSheet("Sheet1"); String url =
			 * sheet.getRow(2).getCell(1).getStringCellValue(); String username =
			 * sheet.getRow(2).getCell(2).getStringCellValue(); String password =
			 * sheet.getRow(2).getCell(3).getStringCellValue(); String browser =
			 * sheet.getRow(1).getCell(5).getStringCellValue();
			 */

			Sheet sheet = wb.getSheet("Sheet2");
			String data = df.formatCellValue(sheet.getRow(0).getCell(0));
			// Sheet sheet = wb.getSheet("Sheet1");
			// String data = df.formatCellValue(sheet.getRow(1).getCell(2));
			System.out.println(data);
			/*
			 * System.out.println(url); System.out.println(username);
			 * System.out.println(password); System.out.println(browser);
			 */
		} finally {
			wb.close();
		}
	}
}
