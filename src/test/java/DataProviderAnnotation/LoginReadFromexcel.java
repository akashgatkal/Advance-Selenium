package DataProviderAnnotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginReadFromexcel {
	@DataProvider(name="loginfunction")
	public Object[][] provider() throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/loginDetails.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		int column=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] obj = new Object[row][column];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j< column;j++ )
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}
	@Test(dataProvider="loginfunction")
	public void receiver(String username,String pass) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
		Thread.sleep(3000);
		driver.close();
		//check even or odd
		//check prime
		
	}
}
