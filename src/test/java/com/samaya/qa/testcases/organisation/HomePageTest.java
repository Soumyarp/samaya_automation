package com.samaya.qa.testcases.organisation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.EmployeesPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	 HomePage homepage;
	 LoginPage loginpage;
	 TestUtil utility;
	 
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException{
		String expected_title="Securtime - SecurAX Tech Solutions";
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, expected_title,"Home page title not matched");
		Assert.assertTrue(homepage.verifyUsername(),"Username label not matched");
		homepage.clickOnOrganisation();
		Thread.sleep(2000);
		homepage.clickOnEmployeesLink();
		Thread.sleep(1000);
		String actUrl=homepage.verifyEmployeePageUrl();
	    String expUrl=prop.getProperty("employeepageurl");
	    Assert.assertEquals(expUrl, actUrl,"User not in Employee Page");
	    Thread.sleep(2000);
		
		
	}
	@Test(priority=2)
	public void goToAffilatePage() throws InterruptedException{
		/*if (loginpage.verifyDashboardPage()!= homepage.verifyEmployeePageUrl()) {
			homepage.navigateToHomePage();
		}*/
		
		String expected_title="Securtime - SecurAX Tech Solutions";
		homepage = new HomePage();
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, expected_title,"Home page title not matched");
		Assert.assertTrue(homepage.verifyUsername(),"Username label not matched");
		homepage.clickOnOrganisation();
		Thread.sleep(2000);
		homepage.clickOnAffiliatePage();
		Thread.sleep(1000);
		String actUrl=homepage.VerifyAffiliatePageUrl();
	    String expUrl=prop.getProperty("affiliatepageurl");
	    Assert.assertEquals(expUrl, actUrl,"User not in Affiliate Page");
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void goToBranchPage() throws InterruptedException{
		/*if (loginpage.verifyDashboardPage()!=homepage.VerifyAffiliatePageUrl()) {
			homepage.navigateToHomePage();
		}*/
		
		
		String expected_title="Securtime - SecurAX Tech Solutions";
		homepage = new HomePage();
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, expected_title,"Home page title not matched");
		Assert.assertTrue(homepage.verifyUsername(),"Username label not matched");
		homepage.clickOnOrganisation();
		Thread.sleep(2000);
		homepage.clickOnBranchPage();
		Thread.sleep(1000);
		String actUrl=homepage.VerifyBranchPageUrl();
	    String expUrl=prop.getProperty("branchpageurl");
	    Assert.assertEquals(expUrl, actUrl,"User not in Branch Page");
		
	}
	/*@Test(priority=4)
	public void goToManageTagPage() throws InterruptedException{
		if (loginpage.verifyDashboardPage()!=homepage.VerifyBranchPageUrl()) {
			homepage.navigateToHomePage();
		}
		
		String expected_title="Securtime - SecurAX Tech Solutions";
		homepage = new HomePage();
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, expected_title,"Home page title not matched");
		Assert.assertTrue(homepage.verifyUsername(),"Username label not matched");
		homepage.clickOnOrganisation();
		Thread.sleep(2000);
		homepage.click();
		Thread.sleep(1000);
		String actUrl=homepage.VerifyManageTagsPageUrl();
	    String expUrl=prop.getProperty("managetag");
	    Assert.assertEquals(expUrl, actUrl,"User not in Manage Tag Page");
		
	}*/
	
	
	
	
	
	
	
	/*@Test(priority=2)
	public void verifyEmployeeLinkTest() throws InterruptedException{
		Thread.sleep(2000);
		HomePage homepage = new HomePage();
		EmployeesPage employeespage = new EmployeesPage();
		homepage.clickOnOrganisation();
		Thread.sleep(2000);
		homepage.clickOnEmployeesLink();
		
	}*/
	

}
