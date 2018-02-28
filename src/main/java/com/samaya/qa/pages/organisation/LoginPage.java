package com.samaya.qa.pages.organisation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Need to define pagefactory/object repository of login page 
	//page factory --OR
	@FindBy(xpath="//st-input[1]/div/input")
	public
	WebElement email;
	@FindBy(xpath="//input[@type='email']")
	public
	WebElement email1;
	@FindBy(xpath = "//st-input/div/input[@type='password']")
	public
	WebElement password;
	
	@FindBy(xpath = "//st-input/div/input[@type='password']")
	public
	WebElement password1;
	
	@FindBy(xpath="//button[@type='submit']")
	public
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]/@href")
	WebElement forgetPasswordLink;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-login/div/div/img")
	WebElement logo;
	
    //Intializing the page objects	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	public void login(String username, String passwrd){
		if(email.isDisplayed()==true)
		{
		email.sendKeys(username);
		password.sendKeys(passwrd);
		loginButton.click();
		}
		else{
			System.out.println("unable to login");
		}
		
		
	}
	
	public String  verifyDashboardPage()
	{
		return driver.getCurrentUrl();
	}
	
}
