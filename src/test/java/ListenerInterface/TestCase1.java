package ListenerInterface;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerInterface.BasicListeners.class)
public class TestCase1 
{
	@Test
	public void main1()
	{
		Reporter.log("main1",true);
		
	}@Test
	public void main2()
	{
		Reporter.log("main2",true);
		assertEquals("java","Selenium");
		
	}@Test(dependsOnMethods="main2")
	public void main3()
	{
		Reporter.log("main3",true);
		
	}
}
