package com.samaya.qa.pages.transactions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.util.TestUtil;

public class CompoffPage extends TestBase{
	
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newCompoffButton;
	
	@FindBy(xpath="//st-checkbox[@formcontrolname='onBehalfOf']/label")
	WebElement behalfOfchkbx;
	
	@FindBy(id="selectedEmployeeAccountNo")
	WebElement emplyecntNotxtBox;
  
	@FindBy(xpath="//div[1]/input[@formcontrolname='preRequest']")
	WebElement earnCompoffRadioBtn;
	
	@FindBy(xpath="//input[@placeholder='Start Date']")
	WebElement StartDate;
	
	@FindBy(xpath="//td[@data-day='12/02/2017']")
	WebElement SelectStartDateeeee;
	
	@FindBy(xpath="//input[@placeholder='End Date']")
	WebElement EndDate;
	
	@FindBy(xpath="//td[@data-day='12/02/2017']")
	WebElement SelectEndDate;
	
	@FindBy(id="compoffReason")
	WebElement compOffreason;
	
	@FindBys({
		@FindBy(xpath="//form/div[3]/div[3]/st-auto-complete/div/div/ul/li/div")})
		List<WebElement> resonforCompOffsecondOption;
	
	
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBys({
		@FindBy(xpath="//st-auto-complete/div/div/ul/li/div")})
		List<WebElement> selectEmployeename;
	
	@FindBys({
		@FindBy(xpath="//form/div[1]/div[2]/st-auto-complete/div/div/ul/li")})
		List<WebElement> EmployeeList;
	
	@FindBys({
		@FindBy(xpath="//app-compoff-search/div/div/st-table/div[2]/div/div/div[2]/div[1]/span")})
		List<WebElement> compoffDashboardRowsID;
	
	//Intializing the page objects	
	public CompoffPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewCompoffbtn(){
		newCompoffButton.click();
	}
	
	public void clickonOnbehalfchkBox() throws InterruptedException
	{
		behalfOfchkbx.click();
		Thread.sleep(1000);
	}
	
	public void selectEmployee(int arg)
	{
		//emplyecntNotxtBox.click();
		//displayEmployeeList(arg);
		//emplyecntNotxtBox.click();
		selectEmployeename.get(arg).click();
		
	}
	public void clickonOnearnCompoffRadioBtn() throws InterruptedException
	{
		earnCompoffRadioBtn.click();
		
	}
	public void selectStartDate() throws InterruptedException
	{
		
		StartDate.click();
		//StartDate.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SelectStartDateeeee));
		System.out.println(SelectStartDateeeee.isDisplayed());
		if(SelectStartDateeeee.isDisplayed())
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SelectStartDateeeee);
			
			//SelectStartDateeeee.click();
    	//SelectStartDate.click();
		Thread.sleep(2000);
		}
		
		
	}
	public void selectEndDate() throws InterruptedException
	{
		EndDate.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SelectEndDate);
		Thread.sleep(2000);
		
		
		}
	public void EnterReason() throws InterruptedException
	{
		compOffreason.click();
		Thread.sleep(4000);
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", resonforCompOff);
		resonforCompOffsecondOption.get(0).click();
		Thread.sleep(2000);
		
	}
	public void clickOnSaveCTA()
	{
		saveButon.click();
	}
	
	public String clkOnFirstRowofcomPffDashbrd(int args)
	{
		String empIDD=compoffDashboardRowsID.get(args).getText();
		
		return empIDD;
	}
	public String displayEmployeeList(int arg)
	{
		emplyecntNotxtBox.click();
		 String s2=EmployeeList.get(arg).getText();
		String s3[] =s2.split("\\[");
		//String s4=s3[1].substring(0, s3.length-1);
		 return s3[1];	
		
		
	}
	public void verifysaveCompOff()
	{
		displayEmployeeList(1);
		
	}
	
	
		
	
	
	
	
	
	
}
