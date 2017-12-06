package com.samaya.qa.testcases.organisation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HolidayPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class HolidayPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil utility;
	HolidayPage holidaypage;
	
	String sheetname = "Holiday";
	
	@Test(priority=1,dataProvider="getData")
	public void verifyHolidayPage(String HolidayName) throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnHolidayPage();
		holidaypage= new HolidayPage();
		Thread.sleep(1000);
		holidaypage.clickHolidayBtn();
		Thread.sleep(2000);
		holidaypage.clickAffiliateDropDown(1);
		Thread.sleep(1000);
		holidaypage.clickonSelectAffiliate(3);
		Thread.sleep(2000);
		holidaypage.enterHolidayName(HolidayName);
		Thread.sleep(2000);
		holidaypage.clickHolidayTypeDropDown(2);
		Thread.sleep(1000);
		holidaypage.clickonSelectHolidayType(1);
		Thread.sleep(1000);
		holidaypage.selectDateOfJoining();
		holidaypage.clickOnSaveBtn();
		
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	//@Test(priority=2,dataProvider="getData")
	public  void validateHoliday(String HolidayName) throws InterruptedException{
		holidaypage.enterHolidayName(HolidayName);
	}
	
	@Test(priority=2)
	public void logoutHolidayScreen() throws InterruptedException{
		holidaypage.closeCreateHolidayScreen();
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
