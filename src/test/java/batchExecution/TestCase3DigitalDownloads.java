package batchExecution;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase3DigitalDownloads extends DWSBase
{
	@Test
	public void digitalDownloads() throws InterruptedException
	{
		
		if(driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/")) 
		{
			driver.findElement(By.linkText("Digital downloads")).click();;Thread.sleep(1000);
			List<WebElement> add=driver.findElements(By.xpath("//input[@value='Add to cart']"));
			
			for(WebElement web:add) 
			{
				web.click();
				Thread.sleep(1000);
				
				
			}
			
			driver.findElement(By.className("close")).click();
			driver.findElement(By.className("ico-cart")).click();
			
			Thread.sleep(1000);
			
			
			
            List<WebElement> prices = driver.findElements(By.className("product-subtotal"));
            List<WebElement> removeButtons = driver.findElements(By.name("removefromcart"));

            double maxPrice = 0;
            int maxIndex = -1;
            Thread.sleep(1000);
            for (int i = 0; i < prices.size(); i++) {
                double price = Double.parseDouble(prices.get(i).getText());
                if (price > maxPrice) {
                    maxPrice = price;
                    maxIndex = i;
                }
            }
            Thread.sleep(1000);
            if (maxIndex != -1) {
                removeButtons.get(maxIndex).click();
                System.out.print("Product is remove Succesfully");
            }
			
		}else
		{
			System.out.print("Not Entered in DWS page");
		}
		Thread.sleep(1000);
		
		
		
		
		
	}
}
