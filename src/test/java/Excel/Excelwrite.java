package Excel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelwrite {

	public static void main(String[] args) {
		
XSSFWorkbook   workbook = new XSSFWorkbook();
		
		XSSFSheet sheet= workbook.createSheet("First Sheet");
		
		XSSFRow row= sheet.createRow(0);
		
		XSSFCell  cell1= row.createCell(0);
		
		cell1.setCellValue("Way to automation");
		
		File  file= new File("E:\\Selenium_2020_May\\Selenium_Project\\Excel\\TestData.xlsx");
		
		
		FileOutputStream   fo=null;
		try {
			fo= new FileOutputStream(file);
			
		}
		catch (FileNotFoundException e) 
		{
		
			e.printStackTrace();
		}
		
		try {
			workbook.write(fo);
		} 
		
		catch (IOException e) 
		{
		
			e.printStackTrace();
		}
		
		
		
		    
	System.out.println("File Created");
		
		



	}

}
