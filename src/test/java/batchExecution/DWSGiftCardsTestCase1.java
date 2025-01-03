package batchExecution;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DWSGiftCardsTestCase1 extends DWSBase {
	@Test
	public void giftCards() throws InterruptedException {

		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		Thread.sleep(1000);

		String[] ar = { "admin01", "admin01@gmail.com", "admin0123", "admin01234@gmail.com" };
		int i = 0;

		List<WebElement> textField = driver.findElements(By.xpath("//div[@class='giftcard']/div/input"));
		for (WebElement web : textField) {
			web.clear();
			Thread.sleep(1000);
			web.sendKeys(ar[i++]);

		}
		Thread.sleep(1000);

		driver.findElement(By.id("giftcard_2_Message")).sendKeys("Want to Buy This Product");
		WebElement qty = driver.findElement(By.id("addtocart_2_EnteredQuantity"));
		qty.clear();
		Thread.sleep(1000);
		qty.sendKeys("2");
		driver.findElement(By.id("add-to-cart-button-2")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("close")).click();

//			driver.findElement(By.xpath("//li[@id='topcartlink']")).click();
//			driver.findElement(By.className("cart-label")).click();
//			driver.findElement(By.xpath("(//a[@class='ico-cart'])[1]")).click();
		driver.findElement(By.className("ico-cart")).click();

		Thread.sleep(1000);
		WebElement giftCards = driver.findElement(By.linkText("$25 Virtual Gift Card"));
		Thread.sleep(1000);
		if (giftCards.isDisplayed()) {
			System.out.print("Product is added succesfully");
			driver.findElement(By.name("removefromcart")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("updatecart")).click();

		} else {
			System.out.print("Product is not added");
		}

		

	}

}
