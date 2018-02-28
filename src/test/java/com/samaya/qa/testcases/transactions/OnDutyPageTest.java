package com.samaya.qa.testcases.transactions;

import javax.management.DescriptorKey;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.transactions.OnDutyPage;
import com.samaya.qa.pages.transactions.TransactionPage;

public class OnDutyPageTest extends TestBase {
	LoginPage loginpage;
	TransactionPage transactionpage;
	HomePage homepage;
	OnDutyPage odpage;
	
	@BeforeClass
	public void login()
	{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
	}
	
	@Test(priority=1,description="Employee -- Manager")
	public void applyingODByEmployee() throws InterruptedException{
		String expected="On Duty Application submitted successfully.";
		String Expected1="Approved Successfully";
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		Thread.sleep(2000);
		odpage.clickSelectODtype();
		Thread.sleep(2000);
		odpage.selectODType(1);
		Thread.sleep(2000);
		odpage.selectStartDate();
		Thread.sleep(2000);
		odpage.selectEndDate();
		Thread.sleep(2000);
		odpage.EnterReason("Testing Od");
		Thread.sleep(2000);
		odpage.clickOnSubmitButton();
		Thread.sleep(2000);
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		Thread.sleep(3000);
		homepage.clickUsername();
		Thread.sleep(3000);
		homepage.clickLogoutButton(2);
		Thread.sleep(10000);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("mgrusername"), prop.getProperty("mgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		Thread.sleep(2000);
		transactionpage.clickOnOnDutyLink();
		Thread.sleep(2000);
		transactionpage.clickPendingReporteestab();
		Thread.sleep(2000);
		transactionpage.pendingReporteesList(0);
		Thread.sleep(2000);
		transactionpage.clickActionButtons(0);
		Thread.sleep(2000);
		transactionpage.enterReasonMessage("Approving the OD submitted by employee");
		Thread.sleep(2000);
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		
	}
}
