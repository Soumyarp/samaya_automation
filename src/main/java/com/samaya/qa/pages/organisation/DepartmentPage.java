package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;

public class DepartmentPage extends TestBase{
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newDeptButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickonDropdown;
	
	@FindBys({
		@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement deptName;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-department-search/app-department-details/div/div[1]/button")
	WebElement closeCreatDeptScreen;
	

	//Intializing the page objects	
			public DepartmentPage(){
				PageFactory.initElements(driver, this);
			}
			public void clickDept(){
				newDeptButton.click();
			}
			
			public void clickonSelectAffiliate(int arg)
			{
				selectContentfrmdrpdwn.get(arg).click();
				
				
			}
			
			public void closeCreateDeptScreen(){
				closeCreatDeptScreen.click();
			}
			public void clickAffilateDropdown()
			{
				clickonDropdown.click();
			}
			
			public void createNewDept(String name) throws InterruptedException{
				System.out.println("Cooming to here");
				clickonDropdown.click();
				Thread.sleep(2000);
				clickonSelectAffiliate(1);
				deptName.sendKeys(name);
				Thread.sleep(2000);
				saveButon.click();
				Thread.sleep(7000);
				//closeCreateDeptScreen();
				
			}

}
