package com.samaya.qa.testcases.transactions;

import java.io.IOException;

import javax.management.DescriptorKey;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.transactions.OnDutyPage;
import com.samaya.qa.pages.transactions.TransactionPage;
import com.samaya.qa.util.TestUtil;

public class OnDutyPageTest extends TestBase {
	/*
	 * Actions 0 = Approve, 1= Decline 
	 * 
	 * 
	 */
	
	LoginPage loginpage;
	TransactionPage transactionpage;
	HomePage homepage;
	OnDutyPage odpage;
	TestUtil util;
	
	@BeforeMethod
	public void login()
	{
		LoginPage loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
	}
	/*----------------------------------------Employee->Manager (One Level)------------------------------------------------*/
	
//	@Test(priority=1,description="Employee -> Manager(Approving and Withdrawing the application)")
	public void applyingApproveODByEmployee() throws InterruptedException{
		String expected="On Duty Application submitted successfully.";
		String Expected1="Approved Successfully";
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("Approving the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.applicationListonEmployee();
		transactionpage.clickWithDrawButton();
		transactionpage.enterReasonMessage("Withdrawing approved record");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("Approving withdrawing record submitted by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
	//@Test(priority=2,description="Employee -> Manager(Declining Application)")
	public void applyingDeclineODByEmployee() throws InterruptedException{
		/*loginpage = new LoginPage();
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));*/
		
		String expected="On Duty Application submitted successfully.";
		String Expected1="Approved Successfully";
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		Thread.sleep(5000);
		odpage.selectStartDate();
    	odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(1);
		transactionpage.enterReasonMessage("Approving the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
   
	
	//@Test(priority=3,description="Employee -> Manager(Approving and Withdrawing the application By employee)")
	public void applyingWithdrawODByEmployee() throws InterruptedException{
		String expected="On Duty Application submitted successfully.";
		String Expected1="Approved Successfully";
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		transactionpage.applicationListonEmployee();
		transactionpage.clickWithDrawButton();
		transactionpage.enterReasonMessage("Withdrawing the submitted OD by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	
}

/*--------------------------------Employee->HR\Admin (One Level)-----------------------------------------------------------*/
	
	
//	@Test(priority=1,description="Employee -> HR(Approving and Withdrawing the application)")
	public void applyingApproveODByEmployeeToHR() throws InterruptedException{
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);	
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("hrusername"), prop.getProperty("hrpassword"));
		//loginpage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("Approving the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.applicationListonEmployee();
		transactionpage.clickWithDrawButton();
		transactionpage.enterReasonMessage("Withdrawing approved record");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("Approving withdrawing record submitted by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
	
	

	//@Test(priority=2,description="Employee -> HR/Admin(Declining Application by HR/Admin)")
	public void applyingDeclineODByEmployeeToHR() throws InterruptedException{
		/*loginpage = new LoginPage();
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));*/
		
		String expected="On Duty Application submitted successfully.";
		String Expected1="Approved Successfully";
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		Thread.sleep(5000);
		odpage.selectStartDate();
    	odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("hrusername"), prop.getProperty("hrpassword"));
		//loginpage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(1);
		transactionpage.enterReasonMessage("Approving the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
/*----------------------------Employee->Manager->Manager(Two level)-------------------------------------------*/	
	
	
	//@Test(priority=1,description="Employee -> Manager -> Manager(Approving and Withdrawing the application)")
	public void applyingApproveODByEmployeetoManager() throws InterruptedException{
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		loginpage = new LoginPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st manager Approved the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("secondmgrusername"), prop.getProperty("secondmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("2nd Manager Approved the OD submitted by 1st Manager");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.applicationListonEmployee();
		transactionpage.clickWithDrawButton();
		transactionpage.enterReasonMessage("Withdrawing approved record");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("Approving withdrawing record submitted by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
//	@Test(priority=1,description="Employee -> Manager -> Manager(Approving application)")
	public void approveODByManagers() throws InterruptedException{
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st manager Approved the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("secondmgrusername"), prop.getProperty("secondmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("2nd Manager Approved the OD submitted by 1st Manager");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
	
	//@Test(priority=1,description="Employee -> Manager -> Manager(Declining application By 2nd Manager)")
	public void declineODBy2ndManager() throws InterruptedException{
		loginpage = new LoginPage();
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st manager Approved the OD submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("secondmgrusername"), prop.getProperty("secondmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(1);
		transactionpage.enterReasonMessage("2nd Manager declined the submitted OD by 1st Manager");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
	
/*-----------------------------------Employee->Hr/admin->Hr/Admin-----------------------------------------------*/
	
	//@Test(priority=1,description="Employee -> HR/Admin-> HR/Admin(Approving application by HR/Admin)")
	public void approveODByHRorAdmins() throws InterruptedException{
		loginpage = new LoginPage();
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);	
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firsthrusername"), prop.getProperty("firsthrpassword"));
		//loginpage.login(prop.getProperty("firstadminusername"), prop.getProperty("firstadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st HR/Admin Approving the OD application submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(1000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("secondhrusername"), prop.getProperty("secondhrpassword"));
		//loginpage.login(prop.getProperty("secondadminusername"), prop.getProperty("secondadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("2nd HR/Admin Approving the OD application submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		
	}
	
	
	@Test(priority=1,description="Employee -> HR/Admin-> HR/Admin(Approving and Withdrawing application by HR/Admin)")
	public void approveandWithdrawODByHRorAdmins() throws InterruptedException, IOException{
		loginpage = new LoginPage();
		util=new TestUtil();
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);	
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
		util.takeScreenshotAtEndOfTest();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		//loginpage.login(prop.getProperty("firsthrusername"), prop.getProperty("firsthrpassword"));
		loginpage.login(prop.getProperty("firstadminusername"), prop.getProperty("firstadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st HR/Admin Approving the OD application submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		//loginpage.login(prop.getProperty("secondhrusername"), prop.getProperty("secondhrpassword"));
		loginpage.login(prop.getProperty("secondadminusername"), prop.getProperty("secondadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("2nd HR/AdminApproving the OD application submitted by employee");
		Thread.sleep(2000);
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("empusername"), prop.getProperty("emppassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.applicationListonEmployee();
		transactionpage.clickWithDrawButton();
		transactionpage.enterReasonMessage("Withdrawing approved record by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		loginpage.login(prop.getProperty("firstmgrusername"), prop.getProperty("firstmgrpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingReporteestab();
		transactionpage.pendingReporteesList(0);
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("manager approving withdrawing record submitted by employee");
		transactionpage.clickSubmitButton();
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
	}
	
	
	@Test(priority=2,description="Employee -> HR/Admin-> HR/Admin(Approving and declining application by 2ndlevelHR/Admin)")
	public void approveandDeclneODByHRorAdmins() throws InterruptedException{
		loginpage = new LoginPage();
		transactionpage=new TransactionPage();
		homepage = new HomePage();
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		odpage= new OnDutyPage();
		odpage.clickonApplyODButton();
		odpage.clickSelectODtype();
		odpage.selectODType(1);	
		odpage.selectStartDate();
		odpage.selectEndDate();
		odpage.EnterReason("Testing Od");
		odpage.clickOnSubmitButton();
	//	Assert.assertEquals(expected, odpage.getSuccessfullToastMessage());
	//	homepage.navigateToHomePage();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		//loginpage.login(prop.getProperty("firsthrusername"), prop.getProperty("firsthrpassword"));
		loginpage.login(prop.getProperty("firstadminusername"), prop.getProperty("firstadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(0);
		transactionpage.enterReasonMessage("1st HR/Admin Approving the OD application submitted by employee");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
		//loginpage.login(prop.getProperty("secondhrusername"), prop.getProperty("secondhrpassword"));
		loginpage.login(prop.getProperty("secondadminusername"), prop.getProperty("secondadminpassword"));
		Thread.sleep(2000);
		transactionpage.clickOnTransactions();
		transactionpage.clickOnOnDutyLink();
		transactionpage.clickPendingOthersTab();
		transactionpage.clickPendingOtherList();
		transactionpage.clickActionButtons(1);
		transactionpage.enterReasonMessage("2nd HR/Admin Declining the OD application approved by 1st Hr/Admin");
		transactionpage.clickSubmitButton();
	//	Assert.assertEquals(Expected1,transactionpage.clickOkayButton() );
		Thread.sleep(2000);
		transactionpage.clickOkayButton();
		homepage.clickUsername();
		homepage.clickLogoutButton(2);
}















}