package com.samaya.qa.pages.transactions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBy(xpath= "//a[contains(text(),'Pending - Reportees')]")
	WebElement pendingReportees;
	
	@FindBys({
		@FindBy(xpath="//app-reportees-on-duty-search/div/div/st-table/div[2]/div/div[1]")})
	List<WebElement> pendingReportiesDetailsList;
	
	@FindBys({
		@FindBy(xpath="//st-button/button[@type='button']")})
	List<WebElement> actionButtons;
	
	@FindBy(xpath="//textarea[@title='Enter Message']")
	WebElement enterMessage;
	
	@FindBy(xpath="//st-button/button[contains(.,'SUBMIT')]")
	WebElement clickingReasonSubmitButton;
	
	@FindBy(xpath="//st-button/button[contains(.,'Cancel')]")
	WebElement clickingReasonCancelButton;
	
	@FindBy(xpath="//h1[contains(text(),'OKAY')]")
	WebElement okayButton;
	
	
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
		
		public void clickPendingReporteestab(){
			pendingReportees.click();
		}
		
		public void pendingReporteesList(int arg){
			pendingReportiesDetailsList.get(arg).click();
		}
		
		public void clickActionButtons(int arg){
			actionButtons.get(arg).click();
		}
		
		public void enterReasonMessage(String message){
			enterMessage.sendKeys(message);
		}
		
		public void clickSubmitButton(){
			clickingReasonSubmitButton.click();
		}
		
		public void clickCancelButton(){
			clickingReasonCancelButton.click();
		}
		
		public String clickOkayButton(){
			 okayButton.getText();
			 okayButton.click();
			return null;
		}
	
	
	
	
	
	
	

	
		
}