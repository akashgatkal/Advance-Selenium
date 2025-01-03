package TestCases;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class demoTestCAse extends BaseClass {
	@Test
	public  void main() {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demowebshop.tricentis.com/");
		
		String expectedUrl = "https://demowebshop.tricentis.com/";
		
		if(expectedUrl.equals(driver.getCurrentUrl()))
		{
			System.out.println("You are in targeted page");
			
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("patilgaju4321@gmail.com");
			
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Gaju4321");
			
			driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
			
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			Actions act = new Actions(driver);
			
			act.keyDown(Keys.END).perform();
			
			List<WebElement> socialLinks = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
			
			for(WebElement web: socialLinks)
			{
				web.click();
				String actualRSSUrl = "https://demowebshop.tricentis.com/news/rss/1";
				if(actualRSSUrl.equals(driver.getCurrentUrl()))
				{
					driver.navigate().back();
				}
			}
			
			String handel = driver.getWindowHandle();
			
			Set<String> handels = driver.getWindowHandles();
			
			for(String str : handels)
			{
				driver.switchTo().window(str);
				
				driver.getCurrentUrl();
				
				String actualFBUrl = "https://www.facebook.com/nopCommerce";
				
				if(actualFBUrl.equals(driver.getCurrentUrl())) 
				{
					System.out.println("Wel Come To FB");
					
					driver.findElement(By.xpath("//span[text()='Create new account']")).click();
					
					Set<String> fbHandels = driver.getWindowHandles();
					
					System.out.println(fbHandels);
					
					for(String str2:fbHandels)
					{
						driver.switchTo().window(str2);
						
						String signUp = "https://www.facebook.com/reg/?entry_point=logged_out_dialog&next=%2FnopCommerce";
						
						if(signUp.equals(driver.getCurrentUrl()))
						{
							
							driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Gaju");
							
							driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Patil");
							
							WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
							
							Select s1 = new Select(day);
							
							s1.selectByIndex(24);
							
							WebElement mon = driver.findElement(By.xpath("//select[@id='month']"));
							
							Select s2 = new Select(mon);
							
							s2.selectByIndex(8);
							
							WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
							
							Select s3 = new Select(year);
							
							s3.selectByValue("2002");
							
							driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();
							
							driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("patilgaju4321@gmail.com");
							
							driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Gaju4321");
						}
					}
					
				}
			}
			
			driver.switchTo().window(handel);
			
			driver.findElement(By.xpath("//a[text()='Log out']")).click();
			
			driver.quit();
		}
		else
		{
			System.out.println("Invalid page");
		}
		
//		driver.close();
	}

}