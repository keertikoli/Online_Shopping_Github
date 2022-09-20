package org.zalando.PracticeTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultiDataByTwoDimensionalArray {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1updat.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		DataFormatter df = new DataFormatter();
		//if we have any data beyond the matrix in the particular line eg:6th line reffer ur pics 
		
		
		String[][] arr = new String[sheet.getLastRowNum() + 1][sheet.getRow(6).getLastCellNum()];
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(6).getLastCellNum(); j++) {
				arr[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(6).getLastCellNum(); j++) {
				System.out.println(arr[i][j]);
			}
		}
	}
}
