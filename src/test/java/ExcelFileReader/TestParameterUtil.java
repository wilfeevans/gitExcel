package ExcelFileReader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelUtlity.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParameterUtil
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
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="getData")
	public void doLogin(String username, String password)
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		//driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}

	
	
	
	
}
