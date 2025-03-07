package com.qa.crm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.utilities.TestBase;
import com.qa.crm.utilities.TestUtilities;

public class HomePage extends TestBase{
	
	TestUtilities testUtils;
	
	@FindBy(xpath="//*[text()='Home']")
	WebElement Home;
	
	@CacheLookup
	@FindBy(xpath="//*[text()='Calendar']")
	WebElement calendar;
	@FindBy(xpath="//*[text()='Companies']")
	WebElement Companies;
	
	@FindBy(xpath="//*[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//*[@class='headertext' and contains(text(),'Gagan')]")
	WebElement username;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContact;
	
	
	//inititailize constructor
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		
		return driver.getTitle();
	}
	
	public void usernameDisplay() {
		
		username.isDisplayed();
	}
	
	public ContactsPage clickOnContacts() {
		
		contacts.click();
		return new ContactsPage();
	}
	
	 public void mouseOver() {
			
			Actions act=new Actions(driver);
			
			act.moveToElement(contacts).perform();
			
		}
	
	public ContactCreationPage clickOnNewContact() {
		mouseOver();
		newContact.click();
		return new ContactCreationPage();
		
	}
	
	
	
	
	
	
	
	

}
