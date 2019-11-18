package com.automation.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelDataHelper{
	@DataProvider(name="getTestData")
	public static String[][] getTestData() throws Exception{
		String[][] data = null;
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("TD1.xlsx")));
		Sheet sheet= workbook.getSheet("Sheet1");
		data= new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		for(int rowIndex=0;rowIndex<sheet.getPhysicalNumberOfRows();rowIndex++) {
			for(int colIndex=0;colIndex<sheet.getRow(rowIndex).getPhysicalNumberOfCells();colIndex++) {
				data[rowIndex][colIndex]=sheet.getRow(rowIndex).getCell(colIndex).toString();
			}
		}
		return data;
	}
}
