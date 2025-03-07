package com.qa.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactCreationPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.utilities.TestBase;
import com.qa.crm.utilities.TestUtilities;

public class ContactCreationTest extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactCreationPage contactCreationPage;
	public TestUtilities testUtils;
	
	String sheetname="sheet1";
	
	
	public ContactCreationTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		browserSetUp();
		loginPage=new LoginPage();
		homePage=new HomePage();
		testUtils=new TestUtilities();
		contactCreationPage=new ContactCreationPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
		
		
		
	}
	
	
	@Test(priority=1)
	public void conatctClick() {
		
		contactCreationPage=homePage.clickOnNewContact();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=TestUtilities.getTestdata(sheetname);
		return data;
	}
	
	@Test(priority=2,dataProvider="getData")
	public void contactCreation(String title,String fname,String lname,String company) {
		
		homePage.clickOnNewContact();
		contactCreationPage.contactCreation(title, fname, lname,company);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
