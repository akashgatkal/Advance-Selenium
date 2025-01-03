package testNg2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class Qspiders {
	@Test(groups ="functionality")
	public void qspiders() {
		ChromeDriver driver=new ChromeDriver();
	 	//maximize 
	 	driver.manage().window().maximize();
	 	//waiting condition
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 	//enter into Qspiders page
	 	driver.get("https://www.qspiders.com/");
	 	System.out.println("I am in qspiders");
	 	driver.close();
	}
}
