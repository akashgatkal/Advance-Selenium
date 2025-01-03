package Assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssertMethod {
	@Test
	public void main() throws InterruptedException 
	{
		String value=null;
		String exp_reg = "https://demowebshop.tricentis.com/registerv";
		String exp_url = "https://demowebshop.tricentis.com/";
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com");
		Thread.sleep(2000);
		String act_url=driver.getCurrentUrl();
		assertEquals(exp_url,act_url,"I am Not in DWS page...");
		System.out.println("I am in DWS Page...");
		driver.findElement(By.className("ico-register")).click();
		String act_reg = driver.getCurrentUrl();
		assertNotEquals(exp_url,act_reg,"I am not in reg page");
		System.out.println("I am in reg Page...");
		WebElement reg_title = driver.findElement(By.xpath("//div[@class='page-title']"));
		assertTrue(reg_title.isDisplayed(),"Reg title is not displayed...");
		System.out.println("Reg title is displayed...");
//		assertFalse(reg_title.isDisplayed(),"Reg title is not displayed by assetFalse...");
//		System.out.println("Reg title is displayed by assetFalse...");
		
		assertNull(value,"Value do not Contains Null value...");
		System.out.println("Value Contains Null value...");
		
		
		
				
	
		
		
	}
}
