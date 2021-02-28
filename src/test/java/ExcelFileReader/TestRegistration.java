package ExcelFileReader;

import java.util.Date;

import org.testng.annotations.Test;

import ExcelUtlity.TestUtil;

public class TestRegistration
{
	@Test(dataProviderClass=TestUtil.class, dataProvider="getData")
	public static void doRegistration(String fname, String lname)
	{
		Date d=new Date();
		String date= d.toString();
	
		System.out.println(fname +"________"+ lname + date);
		
	}
	
}
