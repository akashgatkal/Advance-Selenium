package com.crm.AdvancA9Basic;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelperMethods {
	@Test(priority =0,invocationCount=2)
	public void Rcb()
	{
		ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.royalchallengers.com/");
	driver.close();
	}

	@Test(priority =1)
	public void mi()
	{
		ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.mumbaiindians.com/");
	driver.close();
	}

	@Test(priority =2)
	public void DWS()
	{
		ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.demowebshop.tricentis.com/");
	driver.close();
	}
}
