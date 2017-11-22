package com.samaya.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.DepartmentPage;
import com.samaya.qa.pages.DesignationPage;
import com.samaya.qa.pages.HomePage;
import com.samaya.qa.pages.LoginPage;
import com.samaya.qa.util.TestUtil;

public class DesignationPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil utility;
	DesignationPage designationpage;
	
	String sheetname = "Designation";
	
	@Test(priority=1)
	public void verifyDesignationPage() throws InterruptedException{
	//	loginpage = new LoginPage();
	//	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		homepage.clickOnOrganisation();
		homepage.clickOnDepartmentPage();
		designationpage= new DesignationPage();
		Thread.sleep(1000);
		designationpage.clickDesignation();;
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=2,dataProvider="getData")
	public  void validateDepartment(String Designationname) throws InterruptedException{
		designationpage.createNewDesignation(Designationname);
	}
	
}
