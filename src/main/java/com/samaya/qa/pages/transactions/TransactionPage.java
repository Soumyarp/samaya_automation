package com.samaya.qa.pages.transactions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
	
	@FindBy(xpath="//a[contains(text(),'Pending - Others')]")
	WebElement pendingOthers;
	
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
	
	@FindBy(xpath="//button[contains(.,'Withdraw')]")
	WebElement withdrawButton;
	
	@FindBy(xpath="//app-my-on-duty-search/div/div/st-table/div[2]/div/div[1]/div[2]")
	WebElement actiononApplicationList;
	
	@FindBy(xpath="//app-indirect-reportees-on-duty-search/div/div/st-table/div[2]/div/div[1]/div[2]")
	WebElement pendingOtherList;
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
		
		public void clickPendingOthersTab(){
			pendingOthers.click();
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
		
		public void clickWithDrawButton(){
			withdrawButton.click();
		}
		
		public void applicationListonEmployee(){
			actiononApplicationList.click();
		}
		
		public void clickPendingOtherList(){
			pendingOtherList.click();
		}
		
		public void selectDatebByJS(WebDriver driver, WebElement element, String dateval){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
		//	js.executeScript("arguments[0].setAttribute('value',"+dateval+");", element);
			//js.executeScript("document.queryselector(element).dateval")
		}
	
	
	
	
	
	
	

	
		
}