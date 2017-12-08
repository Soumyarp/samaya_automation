package com.samaya.qa.testcases.policymanagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.policymanagement.PolicyManagementPage;

public class TestWorkHourPolicy extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	PolicyManagementPage policymanagementpage;
	
	@Test
	public void verifyLeavePolicyPage() throws InterruptedException{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		policymanagementpage = new PolicyManagementPage();
		policymanagementpage.clickOnPolicyManagement();
		Thread.sleep(2000);
		policymanagementpage.clickOnWorkHourPolicy();
		
		
		
		
	}

}
