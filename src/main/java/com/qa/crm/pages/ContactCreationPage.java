package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.utilities.TestBase;

public class ContactCreationPage extends TestBase {
	
	@FindBy(xpath="//*[text()='Contact Information']")
	WebElement pageTitle;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fname;
	
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	
	
	
	//init
	
	public ContactCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void contactCreation(String title,String fName,String lName,String comp) {
		
		Select sc=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		sc.selectByVisibleText(title);
		
		fname.sendKeys(fName);
		lname.sendKeys(lName);
		saveBtn.click();
		company.sendKeys(comp);
		
		
	}

}
