package com.samaya.qa.testcases.organisation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.DesignationPage;
import com.samaya.qa.pages.organisation.EmpTypePage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class EmpTypePageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	TestUtil utility;
	EmpTypePage emptypepage;
	
	String sheetname = "EmployeeType";
	
	@Test(priority=16)
	public void verifyDesignationPage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnEmpTypePage();
		emptypepage= new EmpTypePage();
		Thread.sleep(1000);
		emptypepage.clickEmptype();
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=17,dataProvider="getData")
	public  void validateEmpType(String EmpCategoryName) throws InterruptedException{
		emptypepage.createNewEmpType(EmpCategoryName);
	}
	
	@Test(priority=18)
	public void logoutDesignScreen() throws InterruptedException{
		emptypepage.closeCreateEmpTypeScreen();
		Thread.sleep(2000);
	//	homepage.clickOnOrganisation();
	//	Thread.sleep(2000);
	//	homepage.clickOnAffiliatePage();
	//	Thread.sleep(2000);
		
		
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
