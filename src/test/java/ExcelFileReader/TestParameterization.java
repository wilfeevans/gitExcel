package ExcelFileReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtlity.ExcelReader;

public class TestParameterization
{
	@Test(dataProvider="getData")
	public void doLogin(String username, String password)
	{
		
		System.out.println(username  +"_ _ _ _ _" + password );
		
	}
	
	 @DataProvider
	 public Object getData()
	 {  
		ExcelReader   excel= new ExcelReader("E:\\Selenium_2020_New_Maven\\ExcelReading\\src\\test\\resources\\ExcelPack\\testdata.xlsx");
		String sheetName= "login";
		int rowcount= excel.getRowCount(sheetName);
		int columncount= excel.getColumnCount(sheetName);
		
		System.out.println("Total row count:" + rowcount +"_____" +"Total column count" + columncount);		
		 
		String[][]  data= new String[rowcount-1][columncount];
		/*String[][]  data= new String[4][2];
		data[0][0]= "sampletest@gmil.com";
		data[0][1]= "password1";
			
		data[1][0]= "sampletest@gmil.com";
		data[1][1]= "password1";
		
		data[2][0]= "sampletest@gmil.com";
		data[2][1]= "password1";
		
		data[3][0]= "sampletest@gmil.com";
		data[3][1]= "password1";
		*/
		
		for(int rows=2; rows<=rowcount ; rows++)
		{
			for(int column=0; column<columncount ; column++)
			{
				data[rows-2][column]=excel.getCellData(sheetName, column,rows);
			}
		}
		
		
		
		
		
		
		return data;
		
	}
	
	
	
	
	
	

}
