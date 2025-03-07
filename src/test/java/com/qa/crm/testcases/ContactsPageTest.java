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

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtilities testUtils;
	
	public ContactsPageTest() {
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
		testUtils.switchToFrame();
		contactsPage=homePage.clickOnContacts();
		
	}
	@Test(priority=1)
	public void pageLogoDisplay() {
		
		
		Assert.assertTrue(contactsPage.isPageLogoDisplay());
	}
	
	@Test(priority=2)
	public void contactSelectByName() {
		
		contactsPage.selectContactsByName(3);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
