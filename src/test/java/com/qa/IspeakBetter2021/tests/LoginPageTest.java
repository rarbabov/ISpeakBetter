package com.qa.IspeakBetter2021.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.IspeakBetter2021.base.BasePage;
import com.qa.IspeakBetter2021.page.LoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		// launch browser
		// launch url
		// config
		// basePage
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}
	
	@Test(priority = 1, description = "verify page title method ")
	public void verifyLoginPageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = loginPage.getPageTitle();
		System.out.println("login page title is " + title);
		Assert.assertEquals(title, "Learn English with Online Teachers - Get your Free Live English Class Now.");
	}
	
//	@Test(priority = 2, description = "verify sign up link is displayed")
//	public void verifySignUpLink() {
//		Assert.assertTrue(loginPage.checkSignUpLInk());
//	}
	
	@Test(priority = 2, description = "login system with valid username and password")
	public void LoginTest()  {
		
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		
		
	}
	

	@Test(priority = 3, description = "verify Content page title  ")
	public void verifyContentheaderText() throws InterruptedException  {
		Thread.sleep(5000);
		String title2 = loginPage.getContentheaderText();
		System.out.println("Content header title is  " + title2);
		Assert.assertEquals(title2, "Content");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
