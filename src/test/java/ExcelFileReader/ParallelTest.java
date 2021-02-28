package ExcelFileReader;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest 
{

	@Parameters({ "browser", "url" })
	@Test
	public static void Login(String browser, String url)
	{
		Date  date=new Date();
		String d= date.toString();
		
		
		System.out.println(browser +"________-" +url + d);
		
		
	}
	
	
}
