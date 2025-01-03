package TestCases;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase4 extends BaseClass{
	@Test
	public  void main() throws InterruptedException {
		
		preCondition("chrome");
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
			login();
			
			driver.findElement(By.xpath("//ul[@class='top-menu']//li/a[contains(text(),'Digital downloads')]")).click();
			
//			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement products_orderby = driver.findElement(By.id("products-orderby"));
			
			Select sel = new Select(products_orderby);
			
			List<WebElement> options = sel.getOptions();
			
			for (WebElement web : options) {
				
				
				try {
					web.click();
				} catch (Exception e) {
					driver.navigate().back();
				}
			}
		
			WebElement products_pagesize = driver.findElement(By.id("products-pagesize"));
			
			Select sel2 = new Select(products_pagesize);
			
			List<WebElement> options2 = sel2.getOptions();
			
			for (WebElement web: options2) {
				
				try {
					web.click();
				} catch (Exception e) {
					driver.navigate().back();
				}
				
			}
			
			WebElement products_viewmode = driver.findElement(By.id("products-viewmode"));
			
			Select sel3 = new Select(products_viewmode);
			
			List<WebElement> options3 = sel3.getOptions();
			
			for (WebElement web : options3) {
				
				try {
					web.click();
				} catch (Exception e) {
					driver.navigate().back();
				}
			}
			
			logout();
		}
		
		else {
			System.out.println("Iam not in DWS page...!");
		}
		
		
		postCondition();
		
	}
}
