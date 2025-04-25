package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.LoginPage;
import com.qa.crm.utilities.TestBase;
//loginTest functionality
public class LoginTest extends TestBase {
	
	public LoginPage loginPage;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		browserSetUp();
		loginPage=new LoginPage();
	}
	
	@Test(priority=2)
	public void titleDisplay() {
		boolean flag=loginPage.isPageTitleDisplay();
		Assert.assertTrue(flag);
		
	}
	
	
	@Test(priority=1)
	public void login() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
