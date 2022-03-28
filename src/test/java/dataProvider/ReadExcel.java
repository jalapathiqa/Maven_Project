package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {

	@DataProvider
	public String [][] getData() throws IOException {

		File excelFile = new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Workspace\\Maven_Project\\TestData\\Data.xlsx");

		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
//		System.out.println(sheet.getLastRowNum());

		String [][] data = new String [noOfRows-1][noOfColumns];
		for (int i = 0; i < noOfRows-1; i++) {
			
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter formatter = new DataFormatter();
//			System.out.println(formatter.formatCellValue(sheet.getRow(i).getCell(j)));
			
			data[i][j] = formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
				
//				sheet.getRow(i).getCell(j).getStringCellValue();				
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		workbook.close();
		fis.close();
		
		Arrays.toString(data);
		
		for (String[] dataArr : data) {
//			System.out.println(Arrays.toString(dataArr));
			
		}
		return data;

	}
}
