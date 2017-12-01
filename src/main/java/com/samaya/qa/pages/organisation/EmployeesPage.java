package com.samaya.qa.pages.organisation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class EmployeesPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Employees')]")
	WebElement employeeLebel;
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newEmployeeButton;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	WebElement fullName;
	
	@FindBys({@FindBy(xpath="//div/div/button")})
	List<WebElement> clickDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[@class='dropdown open']/ul/li/a")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBys({
	@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
	List<WebElement> selectContentfrmAccessProfiledrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Enter Employee Id']")
	WebElement employeeId;
	
	@FindBy(xpath="//input[@placeholder='Enter Enrollment Id']")
	WebElement enrollmentId;
	
	@FindBy(xpath="//input[@placeholder='Enter Date Of Joining']")
	WebElement dateOFJoining;
	
	@FindBy(xpath="//td[@data-day='11/28/2017']")
	WebElement SelectJoiningDate;
	
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-employee-search/app-employee-detail/div/div[1]/button")
	WebElement closeCreatDeptScreen;
	
	@FindBys({
		@FindBy(xpath="//st-button/button[contains(.,'PROCEED')]")})
	List <WebElement> proceedButton;
	
	
	
	
	//Intializing the page objects	
		public EmployeesPage(){
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyEmployeeLebel(){
			return employeeLebel.isDisplayed();
		}
		
		public void clickCreateEmployeeButton(){
			newEmployeeButton.click();
		}
		
		public void enterEmployeeName(String name){
			fullName.sendKeys(name);
			
		}
		
		public void clickAffiliateDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickBranchDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickDeptDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickDesignDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickEmpCategoryDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickAccessProfileDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickMaritialStatusDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void closeEmployeeCreateandEditPage(){
			closeCreatDeptScreen.click();
		}
		
		public void selectDateOfJoining() throws InterruptedException{
			dateOFJoining.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SelectJoiningDate);
			Thread.sleep(2000);
		}
		
		public void enterEmployeeID(String empid){
			
			employeeId.sendKeys(empid);
			
		}
		
        public void enterEnrollID(String enrollid){
			employeeId.clear();
			employeeId.sendKeys(enrollid);
			
		}
        
        public void selectAffiliateFromDropDown(int arg){
        	selectContentfrmdrpdwn.get(arg).click();
        }
        
        public void selectBranchfromDropDown(int arg){
        	selectContentfrmdrpdwn.get(arg).click();
        	
        }
        
        public void clickOnProceedButton(int arg){
        	proceedButton.get(arg).click();
        }
        
        
        
		
        
        
        
		
		
	

}
