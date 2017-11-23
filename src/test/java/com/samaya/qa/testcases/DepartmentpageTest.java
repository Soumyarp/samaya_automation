package com.samaya.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.AffiliatePage;
import com.samaya.qa.pages.DepartmentPage;
import com.samaya.qa.pages.HomePage;
import com.samaya.qa.pages.LoginPage;
import com.samaya.qa.pages.ManagePage;
import com.samaya.qa.util.TestUtil;

public class DepartmentpageTest extends TestBase {
	HomePage homepage;
	TestUtil utility;
	DepartmentPage departmentpage;
	
	
	String sheetname = "Department";
//	@BeforeClass
//	public void login()
//	{
//		LoginPage loginpage = new LoginPage();
//     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	@Test(priority=4)
	public void verifyDepartmentPage() throws InterruptedException{
		LoginPage loginpage = new LoginPage();
		System.out.println("second class file");
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TestUtil utility=new TestUtil();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		
		//utility.loginAgn("admin@tcs.com", "admin");
      Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnDepartmentPage();
		departmentpage= new DepartmentPage();
		Thread.sleep(1000);
		departmentpage.clickDept();
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data; 
}
	@Test(priority=5,dataProvider="getData")
	public  void validateDepartment(String DeptName ) throws InterruptedException{
		departmentpage.createNewDept(DeptName);
		
	}
	
	@Test(priority=6)
	public void logoutDepartmentScreen() throws InterruptedException{
		departmentpage.closeCreateDeptScreen();
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
