package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class LeaveTypePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Leave Types ')]")
	WebElement leaveTypeLebel;
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newLeaveTypeButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickonDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement leaveTypeName;
	
	@FindBy(xpath="//input[@placeholder='Abbreviation']")
	WebElement leaveTypeabbrevation;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-leave-type-search/app-leave-type-details/div/div[1]/button")
	WebElement closeLeaveTypeScreen;
	
	
	//Intializing the page objects	
	public LeaveTypePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickLeaveType(){
		newLeaveTypeButton.click();
	}
	
	public void clickonSelectAffiliate(int arg)
	{
		selectContentfrmdrpdwn.get(arg).click();
	}
	
	public void closeLeaveTypeScreen(){
		closeLeaveTypeScreen.click();
	}
	
	public void createNewLeaveType(String name, String abbrevation) throws InterruptedException{
		clickonDropdown.click();
		Thread.sleep(2000);
		clickonSelectAffiliate(0);
		leaveTypeName.sendKeys(name);
		leaveTypeabbrevation.sendKeys(abbrevation);
		Thread.sleep(2000);
		saveButon.click();
		Thread.sleep(7000);
		
	}

}
