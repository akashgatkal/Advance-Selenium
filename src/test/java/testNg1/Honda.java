package testNg1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Honda {
	@Test(groups ="integration")
	public void honda() {
		ChromeDriver driver=new ChromeDriver();
	 	//maximize 
	 	driver.manage().window().maximize();
	 	//waiting condition
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 	//enter into honda page
	 	driver.get("https://www.honda2wheelersindia.com/");
	 	System.out.println("I am in Honda");
	 	driver.close();
	}
}
