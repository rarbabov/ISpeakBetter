package com.qa.IspeakBetter2021.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.IspeakBetter2021.base.BasePage;

public class HomePage extends BasePage{
	
	WebDriver driver;	
	// Locator
	By loginLink = By.xpath("//*[@id=\"cmdSiginLink\"]");
	By facebookLink = By.xpath("//*[@id=\"frmSignin\"]/div/p[1]/b[1]/a");
	By forgotPassword = By.id("lnkFogotPassword");
	
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// methods
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getFacebooklinkText() {
		return driver.findElement(facebookLink).getText();
	}
	
	public String getForgotPasswordText() {
		return driver.findElement(forgotPassword).getText();
	}
	
	public String getHomeUrl() {
		return driver.getCurrentUrl();
	}

}
