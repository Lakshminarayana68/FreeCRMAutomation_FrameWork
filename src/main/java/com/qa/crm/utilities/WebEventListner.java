package com.qa.crm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListner implements WebDriverListener  {
	
	public void beforeGet(WebDriver driver,String url) {
		
		System.out.println("Before navigating to:"+" "+url);
	}
	
	public void afterGet(String url,WebDriver driver) {
		
		System.out.println("After navigating to:"+" "+url);
	}
	
	

}
