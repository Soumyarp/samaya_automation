package com.samaya.qa.testcases.organisation;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.DepartmentPage;
import com.samaya.qa.pages.organisation.DesignationPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;

public class DesignationPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil utility;
	DesignationPage designationpage;
	
	String sheetname = "Designation";
	
	@Test(priority=7,enabled=true)
	public void verifyDesignationPage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		Thread.sleep(2000);
		homepage.clickOnOrganisation();
     	homepage.clickOnDesignationPage();
		designationpage= new DesignationPage();
    	Thread.sleep(1000);
		designationpage.clickDesignation();;
	}      
	@DataProvider
	public Object[][] getData(){
		Object data[][]=utility.getTestData(sheetname);
		return data;
}
	@Test(priority=8,dataProvider="getData",enabled=true)
	public  void validateDesign(String Designationname) throws InterruptedException{
		designationpage.createNewDesignation(Designationname);
	}
	
	@Test(priority=9,enabled=true)
	public void logoutDesignScreen() throws InterruptedException{
		designationpage.closeDesignPage();
		Thread.sleep(2000);
	//	homepage.clickOnOrganisation();
	//	Thread.sleep(2000);
	//	homepage.clickOnAffiliatePage();
	//	Thread.sleep(2000);
		
		
	}
//	@Test(priority=10,enabled=false)
	public void valiateaffilateptions() throws InterruptedException{
		//String str[]={"Tata Food","Tata Medical","TATA Motors"};
		List<String> l1=new ArrayList<String>();
		homepage.clickOnOrganisation();
		homepage.clickOnDesignationPage();
		designationpage= new DesignationPage();
		Thread.sleep(1000);
		designationpage.clickDesignation();
		Thread.sleep(1000);
		designationpage.selcAffilatedropown();
		
		designationpage.clickonSelectAffiliate(0);
		designationpage.passNametodesignaTextfield();
		designationpage.clickOnSaveCTA();
		Thread.sleep(2000);
		designationpage.getdropdownValues();
		//Assert.assertTrue(str[i].contains(values.get(i)));
		
	}
	
//	@Test(priority=10)
	public void validateAffilatewithExceldta() throws InterruptedException
	{
		TestUtil utility=new TestUtil();
		List<String> exceldata=utility.getAllTestdatfrmExcel(sheetname, "Affiliate");
		System.out.println(exceldata.size());
		homepage.clickOnOrganisation();
		homepage.clickOnDesignationPage();
		designationpage= new DesignationPage();
		Thread.sleep(1000);
		designationpage.clickDesignation();
		Thread.sleep(1000);
		designationpage.selcAffilatedropown();
		designationpage.clickonSelectAffiliate(0);
		designationpage.passNametodesignaTextfield();
		designationpage.clickOnSaveCTA();
		Thread.sleep(2000);
		//List<String> afilatess=designationpage.selectAffilatessss();
		designationpage.selectAflt();
		
		
		
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
