package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class ManagePage  extends TestBase{

	@FindBy(xpath="//st-button[@type='button']")
	WebElement newTagButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Tag Name']")
	WebElement tagName;
	
	@FindBy(xpath="//input[@placeholder='Tag Value']")
	WebElement tagValue;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-branch-search/app-tag-detail/div/div[1]/button")
	WebElement closeTagScreen;
	
	//Intializing the page objects	
		public ManagePage(){
			PageFactory.initElements(driver, this);
		}
		public void clickManagetag(){
			newTagButton.click();
		}
		
		public void clickonSelectAffiliate(int arg)
		{
			selectContentfrmdrpdwn.get(arg).click();
		}
		
		public void closeCreateTagScreen(){
			closeTagScreen.click();
		}
		
		public void createNewTag(String tname, String tvalue) throws InterruptedException{
			clickDropdown.click();
			Thread.sleep(2000);
			clickonSelectAffiliate(0);
			tagName.sendKeys(tname);
			Thread.sleep(2000);
			tagValue.sendKeys(tvalue);
			Thread.sleep(3000);
			saveButon.click();
			
		}
	
	
	
	
	
	
	
}
