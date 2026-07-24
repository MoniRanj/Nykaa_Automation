package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.DatabaseUtility;
import utilities.ExcelUtility;
import utilities.FileUtility;
import utilities.JavaUtility;
import utilities.UtilityClassObject;
import utilities.WebdriverUtility;

public class BaseClass {

	/*create object*/
   public  DatabaseUtility dbLib=new  DatabaseUtility();
   public  FileUtility fLib=new FileUtility();
   public  ExcelUtility eLib=new ExcelUtility();
   public JavaUtility jLib=new JavaUtility();
   public WebdriverUtility wLib=new WebdriverUtility();
   public  WebDriver driver=null;
   public  static WebDriver sdriver=null;
   public  static ExtentReports report;
	  ExtentTest  test;
   
	@BeforeSuite
	 public void configBS()
		{
			System.out.println("==connect to DB ,Report config===");
			
		}
	//@Parameters("BROWSER")
	@BeforeClass
	//public void configBC(String browser)
	 public void configBC() throws IOException
		{
			System.out.println("==Launch the Browser==");
			//String BROWSER=browser;
			String BROWSER=fLib.getDataFromPropertiesFile("Browser");
			 if(BROWSER.equals("chrome"))
			 {
				 driver = new ChromeDriver();
			 }
			 else if(BROWSER.equals("Firefox"))
			 {
				
				 driver = new FirefoxDriver();
			 }
			 else if(BROWSER.equals("edge"))
			 {
				 driver = new EdgeDriver();
			 }
			sdriver=driver;
			UtilityClassObject.setDriver(driver);
		}
		
	@BeforeMethod
	 public void configBM() throws IOException
	 
		{
		System.out.println("==Login==");
	
	}
	
	@AfterMethod
	 public void configAM()
		{
			System.out.println("==Logout===");
			
	}
	 @AfterClass
	 public void configAC()
		{
			System.out.println("==closethe Browser==");
			driver.quit();
	}
	@AfterSuite
	 public void configAS()
		{
		  
			System.out.println("==close Db,Report backup==");
			dbLib.closeDbconnection();	
			//report.flush();
			  
		}

}
