package com.samaya.qa.pages.organisation;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.samaya.qa.base.TestBase;
import com.samaya.qa.util.TestUtil;
import com.samaya.qa.util.Xls_Reader;

public class DesignationPage extends TestBase {
 //public static String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\samaya\\qa\\testdata\\TestData.xlsx";
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newDesgnButton;
	
	@FindBy(xpath="//form/div[1]/st-dropdownlist/div/div/button")
	WebElement clickonDropdown;
	
	@FindBys({
		@FindBy(xpath="//form/div[1]/st-dropdownlist/div/ul/li/a")})
		List<WebElement> selectContentfrmdrpdwn;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement desgnName;
	
	@FindBy(xpath ="//button[contains(.,'SAVE')]")
    WebElement saveButon;
	
	@FindBy(xpath="//*[@id='appContentContainer']/div/app-designation-search/app-designation-detail/div/div[1]/button")
	WebElement closeDesignScreen;
	

	//Intializing the page objects	
			public DesignationPage(){
				PageFactory.initElements(driver, this);
			}
			public void clickDesignation(){
				newDesgnButton.click();
			}
			
			public void clickonSelectAffiliate(int arg)
			{
				selectContentfrmdrpdwn.get(arg).click();
				
			/*	int ind=selectContentfrmdrpdwn.indexOf(affil)+1;
				selectContentfrmdrpdwn.get(ind).click();*/
			}
			
			public void closeDesignPage(){
				closeDesignScreen.click();
			}
			public void selcAffilatedropown()
			{
				clickonDropdown.click();
				
			}
			
			
			public void createNewDesignation(String name) throws InterruptedException{
				clickonDropdown.click();
				Thread.sleep(2000);
				clickonSelectAffiliate(1);
				desgnName.sendKeys(name);
				Thread.sleep(2000);
				saveButon.click();
				Thread.sleep(1000);
			}
			public void getdropdownValues() throws InterruptedException
			{
				System.out.println(selectContentfrmdrpdwn.size());
				int values=selectContentfrmdrpdwn.size();
				
				
				
				//List<WebElement> list=new ArrayList<WebElement>();
				for(int i=1;i<values;i++)
				{
					selcAffilatedropown();
					Thread.sleep(3000);
					selectContentfrmdrpdwn.get(i).click();
					Thread.sleep(1000);
					String name=generatename();
					desgnName.sendKeys(name);
					
					saveButon.click();
					Thread.sleep(3000);
					
					
				}
			
				
			}
			public List<String> selectAffilatessss()
			{
				//selcAffilatedropown();
				List<String> l2=new ArrayList<String>();
				int values=selectContentfrmdrpdwn.size();
				for(int i=0;i<values;i++)
				{
					String actvalue=selectContentfrmdrpdwn.get(i).getText();
					l2.add(actvalue);
				}
		        
				return l2;	
			
				
			
			}
			public void selectAflt() throws InterruptedException
			{
				TestUtil utility=new TestUtil();
				List<String> exceldata=utility.getAllTestdatfrmExcel("Designation", "Affiliate");
				
			//	int values=selectContentfrmdrpdwn.size();
			//	for(int i=0;i<exceldata.size();i++)
				for(int j=1;j<selectContentfrmdrpdwn.size();j++)
				{
				for(int i=0;i<exceldata.size();i++)
				{
					
					if(exceldata.get(j).contains(selectContentfrmdrpdwn.get(i).getText()))
					{
					selcAffilatedropown();
						selectContentfrmdrpdwn.get(j).click();
						String name=generatename();
						desgnName.sendKeys(name);
						Thread.sleep(3000);
						saveButon.click();
						Thread.sleep(3000);
					break;
					}
				}
			}
			}	
			
		
				public String generatename()
				{
//					byte[] array = new byte[7]; // length is bounded by 7
		   
//				    String generatedString = new String(array, Charset.forName("UTF-8"));
					
					//return generatedString;
					char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
					StringBuilder sb = new StringBuilder();
					Random random = new Random();
					for (int i = 0; i < 8; i++) {
					    char c = chars[random.nextInt(chars.length)];
					    sb.append(c);
					}
					String output = sb.toString();
					return output;
					
					
				}
				public void passNametodesignaTextfield()
				{
					String name=generatename();
					desgnName.sendKeys(name);
				}
				public void clickOnSaveCTA()
				{
					saveButon.click();
				}
      
}
