package com.crm.AdvancA9Basic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

public class DwsSearchField extends DWSBase{
	@Test
	public void main() throws InterruptedException {
	driver.findElement(By.id("small-searchterms")).sendKeys("WelcomeToFramework");
	driver.findElement(By.cssSelector("input[value='Search']")).click();;
	Thread.sleep(3000);
	}
}
