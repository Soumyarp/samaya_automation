package com.samaya.qa.pages.transactions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.samaya.qa.base.TestBase;

public class OnDutyPage extends TestBase{
	@FindBy(xpath="//st-button[@type='button']")
	WebElement applyODButton;
	
	@FindBy(xpath= "//div[@class='dropdown']")
	WebElement selectODType;
	
	@FindBy(xpath="//input[@placeholder='Start Date']")
	WebElement StartDate;
	
	/*@FindBy(xpath="//td[@data-day='02/12/2018']")
	WebElement startDate;*/
	
	@FindBy(xpath="//input[@placeholder='End Date']")
	WebElement EndDate;
	
	/*@FindBy(xpath="//td[@data-day='02/12/2018']")
	WebElement endDate;*/
	
	@FindBy(xpath="//input[@id='OdReason']")
	WebElement enterOdReason;
	
	@FindBy(xpath="//div[@class='toast']")
	WebElement successfullToastMessage;
	
	 @FindBy(xpath="//st-button/button[contains(.,'SUBMIT')]")
	 WebElement clickSubmitButton;
	 
	 @FindBys({
		 @FindBy(xpath="//st-dropdownlist/div/ul/li")})
	 List<WebElement> typeOfOD;
	 
	//Intializing the page objects	
		public OnDutyPage(){
			PageFactory.initElements(driver, this);
		}	
	    public void clickonApplyODButton(){
	    	applyODButton.click();
	    	}
	    public void clickSelectODtype(){
	    	selectODType.click();
	    }
	    public void selectODType(int arg){
	    	typeOfOD.get(arg).click();
	    }
	    public void selectStartDate() throws InterruptedException
		{
			String dateval= "2018-02-14";
			
		//	Thread.sleep(3000);
		  //  StartDate.click();
			//Thread.sleep(3000);
			/*TransactionPage transactionpage = new TransactionPage();
			transactionpage.selectDatebByJS(driver, StartDate, dateval);*/
			JavascriptExecutor js = (JavascriptExecutor)driver;
		//	String clickSearchJS="document.querySelector(\"[placeholder='Start Date']\")"+".click()";
		//	js.executeScript(clickSearchJS);
			Thread.sleep(2000);
			js.executeScript("document.querySelector(\"input[placeholder='Start Date']\").value='"+dateval+"';");
			StartDate.click();
			//js.executeScript("document.queryselector('form-control ng-pristine ng-invalid ng-touched error-border error-text-color undefined').value='03/01/2018'");
	//		js.executeScript("document.querySelector("input[placeholder='Start Date']").value=03/01/2018;");
			//StartDate.click();
			/*WebDriverWait wait = new WebDriverWait(driver, 40);

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StartDate));
			System.out.println(StartDate.isDisplayed());*/
			
			
			/*if(startDate.isDisplayed())
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", startDate);
				
				//SelectStartDateeeee.click();
	    	//SelectStartDate.click();
			Thread.sleep(2000);
			}*/
		}
		public void selectEndDate() throws InterruptedException
		{
			
			Thread.sleep(2000);
			String dateval= "2018-02-14";
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.querySelector(\"input[placeholder='End Date']\").value='"+dateval+"';");
			EndDate.click();
			
			/*JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", endDate);
			Thread.sleep(2000);*/
			}
		public void EnterReason(String reason) throws InterruptedException
		{
			enterOdReason.click();
			enterOdReason.sendKeys(reason);
		}
		
		public void clickOnSubmitButton(){
			clickSubmitButton.click();
		}
		
		public String getSuccessfullToastMessage(){
		return	successfullToastMessage.getText().trim();
		}

	    
	
	
	
	
	
	

}
