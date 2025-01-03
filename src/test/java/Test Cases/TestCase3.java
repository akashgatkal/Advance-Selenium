package UtilityClass;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase3 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		preCondition("chrome");
		
		String parent = driver.getWindowHandle();
		
		String digital_title = "Demo Web Shop. Digital downloads";
		
		String expected_url = "https://demowebshop.tricentis.com/";
		
		String actual_url = driver.getCurrentUrl();
		
		if (expected_url.equals(actual_url)) {
			
			System.out.println("Iam in DWS page...!");
			
//			login();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement digital = driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]"));
			
			Actions act = new Actions(driver);
			
			act.keyDown(Keys.SHIFT).click(digital).perform();
			
			act.keyUp(Keys.SHIFT).perform();
			Thread.sleep(1000);
			
			Set<String> handles = driver.getWindowHandles();
			
			for (String string : handles) {
				
				driver.switchTo().window(string);
				
				if (driver.getTitle().equals(digital_title)) {
					
					List<WebElement> addToCart = driver.findElements(By.xpath("//div[@class='add-info']/div[2]/input"));
					
					for(WebElement web:addToCart)
					{
						web.click();
//						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						Thread.sleep(1000);
					}
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
					driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
					
					List<WebElement> price = driver.findElements(By.xpath("//span[@class='product-unit-price']"));
					
					int[] ar = new int[price.size()];
					
					int i = 0;
					
					for (WebElement web : price) {
						
//						System.out.println(web.getText());
						
						int val = (int)(Double.parseDouble(web.getText()));
						
						ar[i++] = val;
					}
					
//					System.out.println(Arrays.toString(ar));
					
					int max = max(ar);
					
//					System.out.println(max);
					
					int j = 1;
					for (WebElement web : price) {
						Thread.sleep(1000);
						try {
							if (max == (int)(Double.parseDouble(web.getText()))) {
//								System.out.println((int)(Double.parseDouble(web.getText())));
								Thread.sleep(1000);
								driver.findElement(By.xpath("(//input[@name='removefromcart'])["+j+"]")).click();
								Thread.sleep(1000);
								driver.findElement(By.xpath("//input[@name='updatecart']")).click();
							}
							j++;
						} catch (Exception e) {
							driver.navigate().back();
						}
					}	
					
				}
			}
			Thread.sleep(5000);
			driver.switchTo().window(parent);
			
			postCondition();
		}
		else {
			System.out.println("Iam not in DWS page...!");
		}
	}
	
	public static int max(int[] ar) {
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < ar.length; i++) {
			
			if (ar[i]>max) {
				
				max = ar[i];
			}
		}return max;
	}
}
