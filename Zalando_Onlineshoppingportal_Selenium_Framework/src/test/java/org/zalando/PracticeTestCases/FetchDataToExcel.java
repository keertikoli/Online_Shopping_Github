package org.zalando.PracticeTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1updat.xlsx");
		//step2:open the excel workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3:get the control on sheet
		Sheet sheet = wb.getSheet("Sheet1");
		//step4:get the control on row for new row
		Row row = sheet.createRow(18);
	    //step4:get the control on row for existing row
		//Row row = sheet.getRow(2);
		//step5:create the cell
		Cell cell = row.createCell(4);
		//step6:update the status/set the cell
		cell.setCellValue("failed");
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData1.xlsx");
	    //step7:write the data into excel
	    wb.write(fos);
	    System.out.println("data updated successfully");
	    //step8:close the workbook
	    wb.close();
	}

}
