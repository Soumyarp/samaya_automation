package com.samaya.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.samaya.qa.base.TestBase;
import com.samaya.qa.pages.organisation.AffiliatePage;
import com.samaya.qa.pages.organisation.EmployeesPage;
import com.samaya.qa.pages.organisation.HomePage;
import com.samaya.qa.pages.organisation.LoginPage;

public class TestUtil extends TestBase  {
	public static int PAGE_LOAD_TIMEOUT=10;
	public static int IMPLICIT_WAIT=5;
	public static String TESTDATA_SHEET_PATH=System.getProperty("user.dir")+"/src/main/java/com/samaya/qa/testdata/Testdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	LoginPage loginpage;
	HomePage homepage;
	Robot robot;
	EmployeesPage employeespage;
	AffiliatePage affiliatepage;
	public static Calendar calender;
	public static SimpleDateFormat formater;
	public static String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\samaya\\qa\\testdata\\TestData.xlsx";
	
  public void navigateToPage(){
	  if (loginpage.verifyDashboardPage()!= homepage.verifyEmployeePageUrl()) {
			homepage.navigateToHomePage();
		}else if (loginpage.verifyDashboardPage()!= homepage.VerifyAffiliatePageUrl()) {
			homepage.navigateToHomePage();
		}else if (loginpage.verifyDashboardPage()!= homepage.VerifyBranchPageUrl()) {
			homepage.navigateToHomePage();
		}else {
			System.out.println("No url found");
		}
		}
  public void loginAgn(String username, String passwrd){
	  
	  LoginPage loginPage=new LoginPage();
	  System.out.println("logging in");
	  System.out.println(loginPage.email1.isDisplayed());
	  try{
		if(loginPage.email1.isDisplayed()==true)
		{
			System.out.println("helloooo");
		loginPage.email1.sendKeys(username);
		loginPage.password1.sendKeys(passwrd);
		loginPage.loginButton.click();
		}
		else{
			System.out.println("unable to login in utiity");
			loginPage.login("admin@tcs.com","p");
			}
	  }
		catch (Exception e) {
			loginPage.email1.sendKeys(username);
			loginPage.password1.sendKeys(passwrd);
			loginPage.loginButton.click();
		}
			// TODO: handle exception
		}
		
		
	
  

 public static Object[][] getTestData(String sheetName){
	// System.out.println("hiiiiiiiiiiiiii");
	 FileInputStream file = null;
	 try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 try {
		book = WorkbookFactory.create(file);
	}  catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 sheet = book.getSheet(sheetName);
	 
	 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	      for (int i = 0; i < sheet.getLastRowNum();i++) {
	    	  for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
	    		  data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
	 return data;
	
	 
	 /*String dataSets[][]=null;
		FileInputStream file;
		try {
			file = new FileInputStream(new File(TESTDATA_SHEET_PATH));
		//Create Workbook Instance holding reference to .xlsx file 
		XSSFWorkbook woorkbook = new XSSFWorkbook(file);
		//Get first/desired sheet from the workbook 
		XSSFSheet sheet = woorkbook.getSheet(sheetName);
		//Count no of active rows (It ll not provide empty row)
		int totalRow = sheet.getLastRowNum()+1;
		//count no of active columns in row (Count no of columns which have data)
		int totalColumn = sheet.getRow(0).getLastCellNum();
		//Create arrays of rows and column(object of 2d array)
		dataSets= new String[totalRow-1][totalColumn];
		//Iterate through each rows one by one 
		Iterator<Row> rowIterator= sheet.iterator();
		int i=0;
		int t=0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (i++ !=0) {
				int k =t;
				t++;
				//for each row, iterate through all the columns
				Iterator<Cell> cellIterator= row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()){
				Cell cell=cellIterator.next();
				//check the cell tyoe and format
				switch(cell.getCellType()){
				case Cell.CELL_TYPE_NUMERIC:
					//System.out.println(k);
					//System.out.println(j);
					dataSets[k][j++]=cell.getStringCellValue();
					System.out.println(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
//					System.out.println(k);
//					System.out.println(j);
					dataSets[k][j++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
//					System.out.println(k);
//					System.out.println(j);
					dataSets[k][j++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
//					System.out.println(k);
//					System.out.println(j);
					dataSets[k][j++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					break;
				}
			}
			System.out.println("");
		}
		}		
		file.close();
		return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
	}
		return null;
 */}
 
 
 public void pageRefresh(){
	 System.out.println("page refreshed");
	 driver.navigate().refresh();
 }


public static void takeScreenshotAtEndOfTest() throws IOException {
	
	Date d = new Date();
	String screenshotfile= d.toString().replace(":", "_").replace(" ", "_");
	File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir=System.getProperty("user.dir");
	FileUtils.copyFile(scrfile,new File(currentDir +"/screenshots/"+screenshotfile+".png" ));
}

public void scrollWindowPage() throws AWTException, InterruptedException{
	
	robot = new Robot();
	Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    
	
}

public void backSpace() throws AWTException{
	robot = new Robot();
	robot.keyPress(KeyEvent.VK_SHIFT);
	robot.keyPress(KeyEvent.VK_BACK_SPACE);
	robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	robot.keyRelease(KeyEvent.VK_SHIFT);
}

public List<String> getAllTestdatfrmExcel(String sheetName,String colName)
{
	  System.out.println("excel");
	  List<String> l1=new ArrayList<String>();
	   Xls_Reader reader=new Xls_Reader(filename);
	   int rowcount=reader.getRowCount(sheetName);
	   for(int rownum=2;rownum<=rowcount;rownum++)
	   {
		String colData=reader.getCellData(sheetName, colName, rownum)  ; 
		System.out.println(colData);
		l1.add(colData);
		
	   }
	   return l1;
	 
	   
	   
}	
	
	
}





