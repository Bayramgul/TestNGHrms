package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook book;
	public static Sheet sheet;
	private static void openExcel(String filePath) {
		try {//building path btw excel file 
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void loadSheet(String sheetName) {
		sheet=book.getSheet(sheetName);
	}
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	private static int colsCount(int row) {
		int cellNum=sheet.getRow(row).getLastCellNum();
		return cellNum;
	}
	private static String cellData (int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	//return a 2d Object array of data
	public static Object[][]excelIntoArray(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		int rows=rowCount();
		int cols=colsCount(0);
		Object [][]data=new Object[rows-1][cols];//[rowCount()-1] bcuz 1st row is header, we need the data below in the body
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
		data[i-1][j]=cellData(i,j);// we do i-1 bcuz arrays index start from 0, we store data into 2D array,we just need number 0
			}
		}
		return data;
	}
}
