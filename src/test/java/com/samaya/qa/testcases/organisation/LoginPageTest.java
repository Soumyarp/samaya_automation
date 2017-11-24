package com.samaya.qa.testcases.organisation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;

public class LoginPageTest extends TestBase{
	
	@Test(priority=1)
	public void loginpageTitleTest() throws InterruptedException{
		Thread.sleep(1000);
		LoginPage loginpage=new LoginPage();
		String title= loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Securtime - SecurAX Tech Solutions");
	}
	@Test(priority=2)
	public void logoImageTest(){
		LoginPage loginpage=new LoginPage();
		boolean flag=loginpage.validateLogo();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		Thread.sleep(1000);
		LoginPage loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String actUrl=loginpage.verifyDashboardPage();
	    String expUrl=prop.getProperty("dashbordurl");
	    Assert.assertEquals(expUrl, actUrl,"User not in Dashboard Page");
	    Thread.sleep(2000);
	    
	    
		 
		
	}
	
	
	
}
