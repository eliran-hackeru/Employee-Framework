package crudtable.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import crudtable.utility.BrowserFactory;
import crudtable.utility.ConfigDataProvider;
import crudtable.utility.ExcelDataProvider;
import crudtable.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
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
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		
		if (ITestResult.FAILURE==result.getStatus())
		{
			Helper.captureScreenshot(driver,this.getClass().getSimpleName(),"Failure");
		}
		
	}

}