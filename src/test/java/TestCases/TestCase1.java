package TestCases;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase1 extends BaseClass{
	@Test
	public  void main() throws InterruptedException {
		
		preCondition("chrome");
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
			login();
			
			Actions act = new Actions(driver);
			
			act.keyDown(Keys.PAGE_DOWN).perform();
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[contains(text(),'$25 Virtual Gift Card')])[3]/../../div[3]/div[2]/input")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("Amit");
			driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("mightyamit@gmail.com");
			driver.findElement(By.id("giftcard_2_Message")).sendKeys("Enjoy...!");
			driver.findElement(By.className("qty-input")).clear();
			driver.findElement(By.className("qty-input")).sendKeys("2");
			driver.findElement(By.id("add-to-cart-button-2")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.className("cart-label")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			boolean cart = driver.findElement(By.xpath("//td[@class='product']/a[contains(text(),'$25 Virtual Gift Card')]")).isDisplayed();
			
			if (cart) {
				System.out.println("Item added to cart...");
			}else {
				System.out.println("Item not added to cart...");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logout();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			postCondition();
		}
		else {
			System.out.println("Iam not in DWS page...!");
		}
	}
}
