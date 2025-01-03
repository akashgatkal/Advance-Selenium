package DataProviderAnnotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFunction 
{
	@DataProvider(name="login")
	public Object[][] provider() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "admin01@gmail.com";
		obj[0][1] = "admin01";
		obj[1][0] = "admin02@gmail.com";
		obj[1][1] = "admin02";
		return obj;
	}
	@Test(dataProvider="login")
	public void receiver(String username,String pass) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

}
