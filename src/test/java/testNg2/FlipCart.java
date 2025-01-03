package testNg2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class FlipCart {
	@Test(groups ="smoke")
	public void flipkart() {
		ChromeDriver driver=new ChromeDriver();
	 	//maximize 
	 	driver.manage().window().maximize();
	 	//waiting condition
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 	//enter into flipkart page
	 	driver.get("https://www.flipkart.com/");
	 	System.out.println("I am in flipcart");
	 	driver.close();
	}
}
