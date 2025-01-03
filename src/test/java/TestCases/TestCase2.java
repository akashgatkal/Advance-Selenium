package TestCases;

import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase2 extends DWSBase{
	@Test
	public  void main() throws InterruptedException {
		
	
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		String expected_title = "Sign up for Facebook";
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
		
			
			String parent = driver.getWindowHandle();
			
			Actions act = new Actions(driver);
			
			act.keyDown(Keys.END).perform();
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			List<WebElement> social_links = driver.findElements(By.xpath("//div[@class='footer']/div/div[4]/ul/li/a"));
			
			String rss = "https://demowebshop.tricentis.com/news/rss/1";
			
			for (WebElement web : social_links) {
				Thread.sleep(1000);
				web.click();
				Thread.sleep(1000);
				
				String curr_url = driver.getCurrentUrl();
				
				if (curr_url.equals(rss)) {
					
					driver.navigate().back();
				}
			}
			
			Set<String> handles = driver.getWindowHandles();
			
			for (String string : handles) {
				
				driver.switchTo().window(string);
				
				String cur_url = driver.getCurrentUrl();
				
				String fb = "https://www.facebook.com/nopCommerce";
				
				if (cur_url.equals(fb)) {
					
					driver.findElement(By.xpath("//span[contains(text(),'Create new account')]")).click();
					
					Set<String> fbHandles = driver.getWindowHandles();
					
					System.out.println(fbHandles);
					
					for (String string2 : fbHandles) {
						
						driver.switchTo().window(string2);
						
						String cur_title = driver.getTitle();
						
						Thread.sleep(1000);
						
						if (expected_title.equals(cur_title)) {
							
							driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("akash");
							Thread.sleep(2000);
							
							driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("gatkal");
							
							WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
							
							Select sel1 = new Select(day);
							
							sel1.selectByValue("1");Thread.sleep(2000);
							WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
							
							Select sel2 = new Select(month);
							
							sel2.selectByVisibleText("Nov");
							WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
							
							Select sel3 = new Select(year);
							
							sel3.selectByValue("2002");Thread.sleep(2000);
							
							driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();Thread.sleep(2000);
							
							driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8660387175");
							Thread.sleep(2000);
							driver.findElement(By.id("password_step_input")).sendKeys("Ak@2000002");
							
						}
					}
					
				}
				
			}
			driver.switchTo().window(parent);
			
			
			
		}else {
			System.out.println("Iam not in DWS page...!");
		}
		
		
	}
}

