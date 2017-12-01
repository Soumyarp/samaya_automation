package com.samaya.qa.testcases.organisation;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.EmployeesPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;
import com.thoughtworks.selenium.webdriven.commands.CreateCookie;

import org.testng.annotations.Test;

public class EmployeesPageTest extends TestBase{
	
	TestUtil utility;
	
	
//	@BeforeMethod
//	public void setUp() throws InterruptedException{
//		initialization();
//		loginpage = new LoginPage();
//		employeesPage = new EmployeesPage();
//		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		homepage.clickOnOrganisation();
//		employeesPage=homepage.clickOnEmployeesLink();
//	}
	/*
	@Test(priority=1)
	public void verifyEmployeeLebel(){
		
		Assert.assertTrue(employeesPage.verifyEmployeeLebel(),);
	}*/
	
	@Test(priority=1)
	public void verifyEmployeeButton() throws InterruptedException, AWTException{
		LoginPage loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		EmployeesPage employeepage=new EmployeesPage();
		HomePage homepage=new HomePage();
		Thread.sleep(10000);
	//	homepage.scrollWindowDashPage();
		Thread.sleep(10000);
		homepage.clickOnOrganisation();
		homepage.clickOnEmployeesLink();
	//	Assert.assertTrue(employeespage.verifyEmployeeLebel(), "Employee lebel is missing on the page");
		employeepage.clickCreateEmployeeButton();
		Thread.sleep(1000);
		
		
		//employeespage.createEmployee();
		employeepage.clickAffiliateDropDown(2);
		Thread.sleep(2000);
		employeepage.selectAffiliateFromDropDown(0);
		Thread.sleep(2000);
		
		
		//employeepage.clickAccessProfileDropDown(7);
		//Thread.sleep(2000);
		//employeepage.selectAffiliateFromDropDown(2);
		Thread.sleep(1000);
		employeepage.clickBranchDropDown(3);
		Thread.sleep(2000);
		employeepage.selectBranchfromDropDown(0);
		employeepage.enterEmployeeName("test");
		employeepage.selectDateOfJoining();
		Thread.sleep(2000);
		employeepage.enterEmployeeID("12345");
		Thread.sleep(2000);
		employeepage.enterEnrollID("12345");
		TestUtil utility = new TestUtil();
		utility.scrollWindowPage();
		
		
		
		
		
		
		//employeepage.closeEmployeeCreateandEditPage();
		
		
		
	}


	
	
}
