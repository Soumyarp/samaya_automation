package com.samaya.qa.testcases.transactions;

import org.testng.annotations.Test;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.pages.transactions.TransactionPage;

public class CompoffPageTest extends TestBase{
	LoginPage loginpage;
	TransactionPage transactionpage;
	
	@Test
	public void verifyCompOffPage() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		transactionpage=new TransactionPage();
		transactionpage.clickOnTransactions();
		Thread.sleep(2000);
		transactionpage.clickOnCompoffLink();
		
		
		
	}
	
	

}
