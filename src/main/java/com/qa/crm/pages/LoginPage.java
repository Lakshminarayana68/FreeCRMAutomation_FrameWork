package com.qa.crm.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.qa.crm.utilities.TestBase;

//inheritance
public class LoginPage extends TestBase {
	
	//define webelements
	
	
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement pageTitle;
	
	@FindBy(xpath="//*[text()='Home']")
	WebElement homeBtn;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement signupBtn;
	
	
	
	//Initialization
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	

	public HomePage login(String un,String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public boolean isPageTitleDisplay() {
		return pageTitle.isDisplayed();
		
	}
	
	
	
	

}
