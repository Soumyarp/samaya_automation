package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.util.TestUtil;

public class AffiliatePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Affiliates ')]")
	WebElement affiliateLebel;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement affiliateButton;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement affiliateName;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	WebElement Phonenumber;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	WebElement addressreftext;
	
	@FindBys( {
    @FindBy(xpath = "//span[contains(text(),'Bangalore')]")})
	List<WebElement> Address;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-affiliate-search/app-affiliate-detail/div/div[1]/button")
	WebElement closeCreateAffiliateBranchScreen;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	
	
	
	//Intializing the page objects	
			public AffiliatePage(){
				PageFactory.initElements(driver, this);
			}

			public void clickCreateAffiliateButton(){
				affiliateButton.click();
				
			}
			public void clickonAddress(int arg)
			{
				Address.get(arg).click();
			}
			
			public void closeCreateAffiliateScreen(){
				closeCreateAffiliateBranchScreen.click();
			}
			
			public void createNewAffiliate(String name, String phoneno,String addr) throws InterruptedException{
				affiliateName.sendKeys(name);
				Thread.sleep(1000);
				Phonenumber.sendKeys(phoneno);
				Thread.sleep(1000);
				addressreftext.sendKeys(addr);
				Thread.sleep(2000);
				clickonAddress(0);
				saveBtn.click();
				Thread.sleep(2000);
				/*TestUtil utility= new TestUtil();
				utility.pageRefresh();*/
			}
}
