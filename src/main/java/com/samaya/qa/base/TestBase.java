package com.samaya.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.samaya.qa.pages.organisation.LoginPage;
import com.samaya.qa.util.TestUtil;
import com.samaya.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
//	public TestBase(){
//		try{
//		prop= new Properties();
//		FileInputStream fs;
//			fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/samaya/qa/config/config.properties");
//				prop.load(fs);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//			}
//		}
     public static void initialization() throws InterruptedException{
    	 try{
    			prop= new Properties();
    			FileInputStream fs;
    				fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/samaya/qa/config/config.properties");
    					prop.load(fs);
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			} catch (IOException e) {
    				e.printStackTrace();
    				}
    	 String browsername = prop.getProperty("browser");
//    	 System.out.println(browsername);
    	 if (System.getProperty("os.name").contains("Window")) {
// 			System.out.println(System.getProperty("os.name"));
 			if (browsername.equalsIgnoreCase("Firefox")){
// 				System.out.println("launching browser");
 			//	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
 				driver = new FirefoxDriver();
// 				System.out.println("launched browser");
 			}else if(browsername.equalsIgnoreCase("Chrome")){
 					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
 					driver = new ChromeDriver();
 					
 				}
 				
 			}else if (System.getProperty("os.name").contains("Mac")) {
 				System.out.println(System.getProperty("os.name"));
 				if (browsername.equalsIgnoreCase("Firefox")){
 					System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver");
 					driver = new FirefoxDriver();
 				}else if(browsername.equalsIgnoreCase("Chrome")){
 						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
 						driver = new ChromeDriver();
 					}
 			}
    	 
//    	 e_driver = new EventFiringWebDriver(driver);
// 		// Now create object of EventListerHandler to register it with EventFiringWebDriver
// 		eventListener = new WebEventListener();
// 		e_driver.register(eventListener);
// 		driver = e_driver;
    	 
//    	 System.out.println("browser maximizing");
    	    driver.manage().window().maximize();
//    	    System.out.println("browser maximized");
    	    driver.manage().deleteAllCookies();
    	    //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//    	    System.out.println("entering url");
    		
			Thread.sleep(10000);
			
		}
    	 @BeforeSuite
    	 public void setUp() throws InterruptedException
    	 {
    		// System.out.println("hiii");
    		 initialization();
    		 driver.get(prop.getProperty("url"));
     		
 			
    	 }
//    	 @BeforeTest
//    	 public void login()
//    	 {
//    		 System.out.println("executing");
//    		 LoginPage loginpage = new LoginPage();
//    		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//    	 }
    	 
    //	 @AfterSuite
    	 public void tearDown()
    	 {
    		 driver.quit();
    	 }
     }
	 
	
	


