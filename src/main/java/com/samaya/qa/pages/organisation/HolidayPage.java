package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class HolidayPage  extends TestBase{
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newHolidayButton;
	
	@FindBys({@FindBy(xpath="//div/div/button")})
	List<WebElement> clickDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmAffiliatedrpdwn;
	
	@FindBys({
		@FindBy(xpath="//div[3]/st-dropdownlist/div/ul/li/a")})
		List<WebElement> selectContentfrmHolidaydrpdwn;
	
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement holidayName;
	
	@FindBy(xpath="//input[@placeholder='Date']")
	WebElement holidayDate;
	
	@FindBy(xpath="//td[@data-day='12/01/2017']")
	WebElement selHolidayDate;

	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-holiday-search/app-holiday-details/div/div[1]/button")
	WebElement closeHolidayScreen;
	
	
	//Intializing the page objects	
			public HolidayPage(){
				PageFactory.initElements(driver, this);
			}
			public void clickHolidayBtn(){
				newHolidayButton.click();
			}
			
			public void clickAffiliateDropDown(int arg){
				clickDropdown.get(arg).click();
			}
			
			public void clickonSelectAffiliate(int arg)
			{
				selectContentfrmAffiliatedrpdwn.get(arg).click();
			}
			
			public void clickHolidayTypeDropDown(int arg){
				clickDropdown.get(arg).click();
			}
			
			public void clickonSelectHolidayType(int arg)
			{
				selectContentfrmHolidaydrpdwn.get(arg).click();
			}
			public void closeCreateHolidayScreen(){
				closeHolidayScreen.click();
			}
			
			public void selectDateOfJoining() throws InterruptedException{
				holidayDate.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", selHolidayDate);
				Thread.sleep(2000);
			}
			
			public void enterHolidayName(String holname){
				holidayName.sendKeys(holname);
				
			}
			
			public void clickOnSaveBtn(){
				saveButon.click();
			}
			
	

}
