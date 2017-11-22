package com.samaya.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class EmployeesPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Employees')]")
	WebElement employeeLebel;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement employeeButton;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	WebElement enterFullName;
	
	//Intializing the page objects	
		public EmployeesPage(){
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyEmployeeLebel(){
			return employeeLebel.isDisplayed();
		}
		
		public void clickCreateEmployeeButton(){
			employeeButton.click();
			
		}
		public void createEmployee(){
			enterFullName.sendKeys(prop.getProperty("entername"));
			
		}
		
		
	

}
