package com.samaya.qa.pages.organisation;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.util.TestUtil;

public class BranchesPage extends TestBase{
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newBranchButton;
	
	@FindBy(xpath="//div[@class='dropdown']/div/button")
	WebElement clickDropdown;
	
	@FindBys({
	@FindBy(xpath="//div[1]/st-dropdownlist/div/ul/li")})
	List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Branch Name']")
	WebElement BranchName;
	
	@FindBy(xpath="//input[@placeholder='Branch Address']")
	WebElement branchaddressreftext;
	
	@FindBys( {
	    @FindBy(xpath = "//span[contains(text(),'Barcelona')]")})
		List<WebElement> branchAddress;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-branch-search/app-branch-detail/div/div[1]/button")
	WebElement closeCreateBranchScreen;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;	
	
	//Intializing the page objects	
	public BranchesPage(){
		PageFactory.initElements(driver, this);
	}
	public void clickNewCreateBranch(){
		newBranchButton.click();
	}
	
	public void clickonSelectAffiliate(int arg)
	{
		selectContentfrmdrpdwn.get(arg).click();
	}
	
	public void clickonAddress(int arg)
	{
		branchAddress.get(arg).click();
	}
	
	public void closeCreateScreen(){
		closeCreateBranchScreen.click();
	}
		
	public void createNewBranch(String brname, String braddr) throws InterruptedException{
		
			clickDropdown.click();
			Thread.sleep(2000);
			clickonSelectAffiliate(0);
			BranchName.sendKeys(brname);
			Thread.sleep(2000);
			branchaddressreftext.sendKeys(braddr);
			Thread.sleep(3000);
			clickonAddress(1);
			Thread.sleep(3000);
			saveButon.click();
			Thread.sleep(7000);
			
			
			
		}
	
	/*public void createNewBranchwithMultipledata(String brname, String braddr) throws InterruptedException{
		
			clickDropdown.click();
			Thread.sleep(2000);
			clickonSelectAffiliate(0);
			BranchName.sendKeys(brname);
			Thread.sleep(2000);
			branchaddressreftext.sendKeys(braddr);
			Thread.sleep(3000);
			clickonAddress(1);
			Thread.sleep(3000);
			saveButon.click();
			Thread.sleep(7000);
			//branchpage.closeCreateScreen();
			//branchpage.clickNewCreateBranch();
			TestUtil utility= new TestUtil();
			utility.pageRefresh();
			Thread.sleep(5000);*/
			
			
		}
		
	
	


