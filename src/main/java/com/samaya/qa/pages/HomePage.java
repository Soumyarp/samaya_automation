package com.samaya.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class HomePage extends TestBase {
	
@FindBy(xpath ="//span[contains(text(),'admin')]")
WebElement userNameLabel;

@FindBy(xpath="//*[@id='appContentContainer']/div/app-login/div/div/img")
WebElement logo;

@FindBy(xpath="//div[contains(text(),'Organization')]")
WebElement Organisationlebel;

@FindBy(xpath="//a[contains(text(),'Employees')]")
WebElement EmployeesLink;

@FindBy(xpath="//a[contains(text(),'Affiliates')]")
WebElement AffiliateLink;

@FindBy(xpath="//a[contains(text(),'Branches')]")
WebElement BranchesLink;

@FindBy(xpath="//a[contains(text(),'Manage Tags')]")
WebElement Manage_TagsLink;

@FindBy(xpath="//a[contains(text(),'Departments')]")
WebElement DepartmentsLink;

@FindBy(xpath="//a[contains(text(),'Designations')]")
WebElement DesignationsLink;

@FindBy(xpath="//a[contains(text(),'Emp Types')]")
WebElement Emp_TypesLink;

@FindBy(xpath="//a[contains(text(),'Holidays')]")
WebElement HolidaysLink;

@FindBy(xpath="//a[contains(text(),'Leave Types')]")
WebElement Leave_TypesLink;

 @FindBys ({
	 @FindBy(xpath="//div/ul/li[3]/a/div")})
List <WebElement> logoutButton;
 
//Intializing the page objects	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		public boolean validateLogo(){
			return logo.isDisplayed();
		}
		public boolean verifyUsername(){
			return userNameLabel.isDisplayed();
		}
		public void clickOnOrganisation(){
		//	System.out.println(Organisationlebel);
			Organisationlebel.click();
		}
		public void clickOnEmployeesLink(){
			EmployeesLink.click();
			//return new EmployeesPage();
		}
		public AffiliatePage clickOnAffiliatePage(){
			AffiliateLink.click();
			return new AffiliatePage();
		}
		public BranchesPage clickOnBranchPage(){
			BranchesLink.click();
			return new BranchesPage();
			
		}
		
		public ManagePage clickOnManageTagPage(){
			Manage_TagsLink.click();
			return new ManagePage();
			
		}
		
		public ManagePage clickOnDepartmentPage(){
			DepartmentsLink.click();
			return new ManagePage();
			
		}
		
		public ManagePage clickOnDesignationPage(){
			DesignationsLink.click();
			return new ManagePage();
			
		}
		
		public ManagePage clickOnEmpTypePage(){
			Emp_TypesLink.click();
			return new ManagePage();
			
		}
		
		public ManagePage clickOnHolidayPage(){
			HolidaysLink.click();
			return new ManagePage();
			
		}
		
		public ManagePage clickOnLeaveTypePage(){
			Leave_TypesLink.click();
			return new ManagePage();
			
		}
		
		public void navigateToHomePage(){
			driver.navigate().back();
		}
		
		public String  verifyEmployeePageUrl()
		{
			return driver.getCurrentUrl();
		}
		
		public String VerifyBranchPageUrl(){
			return driver.getCurrentUrl();
		}
		public String VerifyDepartmentPageUrl(){
			return driver.getCurrentUrl();
		}
		public String VerifyDesignationPageUrl(){
			return driver.getCurrentUrl();
		}
		public String VerifyManageTagsPageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyAffiliatePageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyEmpTypePageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyHolidayPageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyLeaveTypePageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyEmployeeGroupPageUrl(){
			return driver.getCurrentUrl();
		}
		
		public void clickUsername(){
			userNameLabel.click();
		}
		
		public void clickLogoutButton(int arg){
			logoutButton.get(arg).click();
		}
		
}

