package com.crm.AdvancA9Basic;

import org.testng.annotations.Test;

public class Dependency {
	@Test(enabled=false) //if it will execute within 1 sec then this test case is failed and others 2 are skipped.
	public void createAccount()
	{
	System.out.println("Create Account");
	}

	@Test(dependsOnMethods ="createAccount")
	public void modifyAccount()
	{
	System.out.println("Modify Account");
	}

	@Test(dependsOnMethods ="createAccount")
	public void deleteAccount()
	{
	System.out.println("Delete Account");
	}
}
