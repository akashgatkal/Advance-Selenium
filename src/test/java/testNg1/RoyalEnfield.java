package testNg1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RoyalEnfield {
	@Test(groups ="compatibility")
	public void Royalenfield() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.royalenfield.com/in/en/home/");
		System.out.println("I am in Royal enfield");
		driver.close();
	}
}
