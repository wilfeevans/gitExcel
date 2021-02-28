package ExcelFileReader;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestXML 
{
	@Parameters({ "username", "password" })
	@Test
	public static void Login(String username, String password)
	{
		
		
		System.out.println(username +"________-" +password);
		
		
	}
	
	
	

}
