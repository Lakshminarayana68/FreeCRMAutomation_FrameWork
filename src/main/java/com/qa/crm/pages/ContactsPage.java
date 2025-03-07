package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.utilities.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//*[@class='datacardtitle' and contains(text(),'Contacts')]")
	WebElement pageLogo;
	
	
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void selectContactsByName(int n){
		driver.findElement(By.xpath("(//input[@name='contact_id'])["+n+"]")).click();
	}
	
	public boolean isPageLogoDisplay() {
		
		return pageLogo.isDisplayed();
	}
	
	

}
