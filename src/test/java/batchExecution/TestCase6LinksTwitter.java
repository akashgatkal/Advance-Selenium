package batchExecution;

import org.testng.annotations.Test;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase6LinksTwitter extends DWSBase {
	@Test
	public  void main() throws InterruptedException {
		
		
		
		String parent = driver.getWindowHandle();
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
			
			
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
			
			
		}else {
			System.out.println("Iam not in DWS page...!");
		}
		
		
	}
//	@Test
//	public void links() throws InterruptedException {
//		
//		String parent = driver.getWindowHandle();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//		if (driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/")) {
//
//			Actions act = new Actions(driver);
//
//			act.keyDown(Keys.PAGE_DOWN).perform();
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='column follow-us']/ul/li/a")));
//			List<WebElement> social = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
//
//			String rss = "https://demowebshop.tricentis.com/news/rss/1";
//
//			for (WebElement web : social) {
//				String rss2 = driver.getCurrentUrl();
//
//				if (rss.equals(rss2)) {
//					// web.click();
//					driver.navigate().back();
//					// Thread.sleep(2000);
//				}
//
//				web.click();
//			}
//
//			Set<String> child = driver.getWindowHandles();
//
//			String fb = "https://www.facebook.com/nopCommerce";
//			String twitter = "https://x.com/nopCommerce";
//			for (String web2 : child) {
//
//				driver.switchTo().window(web2);
//
//				String current = driver.getCurrentUrl();
//
//				if (current.equals(fb)) {
//					driver.findElement(By.xpath("//span[text()='Create new account']")).click();
//					Thread.sleep(2000);
////					driver.switchTo().frame(0);
//					System.out.println("facebook Entered");
//					Thread.sleep(2000);
//
//				}
//			}
//			driver.switchTo().window(parent);
//			for (String link : child) {
//
//				driver.switchTo().window(link);
//
//				String current = driver.getCurrentUrl();
//
//				if (current.equals(twitter)) {
//					driver.findElement(By.xpath("//button[@role='button']")).click();
//					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
//					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create account']")));
//
//					driver.findElement(By.xpath("//span[text()='Create account']")).click();
//					Thread.sleep(2000);
////					driver.switchTo().frame(0);
//					System.out.println("twiiter Entered");
//					Thread.sleep(2000);
//
//				}
//			}
//			Thread.sleep(1000);
//			driver.switchTo().window(parent);
//			Thread.sleep(1000);
//			
//		} else {
//			System.out.print("I am Not in DWS page.");
//
//		}
//	}
}
