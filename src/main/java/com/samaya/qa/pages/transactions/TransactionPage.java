package com.samaya.qa.pages.transactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.AffiliatePage;
import com.samaya.qa.pages.organisation.BranchesPage;

public class TransactionPage  extends TestBase{
	
	@FindBy(xpath="//div[contains(text(),'Transactions')]")
	WebElement TransactionLevel;
	
	@FindBy(xpath="//a[contains(text(),'On Duty')]")
	WebElement onDutyLink;
	
	@FindBy(xpath="//a[contains(text(),'Leaves')]")
	WebElement leaveLink;
	
	@FindBy(xpath="//a[contains(text(),'Compoff')]")
	WebElement compOffLink;
	
	//Intializing the page objects	
		public TransactionPage(){
			PageFactory.initElements(driver, this);
		}
	
	public void clickOnTransactions(){
		TransactionLevel.click();
		}
		public OnDutyPage clickOnOnDutyLink(){
			onDutyLink.click();
			return new OnDutyPage();
		}
		public LeavePage clickOnleaveLink(){
			leaveLink.click();
			return new LeavePage();
		}
		public void clickOnCompoffLink(){
			compOffLink.click();
			
		}
		
		public String VerifyOnDutyPageUrl(){
			return driver.getCurrentUrl();
		}
		public String VerifyCompoffPageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String VerifyLeavePageUrl(){
			return driver.getCurrentUrl();
		}
	
	
	
	
	
	
	

	
		
}