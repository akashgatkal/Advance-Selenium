package com.crm.BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DWSBase {
	public static WebDriver driver=null;
	public static String browser="chrome";
	@BeforeClass
	public  void preCondition() throws InterruptedException
	{
		
			driver=new ChromeDriver();			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");	
	}
	@BeforeMethod
	public  void login() throws InterruptedException
	{
		driver.findElement(By.className("ico-login")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("admin01");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='RememberMe']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
	}
	
	@AfterMethod
	public  void logout()
	{
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		
	}
	@AfterClass
	public  void postCondition()
	{
		driver.quit();
	}
}
