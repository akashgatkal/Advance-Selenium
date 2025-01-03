package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertMethods 
{
	@Test
	public void main() throws InterruptedException
	{
		String exp_url = "https://demowebshop.tricentis.com";
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com");
		Thread.sleep(2000);
		String act_url=driver.getCurrentUrl();
		SoftAssert s=new SoftAssert();
		s.assertEquals(exp_url,act_url,"I am Not in DWS page...");
		// to print stat innreport we use Reporter.log("");
		Reporter.log("I am in DWS Page...",true);
		//System.out.println("I am in DWS Page...");
		driver.findElement(By.className("ico-register")).click();
		s.assertAll();
	}
}
