package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class EmpTypePage extends TestBase{
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newEmpTypeButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickonDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Category Name']")
	WebElement empCategoryName;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-employment-category-search/app-employment-category-detail/div/div[1]/button")
	WebElement closeCreateEmpTypeScreen;
	

	//Intializing the page objects	
			public EmpTypePage(){
				PageFactory.initElements(driver, this);
			}
			
			public void clickEmptype(){
				newEmpTypeButton.click();
			}
			
			public void clickonSelectAffiliate(int arg)
			{
				selectContentfrmdrpdwn.get(arg).click();
			}
			
			public void closeCreateEmpTypeScreen(){
				closeCreateEmpTypeScreen.click();
			}
			
			public void createNewEmpType(String catgoryname) throws InterruptedException{
				clickonDropdown.click();
				Thread.sleep(2000);
				clickonSelectAffiliate(1);
				empCategoryName.sendKeys(catgoryname);
				Thread.sleep(2000);
				saveButon.click();
				Thread.sleep(7000);
				
			}
			
			
	
	

}
