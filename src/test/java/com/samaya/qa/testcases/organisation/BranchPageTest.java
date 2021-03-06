package com.samaya.qa.testcases.organisation;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.AffiliatePage;
import com.samaya.qa.pages.organisation.BranchesPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class BranchPageTest extends TestBase {
	 HomePage homepage;
	 LoginPage loginpage;
	 BranchesPage branchpage;
	 TestUtil utility;
	 
	 String sheetname = "Branch";
	 

	 @Test(priority=4)
		public void verifyBranchPage() throws InterruptedException{
		    loginpage = new LoginPage();
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			HomePage homepage=new HomePage();
			Thread.sleep(3000);
			homepage.clickOnOrganisation();
			homepage.clickOnBranchPage();
			branchpage= new BranchesPage();
			Thread.sleep(1000);
			branchpage.clickNewCreateBranch();
	 } 
	 @DataProvider
		public Object[][] getData(){
			Object data[][]=utility.getTestData(sheetname);
			return data;
			
			
		}
		
		@Test(priority=5,dataProvider="getData")
		public  void validateCreateBranch(String Branchname,String BranchAddress ) throws InterruptedException{
			branchpage.createNewBranch(Branchname, BranchAddress);
			//branchpage.closeCreateScreen();
			
		}
		
		@Test(priority=6)
		public void logoutBranchScreen() throws InterruptedException{
			branchpage.closeCreateScreen();
			Thread.sleep(2000);
		//	homepage.clickOnOrganisation();
		//	Thread.sleep(2000);
		//	homepage.clickOnAffiliatePage();
		//	Thread.sleep(2000);
			
			
		}
		
		@AfterClass
		public void logout() throws InterruptedException
		{
			HomePage homePage=new HomePage();
			
			homePage.clickUsername();
			Thread.sleep(3000);
			homePage.clickLogoutButton(2);
			Thread.sleep(10000);	
		}

		
	 
}
