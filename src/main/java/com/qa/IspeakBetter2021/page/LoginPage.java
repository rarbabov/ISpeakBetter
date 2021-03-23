package com.qa.IspeakBetter2021.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.IspeakBetter2021.base.BasePage;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	// Locators //*[@id="cmdSiginLink"]
	
	By emailId = By.id("_email");
	By password = By.id("_password");
	By loginBtn = By.id("cmdSignin"); 
	By loginLink = By.xpath("//*[@id=\"cmdSiginLink\"]");
	By libraryLink = By.xpath("//*[@id='navbar-collapse2']/ul/li[2]/a");
	By vocabularyLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[1]/div[2]/center/a");
	By content = By.xpath("//*[@id='tree2']/span/h2");
	
	//  //*[@id="tree2"]/span/h2
	//  //*[@id="home-section"]/div/div/div/div[1]/div/h1
	
	// Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page Methods
	
	public String getPageTitle() {
		return driver.getTitle();
		
		
	}
	
//	public boolean checkSignUpLInk() {
//		return driver.findElement(signUpLink).isDisplayed();
//	}
	
	public void doLogin(String username, String pwd) {
		driver.findElement(loginLink).click();
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		driver.findElement(libraryLink).click();
		driver.findElement(vocabularyLink).click();
	}
	
	public String getContentheaderText() {
		return driver.findElement(content).getText();
		
	}
	
	
	
}
