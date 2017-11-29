package com.samaya.qa.testcases.transactions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.transactions.CompoffPage;
import com.samaya.qa.pages.transactions.TransactionPage;

public class CompoffPageTest extends TestBase{
	LoginPage loginpage;
	TransactionPage transactionpage;
	CompoffPage cp;
	HomePage homepage;
	
	@BeforeClass
	public void login()
	{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyCompOffPageusingBehalf() throws InterruptedException{
		//loginpage = new LoginPage();
		//loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		transactionpage=new TransactionPage();
		CompoffPage cp=new CompoffPage();
		transactionpage.clickOnTransactions();
		Thread.sleep(2000);
		transactionpage.clickOnCompoffLink();
		cp.clickOnNewCompoffbtn();
		cp.clickonOnbehalfchkBox();
		String empID=cp.displayEmployeeList(1);
		System.out.println(empID);
		cp.selectEmployee(2);
		cp.clickonOnearnCompoffRadioBtn();
		Thread.sleep(2000);
		cp.selectStartDate();
		cp.selectEndDate();
		cp.EnterReason();
		cp.clickOnSaveCTA();
	//	driver.navigate().back();
		Thread.sleep(10000);
		/*String compOffapgeempID=cp.clkOnFirstRowofcomPffDashbrd(0);
		System.out.println(compOffapgeempID);
	//	Assert.assertEquals(compOffapgeempID, empID);
*/		
	}
	

	@Test(priority=2)
	public void verifyCompOffPagewithOutBehalf() throws InterruptedException{
	//	loginpage = new LoginPage();
	//	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		transactionpage=new TransactionPage();
		CompoffPage cp=new CompoffPage();
//		transactionpage.clickOnTransactions();
		Thread.sleep(2000);
	//	transactionpage.clickOnCompoffLink();
	//	cp.clickOnNewCompoffbtn();
	//	cp.clickonOnbehalfchkBox();
	//	String empID=cp.displayEmployeeList(1);
	//	System.out.println(empID);
	//	cp.selectEmployee(1);
		Thread.sleep(3000);
		cp.clickonOnearnCompoffRadioBtn();
		Thread.sleep(2000);
		cp.selectStartDate();
		cp.selectEndDate();
		cp.EnterReason();
		cp.clickOnSaveCTA();
		driver.navigate().back();
		Thread.sleep(2000);
		/*String compOffapgeempID=cp.clkOnFirstRowofcomPffDashbrd(0);
		System.out.println(compOffapgeempID);
	//	Assert.assertEquals(compOffapgeempID, empID);
		*/
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
