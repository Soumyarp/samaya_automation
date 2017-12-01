package com.samaya.qa.pages.organisation;

import java.util.ArrayList;
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
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-designation-search/app-designation-detail/div/div[1]/button")
	WebElement closeDesignScreen;
	

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
				
			/*	int ind=selectContentfrmdrpdwn.indexOf(affil)+1;
				selectContentfrmdrpdwn.get(ind).click();*/
			}
			
			public void closeDesignPage(){
				closeDesignScreen.click();
			}
			public void selcAffilatedropown()
			{
				clickonDropdown.click();
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
			public List getdropdownValues()
			{
				System.out.println(selectContentfrmdrpdwn.size());
				List<String> list=new ArrayList<String>();
				for(WebElement e:selectContentfrmdrpdwn)
				{
					list.add(e.getText());
				}
				return list;
				
			}

}
