package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	public static WebDriver driver = null;
	
	public static void preCondition(String browser) throws InterruptedException
	{
		String expected_url = "https://demowebshop.tricentis.com/";
		
		if (browser.equalsIgnoreCase("chrome")) {
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to(expected_url);
			Thread.sleep(2000);
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to(expected_url);
			Thread.sleep(2000);
		}
		else if (browser.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to(expected_url);
			Thread.sleep(2000);
		}
		else if (browser.equalsIgnoreCase("internetexplorer")) {
			
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to(expected_url);
			Thread.sleep(2000);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to(expected_url);
			Thread.sleep(2000);
		}
		else {
			System.out.println("Invlid input");
		}
	}
	
	public static void login() throws InterruptedException
	{	
		Thread.sleep(1000);
		driver.findElement(By.className("ico-login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin01@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin01");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"form-fields\"]/form/div[5]/input")).click();
		Thread.sleep(1000);
		
	}
	
	public static void logout() throws InterruptedException
	{	
		driver.findElement(By.className("ico-logout")).click();
		Thread.sleep(1000);
		
	}
	
	public static void postCondition() throws InterruptedException
	{
		
		driver.quit();
	}
}
