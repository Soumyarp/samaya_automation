package com.samaya.qa.testcases;

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
	
	@Test(priority=1)
	public void verifyAffilitePage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
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
	@Test(priority=2,dataProvider="getData")
	public  void validateManageTag(String TagName,String TagValue ) throws InterruptedException{
		managepage.createNewTag(TagName, TagValue);
	}
	
}
