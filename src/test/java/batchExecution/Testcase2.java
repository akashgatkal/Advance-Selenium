package batchExecution;

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

public class Testcase2 extends BaseClass {

	private static final String RSS_URL = "https://demowebshop.tricentis.com/news/rss/1";
	private static final String FACEBOOK_URL = "https://www.facebook.com/nopCommerce";

	@Test
	public void socialLinks() throws InterruptedException {
		preCondition("chrome");
		String parentWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		if (verify()) {
			try {
				navigateToSocialLinks();
				handleSocialLinks(parentWindow);
			} catch (Exception e) {
				System.out.println("Error during execution: " + e.getMessage());
				e.printStackTrace();
			} finally {
				postCondition();
			}
		} else {
			System.out.println("I am not on the DWS page.");
		}
	}

	private void navigateToSocialLinks() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='column follow-us']/ul/li/a")));
	}

	private void handleSocialLinks(String parentWindow) throws InterruptedException {
		List<WebElement> socialLinks = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));

		for (WebElement link : socialLinks) {
			String currentUrl = driver.getCurrentUrl();
			if (RSS_URL.equals(currentUrl)) {
				driver.navigate().back();
			} else {
				link.click();
				handleNewWindow(parentWindow);
			}
		}
	}

	private void handleNewWindow(String parentWindow) throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				String currentUrl = driver.getCurrentUrl();

				if (FACEBOOK_URL.equals(currentUrl)) {
					handleFacebookSignUp();
				}

				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	private void handleFacebookSignUp() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

		System.out.println("Entered Facebook sign-up process");

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Akash");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gatkal");

		// Set Date of Birth
		selectDropdownValue(By.id("day"), 25);
		selectDropdownValue(By.id("month"), 11);
		selectDropdownValue(By.id("year"), 24);

		// Select Gender and Enter Details
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("(//input[@name='reg_email__'])[1]")).sendKeys("9657004387");
		driver.findElement(By.xpath("(//input[@name='reg_email_confirmation__'])[1]")).sendKeys("9657004387");
	}

	private void selectDropdownValue(By locator, int index) {
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}
}
