package com.samaya.qa.testcases.organisation;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.AffiliatePage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class AffiliatePageTest extends TestBase{
	 HomePage homepage;
	 LoginPage loginpage;
	 AffiliatePage affiliatepage;
	 
	 
	 String sheetname = "Affiliate";
	
	@BeforeClass
	public void login()
	{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyAffilitePage() throws InterruptedException{
		
		homepage=new HomePage();
//		LoginPage loginpage = new LoginPage();
//		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnOrganisation();
		homepage.clickOnAffiliatePage();
		affiliatepage= new AffiliatePage();
		Thread.sleep(1000);
		affiliatepage.clickCreateAffiliateButton();
		System.out.println("hi this is for Git ");
		
	}
	@DataProvider
	public Object[][] getData(){
		TestUtil utility=new TestUtil();
		
		Object data[][]=utility.getTestData(sheetname);
		return data;
		
		
	}
	
	@Test(priority=2,dataProvider="getData")
	public  void validateCreateAffiliate(String Name, String Phoneno,String Address ) throws InterruptedException{
		affiliatepage.createNewAffiliate(Name, Phoneno, Address);
		
	}
	
	@Test(priority=3)
	public void closeCreatePage() throws InterruptedException{
		
		affiliatepage.closeCreateAffiliateScreen();;
		Thread.sleep(2000);
	//homepage.clickUsername();
	//	Thread.sleep(3000);
//		homepage.clickLogoutButton(0);
//		Thread.sleep(10000);
		
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
