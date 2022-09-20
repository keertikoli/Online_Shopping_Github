 package org.Zalando_OnlineShopping.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of all common actions on excel
 * 
 * @author rishikesh
 *
 */
public final class ExcelUtlity {
	private Workbook workbook;

	/**
	 * This Method is used to open the excel
	 * 
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void openExcel(String excelPath) throws EncryptedDocumentException, IOException {
		FileInputStream fisexcel = new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fisexcel);
	}

	/**
	 * This class is to fetch the data from excel sheet
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String excelPath, String sheetName, int rowNumber, int cellNumber) {

		{
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(excelPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Workbook wb = null;
			try {
				wb = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Sheet sheet = wb.getSheet(sheetName);
			String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
			return data;
		}
	}

	/**
	 * This method is used to create the data into excel
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param text
	 */
	public void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String text) {
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(text);
	}

	/**
	 * This method is used to save the data into excel
	 * 
	 * @param outputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveDataIntoExcel(String outputPath) throws FileNotFoundException, IOException {
		workbook.write(new FileOutputStream(outputPath));
	}

	FileInputStream fis;

	public String getDataFromExcelBasedonKey(String excelPath, String sheetName, String key) {
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		String value = null;
		for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
			DataFormatter df = new DataFormatter();
			String requiredKey = df.formatCellValue(sheet.getRow(0).getCell(i));
			if (requiredKey.equalsIgnoreCase(key)) {
				value = df.formatCellValue(sheet.getRow(1).getCell(i));
				break;
			}
		}
		return value;
	}

	/**
	 * This method is to get multiple Data from the ExcelSheet
	 * 
	 * @param sheetName
	 * @return
	 */
	public String[][] getMultipleData(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String[][] arr = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				arr[i - 1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}

	/**
	 * This method is used to close the workbook
	 * 
	 * @throws IOException
	 */
	public void closeWorkBook() throws IOException {
		workbook.close();
	}
}
