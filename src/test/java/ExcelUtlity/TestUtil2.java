package ExcelUtlity;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestUtil2 
{
	@DataProvider(parallel=true)
	public Object[][] getData(Method m)
	{
		ExcelReader  excel= new ExcelReader("E:\\Selenium_2020_New_Maven\\ExcelReading\\src\\test\\resources\\ExcelPack\\testdata.xlsx");
		//String sheetName="login";
		String sheetName=m.getName();
		int rowcount= excel.getRowCount(sheetName);
		int columncount= excel.getColumnCount(sheetName);
		Object[][] data= new Object[rowcount-1][columncount];
		
		for(int row=2; row<=rowcount ; row++ )
		{
			for(int column=0; column<columncount; column++ )
			{
		
				data[row-2][column] = excel.getCellData(sheetName, column, row);
			}
		}
		
		return data;
		
	}
	

	
	
}
