package com.qa.crm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static WebEventListner webEventListner;
	public static SearchContext e_driver;
	
	//creating constructor
	
	public TestBase() {
		
		try {
			
			prop=new Properties();
			
			FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/crm/config/config.properties");
			prop.load(fp);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void browserSetUp() {
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		
		
		
		//e_driver=new EventFiringDecorator();
		webEventListner=new WebEventListner();
		
		
		
		
	   WebDriver e_driver=new EventFiringDecorator<WebDriver>(webEventListner).decorate(driver);
	   driver=e_driver;
       
		
		
		
		
		
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
	}

}
