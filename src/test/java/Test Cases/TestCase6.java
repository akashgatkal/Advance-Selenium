package UtilityClass;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase6 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		preCondition("Chrome");
		
		String parent = driver.getWindowHandle();
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
			login();
			
			Actions act = new Actions(driver);
			
			act.keyDown(Keys.END);
			
			String rss = "https://demowebshop.tricentis.com/news/rss/1";
			
			List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer']/div/div[4]/ul/li/a"));
			
			for (WebElement web : links) {
				
				web.click();
				
				if (driver.getCurrentUrl().equals(rss)) {
					
					driver.navigate().back();
				}
			}
			
			Set<String> handles = driver.getWindowHandles();
			
			String fburl = "https://www.facebook.com/nopCommerce";
			
			String twitter = "https://twitter.com/";
			
			String yt = "https://www.youtube.com/user/nopCommerce";
			
			for (String string : handles) {
				
				driver.switchTo().window(string);
				
				if(driver.getCurrentUrl().equals(fburl))
				{
					System.out.println("FaceBook");
					driver.findElement(By.xpath("//span[contains(text(),'Create new account')]")).click();
				}
				else if (driver.getCurrentUrl().equals(twitter)) {
					System.out.println("twitter");
					driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
					
				}
				else if (driver.getCurrentUrl().equals(yt)) {
					
					System.out.println("Youtube");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					WebElement search = driver.findElement(By.xpath("//input[@name='search_query']"));
					
					search.click();
					
					search.sendKeys("India's got latent");
				}
			}
			
			driver.switchTo().window(parent);
			
			logout();
			
			postCondition();
		}else {
			System.out.println("Iam not in DWS page...!");
		}
		
		
	}
}
