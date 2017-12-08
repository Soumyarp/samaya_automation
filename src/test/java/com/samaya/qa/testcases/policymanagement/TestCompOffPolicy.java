package com.samaya.qa.testcases.policymanagement;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.policymanagement.CompOffPolicy;
import com.samaya.qa.pages.policymanagement.PolicyManagementPage;
import com.samaya.qa.util.TestUtil;

public class TestCompOffPolicy extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	PolicyManagementPage policymanagementpage;
	CompOffPolicy compoffpolicy;
	TestUtil utility;
	
   // @Test
	public void verifyCompoffPolicyPage() throws InterruptedException{
		loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		policymanagementpage = new PolicyManagementPage();
		compoffpolicy = new CompOffPolicy();
		policymanagementpage.clickOnPolicyManagement();
		Thread.sleep(2000);
		policymanagementpage.clickOnCompoffPolicy();
		Thread.sleep(2000);
		compoffpolicy.clickOnNewCompoffPolicybtn();
		Thread.sleep(2000);
		compoffpolicy.clickOnDropDown(0);
		//Thread.sleep(5000);
		compoffpolicy.clickSelectAffiliate(4);
		compoffpolicy.clickSelectAffiliate(4);
		//compoffpolicy.clickSelectAffiliate();
		//compoffpolicy.clickSelectAffiliate();
		Thread.sleep(4000);
		compoffpolicy.EnterPolicyName(prop.getProperty("policyname"));
		Thread.sleep(2000);
		compoffpolicy.EnterEffectiveDate();
		Thread.sleep(1000);
		compoffpolicy.clickOnCompoffCreditRadioButton(0);
		Thread.sleep(2000);
		compoffpolicy.clickOncompOffOTRadioBtn(0);
		Thread.sleep(1000);
		compoffpolicy.EnterCreditCompoff("1");
		Thread.sleep(1000);
		compoffpolicy.clickOnhourPicker("11");
		compoffpolicy.clickOnMinutePicker("45");
		Thread.sleep(2000);
		
		compoffpolicy.clickOnvalidityRadioButton(1);
		compoffpolicy.clickOnSaveAsDraftBtn();
	}
	/*presence on non working days without using prior*/
	@Test
	public void verifyPresenceOnNonWorkingDayswithoutUsingPrior() throws InterruptedException, AWTException{
		utility = new TestUtil();
		loginpage = new LoginPage();
     	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		policymanagementpage = new PolicyManagementPage();
		compoffpolicy = new CompOffPolicy();
		policymanagementpage.clickOnPolicyManagement();
		Thread.sleep(2000);
		policymanagementpage.clickOnCompoffPolicy();
		Thread.sleep(2000);
		compoffpolicy.clickOnNewCompoffPolicybtn();
		Thread.sleep(2000);
		compoffpolicy.clickOnDropDown(0);
		Thread.sleep(5000);
		compoffpolicy.clickSelectAffiliate(4);
		compoffpolicy.clickSelectAffiliate(4);
		Thread.sleep(4000);
		compoffpolicy.EnterPolicyName(prop.getProperty("policyname"));
		Thread.sleep(2000);
		compoffpolicy.EnterEffectiveDate();
		Thread.sleep(1000);
		compoffpolicy.clickOnCompoffCreditRadioButton(1);
		Thread.sleep(5000);
		compoffpolicy.clickOnCompoffCreditType(0);
		
		compoffpolicy.clickOnHolidayCheckBox();
		Thread.sleep(3000);
		compoffpolicy.clickOnDateTimePicker(1);
		Thread.sleep(2000);
		compoffpolicy.clickOnhourPicker("11");
		Thread.sleep(2000);
		compoffpolicy.clickOnMinutePicker("45");
		utility.backSpace();
		Thread.sleep(2000);
		compoffpolicy.clickOnMinutePicker("45");
		
		
		
	}
	
	

}
