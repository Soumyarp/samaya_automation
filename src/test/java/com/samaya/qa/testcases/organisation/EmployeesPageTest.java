package com.samaya.qa.testcases.organisation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.EmployeesPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.thoughtworks.selenium.webdriven.commands.CreateCookie;

import org.testng.annotations.Test;

public class EmployeesPageTest extends TestBase{
	
	
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
	public void verifyEmployeeButton() throws InterruptedException{
		LoginPage loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		EmployeesPage employeespage=new EmployeesPage();
		HomePage homepage=new HomePage();
		homepage.clickOnOrganisation();
		homepage.clickOnEmployeesLink();
		Assert.assertTrue(employeespage.verifyEmployeeLebel(), "Employee lebel is missing on the page");
		employeespage.clickCreateEmployeeButton();
		Thread.sleep(1000);
		employeespage.createEmployee();
	}


	
	
}
