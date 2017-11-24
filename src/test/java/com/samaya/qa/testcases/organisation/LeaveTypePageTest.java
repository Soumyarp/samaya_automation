package com.samaya.qa.testcases.organisation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LeaveTypePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.organisation.ManagePage;
import com.samaya.qa.util.TestUtil;

public class LeaveTypePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil utility;
	LeaveTypePage leavetypepage;
	
	String sheetname = "LeaveType";
	
	@Test(priority=13)
	public void verifyManagePage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnLeaveTypePage();
		leavetypepage= new LeaveTypePage();
		Thread.sleep(1000);
		leavetypepage.clickLeaveType();
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=14,dataProvider="getData")
	public  void validateLeaveType(String LeaveName,String LeaveAbbrevation ) throws InterruptedException{
		leavetypepage.createNewLeaveType(LeaveName, LeaveAbbrevation);;
	}
	
	@Test(priority=15)
	public void logoutManageScreen() throws InterruptedException{
		leavetypepage.closeLeaveTypeScreen();
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
