package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.utilities.TestBase;
import com.qa.crm.utilities.TestUtilities;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	TestUtilities testUtils;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		browserSetUp();
		loginPage=new LoginPage();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		testUtils=new TestUtilities();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyPageTitle() {
		
		String title=homePage.verifyPageTitle();
		Assert.assertEquals(title,"CRMPRO");
	}
	
	@Test(priority=2)
	public void contctClick() {
		testUtils.switchToFrame();
		homePage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
