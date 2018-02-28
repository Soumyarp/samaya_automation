package com.samaya.qa.testcases.organisation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.AffiliatePage;
import com.samaya.qa.pages.organisation.DepartmentPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class DepartmentpageTest extends TestBase {
	HomePage homepage;
	TestUtil utility;
	LoginPage loginpage;
	DepartmentPage departmentpage;
	
	
	String sheetname = "EmployeeType";
	

	
	@Test(priority=7)
	public void verifyDepartmentPage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
		homepage.clickOnDepartmentPage();
		departmentpage= new DepartmentPage();
		Thread.sleep(1000);
		departmentpage.clickDept();
		//departmentpage.clickonDropdown.click();
		
	}      
	
//	@Test(priority=2,dataProvider="getDataaaaa")
//	public  void validateDepartment(String DepartmentName) throws InterruptedException{
//		DepartmentPage departmentpage=new DepartmentPage();
//		departmentpage.createNewDept(DepartmentName);
//		
//		
//	}
//	@DataProvider
//	public Object[][] getDataaaaa(){
//		TestUtil utility=new TestUtil();
//		Object data[][]=TestUtil.getTestData("Department");
//		return data; 
//}
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=8,dataProvider="getData")
	public  void validateEmpType(String DepartmentName) throws InterruptedException{
		DepartmentPage departmentpage=new DepartmentPage();
		departmentpage.createNewDept(DepartmentName);
	}
	
	@Test(priority=9)
	public void logoutDepartmentScreen() throws InterruptedException{
		DepartmentPage departmentpage=new DepartmentPage();
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
		HomePage homepage=new HomePage();
		//departmentpage.closeCreateDeptScreen();
		homepage.clickUsername();
		Thread.sleep(3000);
		homepage.clickLogoutButton(2);
		Thread.sleep(10000);	
	}
 
}
