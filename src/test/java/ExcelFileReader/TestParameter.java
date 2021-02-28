package ExcelFileReader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtlity.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParameter 
{
	public static WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@Test(dataProvider= "getData")
	public void doLogin(String username, String password)
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		//driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		ExcelReader  excel= new ExcelReader("E:\\\\Selenium_2020_New_Maven\\\\ExcelReading\\\\src\\\\test\\\\resources\\\\ExcelPack\\\\testdata.xlsx");
		String sheetName="login";
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
