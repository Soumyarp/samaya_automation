package com.samaya.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.BranchesPage;
import com.samaya.qa.pages.HomePage;
import com.samaya.qa.pages.LoginPage;
import com.samaya.qa.pages.ManagePage;
import com.samaya.qa.util.TestUtil;

public class ManageTagPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	ManagePage managepage;
	TestUtil utility;
	
	String sheetname = "ManageTags";
	
	@Test(priority=10)
	public void verifyManagePage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnManageTagPage();
		managepage= new ManagePage();
		Thread.sleep(1000);
        managepage.clickManagetag();
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=11,dataProvider="getData")
	public  void validateManageTag(String TagName,String TagValue ) throws InterruptedException{
		managepage.createNewTag(TagName, TagValue);
	}
	
	@Test(priority=12)
	public void logoutManageScreen() throws InterruptedException{
		managepage.closeCreateTagScreen();
		Thread.sleep(2000);
	//	homepage.clickOnOrganisation();
	//	Thread.sleep(2000);
	//	homepage.clickOnAffiliatePage();
	//	Thread.sleep(2000);
		
		
	}
	@AfterClass
	public void logout() throws InterruptedException
	{
		homepage.clickUsername();
		Thread.sleep(3000);
		homepage.clickLogoutButton(0);
		Thread.sleep(10000);	
	}
}
