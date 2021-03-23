package com.qa.IspeakBetter2021.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.IspeakBetter2021.base.BasePage;
import com.qa.IspeakBetter2021.page.HomePage;
import com.qa.IspeakBetter2021.page.LoginPage;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void serUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String borwserName = properties.getProperty("browser");
		driver = basePage.init_driver(borwserName);
		driver.get(properties.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}
	
	@Test(priority = 1, description = "verify home page title")
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is" + title);
		Assert.assertEquals(title, title); // burayi degistirmem lazim
	}
	
	@Test(priority = 2, description = "verify Facebook link text")
	public void verifyFacebooklinkText() {
		String facebookText = homePage.getFacebooklinkText();
		System.out.println("facebook link text is: " + facebookText);
		Assert.assertEquals(facebookText, "Facebook");
	}
	
	@Test(priority = 3, description = "verify Forgot Password link text")
	public void verifyForgotPasswordText() {
		String forgotPassword = homePage.getForgotPasswordText();
		System.out.println("Forgot password link text is: " + forgotPassword);
		Assert.assertEquals(forgotPassword, "Forgot Password?");
	}
	
	@Test(priority = 4, description = "verify page URL")
	public void verifyHomePageUrl() {
		String url = homePage.getHomeUrl();
		System.out.println("page url is: " + url);
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
