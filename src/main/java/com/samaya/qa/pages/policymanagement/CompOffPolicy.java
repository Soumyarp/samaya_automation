package com.samaya.qa.pages.policymanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.samaya.qa.base.TestBase;

public class CompOffPolicy extends TestBase{
	
	@FindBy(xpath="//st-button[@type='button']")
	WebElement newCompoffPolicyButton;
	
	@FindBys({@FindBy(xpath="//div/st-dropdownlist/div/div/button")})
	List<WebElement> clickDropdown;
	
	@FindBys({
	@FindBy(xpath="//form/div[2]/div[2]/div[1]/st-dropdownlist/div/ul/li/a")})
	List<WebElement> selectContentfrmAffiliatedropdown;
	
	@FindBy(xpath="//form/div[2]/div[2]/div[1]/st-dropdownlist/div/ul/li[5]/a")
	WebElement affilate;
	
	@FindBy(xpath="//input[@placeholder='Policy Name']")
	WebElement policyName;
	
	@FindBy(xpath="//input[@placeholder='Effective Date']")
	WebElement policyEffectiveDate;
	
	@FindBy(xpath="//td[@data-day='12/08/2017']")
	WebElement selPolicyEffectiveDate;
	
	@FindBys
	({@FindBy(xpath="//input[@formcontrolname='compOffCredit']")})
	List<WebElement> creditCompoffRadioButton;

	@FindBys
	({@FindBy(xpath="//input[@formcontrolname='validityType']")})
	List<WebElement> validityRadioButton;
	
	@FindBy(xpath="//st-input[@formcontrolname='earnedCompOffLimit']/div/input")
	WebElement earnedCompOffLimit;
	
	@FindBy(xpath="//st-input[@formcontrolname='availedCompOffLimit']/div/input")
	WebElement availedCompOffLimit;
	
	@FindBy(xpath="//form/div[2]/div[7]/app-ot-rule/div/div[6]/div[4]/st-time/div/input")
	WebElement hourPickerTextBox;
	
	//@FindBy(xpath="//table/tbody/tr[2]/td[1]/input[@type='text']")
	@FindBy(xpath="//input[@class='bootstrap-timepicker-hour']")
	WebElement timePicker;
	
	//@FindBy(xpath="//table/tbody/tr[2]/td[3]/input[@type='text']")
	@FindBy(xpath="//tr/td/input[@class='bootstrap-timepicker-minute']")
	WebElement minutePicker;
	
	@FindBys({@FindBy(xpath="//div/div/st-time/div/input")})
	List <WebElement> dateTimePicker;
	
//************************************OverTimeHours Webobjects*****************************************************//
	
	@FindBys({@FindBy(xpath="//input[@formcontrolname='compOffOTFrequency']")})
	List <WebElement> compOffOT ;
	
	@FindBy(xpath="//st-input[@formcontrolname='noOfCompOffs']/div/input")
	WebElement creditNoOfCompoff;
	
	@FindBy(xpath="//st-time[@formcontrolname='otThreshold']/div/input")
	WebElement otThreshold;
	
//	@FindBy(xpath="//button[contains(.,'Start of Week')]")
//	WebElement startOFWeekdropdwn;
	
	@FindBys({@FindBy(xpath="//div[@class='dropdown open']/ul/li/a")})
	List<WebElement> weekDaysStart;
	
	@FindBys({@FindBy(xpath="//div[@class='dropdown open']/ul/li/a")})
	List<WebElement> weekDaysEnd;
	
	@FindBys({@FindBy(xpath="//div[@class='dropdown open']/ul/li/a")})
	List<WebElement> MonthDaysStart;
	
	@FindBys({@FindBy(xpath="//div[@class='dropdown open']/ul/li/a")})
	List<WebElement> MonthDaysEnd;
	
//	@FindBy(xpath="//button[contains(.,'End of Week')]")
//	WebElement endOFWeekdropdwn;
	
//***************************************Presence on non working days WebObjects**********************************//	
	@FindBy(xpath="//st-checkbox[@formcontrolname='isApplicableToAll']/input")
	WebElement isPriorApprovalCheckBox;
	
	@FindBy(xpath="//st-checkbox[@formcontrolname='holiday']/label")
	WebElement holidayCheckBox;
	
	@FindBy(xpath="//st-checkbox[@formcontrolname='weekoff']/label")
	WebElement weekOffCheckBox;
	
	/*@FindBys({@FindBy(xpath="//st-checkbox/input[@type='checkbox']")})
	List<WebElement> checkBox;*/
	
	@FindBys({@FindBy(xpath="//input[@formcontrolname='compOffCreditType']")})
	List<WebElement> compoffCreditTypeRadioButton;
	
	
//****************************************************************************************************************//	
	
	@FindBy(xpath="//button[contains(.,'SAVE AS DRAFT')]")
	WebElement saveASDraft;
	
	
	@FindBy(xpath="//button[contains(.,'SUBMIT')]")
	WebElement submit;
	
	
//***************************************************Methods************************************************************//	
	
	
	//Intializing the page objects	
		public CompOffPolicy(){
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnNewCompoffPolicybtn(){
			newCompoffPolicyButton.click();
		}
		
		public void clickOnDropDown(int arg){
			clickDropdown.get(arg).click();
		}
		
		public void clickSelectAffiliate(int arg){
			selectContentfrmAffiliatedropdown.get(arg).click();
		}
		public void clickSelectAffiliate(){
			affilate.click();
		}
		
		public void clickOnCompoffCreditRadioButton(int arg){
			creditCompoffRadioButton.get(arg).click();
		}
		
		public void EnterPolicyName(String Name){
			policyName.sendKeys(Name);
		}
		public void EnterEffectiveDate() throws InterruptedException{
			policyEffectiveDate.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", selPolicyEffectiveDate);
			Thread.sleep(2000);
		}
		
		public void clickOnvalidityRadioButton(int arg){
			validityRadioButton.get(arg).click();
		}
		
		public void maximumNoOfCompoffEarnedperMonth(String value){
			earnedCompOffLimit.sendKeys(value);
		}
		
		public void maximumNoOfCompoffAvailedperMonth(String value){
			availedCompOffLimit.sendKeys(value);
		}
		
		public void clickOnhourPicker(String hour) throws InterruptedException{
		//	hourPickerTextBox.click();
			Thread.sleep(1000);
			timePicker.sendKeys(hour);
		}
		
		public void clickOnMinutePicker(String min){
			minutePicker.click();
			minutePicker.sendKeys(min);
		}
		
		/*public void clickOnCheckBox(int arg){
			checkBox.get(arg).click();
		}*/
		
		public void clickOnIsPriorCheckBox(){
			isPriorApprovalCheckBox.click();
		}
		
		public void clickOnHolidayCheckBox(){
			holidayCheckBox.click();
		}
		
		public void clickOnWeekOFfCheckBox(){
			weekOffCheckBox.click();
		}
		
		public void clickOnDateTimePicker(int arg){
			dateTimePicker.get(arg).click();
		}
		
		public void clickOnCompoffCreditType(int arg){
			compoffCreditTypeRadioButton.get(arg).click();
		}
		
		public void clickOncompOffOTRadioBtn(int arg){
			compOffOT.get(arg).click();
		}
		
		public void EnterCreditCompoff(String value){
			creditNoOfCompoff.sendKeys(value);
		}
		
		public void clickOnSaveAsDraftBtn(){
			saveASDraft.click();
		}
		
		public void clickOnSubmitBtn(){
			submit.click();
		}
		
		

}
