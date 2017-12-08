package com.samaya.qa.testcases.policymanagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.policymanagement.PolicyManagementPage;

public class TestLeavePolicy extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	PolicyManagementPage policymanagementpage;
	
	@BeforeClass
	public void login()
	{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyLeavePolicyPage() throws InterruptedException{
		
		policymanagementpage = new PolicyManagementPage();
		policymanagementpage.clickOnPolicyManagement();
		Thread.sleep(2000);
		policymanagementpage.clickOnLeavePolicy();
		
		
		
		
	}
	

}
