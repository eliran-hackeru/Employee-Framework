package crudtable.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import crudtable.utility.BrowserFactory;
import crudtable.utility.ConfigDataProvider;
import crudtable.utility.ExcelDataProvider;
import crudtable.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeSuite
	public void setUpSuite() 
	{
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setupApplication()
	{
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
	}
	
	@BeforeTest
	public void seExtent()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"test-output/myReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReporter.config().setReportName("Functional Report");// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Eliran Duveen");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		
		if (result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver,this.getClass().getSimpleName(),"Failure");
			
			extentTest.log(Status.FAIL, "Test Case FAILED Is " + result.getName());// To add name in extent report
			extentTest.log(Status.FAIL, "Test Case FAILED Is " + result.getThrowable());// To add error/exception in extent report
			
			extentTest.addScreenCaptureFromPath("./Screenshots/");
		}
		
		else if (result.getStatus() ==  ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Test Case SKIPPED Is " + result.getName());
		}
		
		else if (result.getStatus() ==  ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, "Test Case PASSED Is " + result.getName());
		}
	}

}