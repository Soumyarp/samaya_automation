package com.samaya.qa.pages.organisation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	 @FindBy(xpath="//app-root/header/div[2]/div[2]/div/ul/li/a")})
List <WebElement> logoutButton;
 
 //WebElement element = driver.findElement(By.xpath("html/body/app-root/div[1]/div[2]/div/app-dashboard/app-employee-dashboard/div[3]/div[1]/div/div/div[1]"));
 
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
		
		public void scrollWindowDashPage() throws AWTException, InterruptedException{
        	System.out.println("scrolling started");
    //    	JavascriptExecutor jse = (JavascriptExecutor) driver;
         // jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));,element");
    //   	jse.executeScript("arguments[0].scrollIntoView(true);",element);
        //	jse.executeScript("scroll(0, 500);");
        	
        	Robot robot = new Robot();  // Robot class throws AWT Exception 
            Thread.sleep(2000); // Thread.sleep throws InterruptedException 
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_END);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_CONTROL) ;
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_END);
        	
        }
        
		
}

