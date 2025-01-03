package testNg1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWS {
	@Test(groups ="smoke")
	public void dws() {
		ChromeDriver driver=new ChromeDriver();
	 	//maximize 
	 	driver.manage().window().maximize();
	 	//waiting condition
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 	//enter into Dws page
	 	driver.get("https://demowebshop.tricentis.com/");
	 	System.out.println("I am in DWS");
	 	driver.close();
	}
}
