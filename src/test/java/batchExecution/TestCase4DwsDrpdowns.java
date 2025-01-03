package batchExecution;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase4DwsDrpdowns extends DWSBase
{
	@Test
	public void dropdowns() throws InterruptedException
	{
		
		//with linktext
//		driver.findElement(By.linkText("Digital downloads")).click();
		
		//by xpath
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
		WebElement sort_by = driver.findElement(By.id("products-orderby"));
//		WebElement multi = driver.findElement(By.id("products-pagesize"));
		
		Select sel=new Select(sort_by);
		//sort By
		List<WebElement> options = sel.getOptions();
		int i=0;
		for(WebElement web:options)
		{
			sort_by = driver.findElement(By.id("products-orderby"));
			sel=new Select(sort_by);
//			Thread.sleep(1000);
			sel.selectByIndex(i++);
		}
		System.out.println("Selected all options of sort By Succesfully ");
		//for display dropdown
		WebElement display = driver.findElement(By.id("products-pagesize"));
		Select sel1=new Select(display);
		
		List<WebElement> option = sel1.getOptions();
		int j=0;
		for(WebElement web:option)
		{
			display = driver.findElement(By.id("products-pagesize"));
			sel1=new Select(display);
//			Thread.sleep(1000);
			sel1.selectByIndex(j++);
		}
		System.out.println("Selected all options of display Succesfully ");
		
		// View_as products-viewmode
		WebElement view_as = driver.findElement(By.id("products-viewmode"));
		Select view=new Select(view_as);
		
		List<WebElement> option1 = view.getOptions();
		int k=0;
		for(WebElement web:option1)
		{
			view_as = driver.findElement(By.id("products-viewmode"));
			view=new Select(view_as);
//			Thread.sleep(1000);
			view.selectByIndex(k++);
		}
		System.out.println("Selected all options of view_as Succesfully ");
		
		
	}
}
