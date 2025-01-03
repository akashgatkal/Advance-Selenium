package testNg2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {
	@Test(groups ="integration")
	public void redbus() {
		ChromeDriver driver=new ChromeDriver();
	 	//maximize 
	 	driver.manage().window().maximize();
	 	//waiting condition
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 	//enter into Redbus page
	 	driver.get("https://www.redbus.in/");
	 	System.out.println("I am in redbus");
	 	driver.close();
	}
}
