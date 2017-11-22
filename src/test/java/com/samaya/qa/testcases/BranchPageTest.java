package com.samaya.qa.testcases;

import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.AffiliatePage;
import com.samaya.qa.pages.BranchesPage;
import com.samaya.qa.pages.HomePage;
import com.samaya.qa.pages.LoginPage;
import com.samaya.qa.util.TestUtil;

public class BranchPageTest extends TestBase {
	HomePage homepage;
	
	 BranchesPage branchpage;
	 TestUtil utility;
	 Properties prop;
	 
	 String sheetname = "Branch";
	 
	 @Test(priority=1)
		public void verifyBranchPage() throws InterruptedException{
		 LoginPage loginpage = new LoginPage();
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			 HomePage homepage=new HomePage();
			Thread.sleep(3000);
			homepage.clickOnOrganisation();
			homepage.clickOnBranchPage();
			BranchesPage branchpage= new BranchesPage();
			Thread.sleep(1000);
			branchpage.clickNewCreateBranch();
	 } 
	 @DataProvider
		public Object[][] getData(){
			Object data[][]=utility.getTestData(sheetname);
			return data;
			
			
		}
		
		@Test(priority=2,dataProvider="getData")
		public  void validateCreateBranch(String Branchname,String BranchAddress ) throws InterruptedException{
			branchpage.createNewBranch(Branchname, BranchAddress);
			//branchpage.closeCreateScreen();
			
		}
		
		@Test(priority=3)
		public void closeCreatePage() throws InterruptedException{
			
			branchpage.closeCreateScreen();
			Thread.sleep(3000);
			homepage.clickUsername();
			Thread.sleep(3000);
			homepage.clickLogoutButton(0);
			Thread.sleep(8000);
		}
		
		
	 
}
