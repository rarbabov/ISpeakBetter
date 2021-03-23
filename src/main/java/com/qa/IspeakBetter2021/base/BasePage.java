package com.qa.IspeakBetter2021.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties properties;
	
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser name is " + browserName);
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		else {
			System.out.println("Browser name " + browserName + " is not found. Please pass the correct browser...!");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public Properties init_properties() {
		
		properties = new Properties();
		String path = "/Users/rej/eclipse-workspace/IspeakBetter2021"
				+ "/src/main/java/com/qa/IspeakBetter2021/config/config.properties";
		
		try {
			FileInputStream ip = new FileInputStream(path);
			properties.load(ip);
			
		} catch (FileNotFoundException e) {
			System.out.println("some issiu with config properties...Please correct!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
		
	}
	
}
