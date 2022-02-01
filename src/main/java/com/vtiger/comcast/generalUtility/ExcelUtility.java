package com.vtiger.comcast.generalUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author puneeth
 *
 */
public class ExcelUtility {
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis  = new FileInputStream("./common.properties/pom test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable  {
		FileInputStream fis  = new FileInputStream("./common.properties/pom test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable  {
		FileInputStream fis  = new FileInputStream("./common.properties/pom test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./common.properties/pom test.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}