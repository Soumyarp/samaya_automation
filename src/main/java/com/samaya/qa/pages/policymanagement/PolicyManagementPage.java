package com.samaya.qa.pages.policymanagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.transactions.LeavePage;
import com.samaya.qa.pages.transactions.OnDutyPage;

public class PolicyManagementPage extends TestBase {
	
	@FindBy(xpath="//div[contains(text(),'Policy Management')]")
	WebElement PolicyManagementLevel;
	
	@FindBy(xpath="//a[contains(text(),'Leave Policies')]")
	WebElement leavePolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'Attendance Status')]")
	WebElement attendancePolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'Profile Update Policies')]")
	WebElement profileUpdatePolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'Comp-Off Policies')]")
	WebElement compOffPolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'OT Policies')]")
	WebElement otPolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'Work Hour Policies')]")
	WebElement workHourPolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'PayRoll Policies')]")
	WebElement payRollPolicyLink;
	
	//Intializing the page objects	
			public PolicyManagementPage(){
				PageFactory.initElements(driver, this);
			}
		
		public void clickOnPolicyManagement(){
			PolicyManagementLevel.click();
			}
			public void clickOnLeavePolicy(){
				leavePolicyLink.click();
				
			}
			public void clickOnAttendancePolicy(){
				attendancePolicyLink.click();
				
			}
			public void clickOnCompoffPolicy(){
				compOffPolicyLink.click();
			}
			
			public void clickOnProfileUpdatePolicy(){
				profileUpdatePolicyLink.click();
				
			}
			public void clickOnOTPolicy(){
				otPolicyLink.click();
				
			}
			public void clickOnWorkHourPolicy(){
				workHourPolicyLink.click();
			}
			
			public void clickOnPayRollPolicy(){
				payRollPolicyLink.click();
			}

			
			public String VerifyLeavePolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			public String VerifyCompoffPolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			public String VerifyAttendancePolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			public String VerifyProfileUpdatePolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			public String VerifyOtPolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			public String VerifyWorkHourPolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			public String VerifyPayRollPolicyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			
		

}
