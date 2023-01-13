package com.test.java.utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLSData {
	public static void main(String[] args) throws IOException {
		ReadXLSData readXLFile = new ReadXLSData();
		readXLFile.getData("login");
	}

	public String[][] getData(String excelSheetName) throws IOException {
		File xlsFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");

		FileInputStream fileIn = new FileInputStream(xlsFile);

		Workbook wb = WorkbookFactory.create(fileIn);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();

		System.out.println("No of Rows: " + totalRows + "\nNo of Columns: " + totalCols);

		String testData[][] = new String[totalRows][totalCols];

		DataFormatter dataFormat = new DataFormatter();
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = dataFormat.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}

}
