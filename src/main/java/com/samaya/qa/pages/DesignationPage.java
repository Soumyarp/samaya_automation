package com.samaya.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class DesignationPage extends TestBase {
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newDesgnButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickonDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement desgnName;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	

	//Intializing the page objects	
			public DesignationPage(){
				PageFactory.initElements(driver, this);
			}
			public void clickDesignation(){
				newDesgnButton.click();
			}
			
			public void clickonSelectAffiliate(int arg)
			{
				selectContentfrmdrpdwn.get(arg).click();
			}
			
			public void createNewDesignation(String name) throws InterruptedException{
				clickonDropdown.click();
				Thread.sleep(2000);
				clickonSelectAffiliate(1);
				desgnName.sendKeys(name);
				Thread.sleep(2000);
				saveButon.click();
				Thread.sleep(1000);
			}

}
