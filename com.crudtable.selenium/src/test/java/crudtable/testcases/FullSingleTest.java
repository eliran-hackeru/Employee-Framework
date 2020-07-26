package crudtable.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;

public class FullSingleTest extends BaseClass
{
	@Test(priority=0)
	public void addEmployeeApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.addEmployee(excel.getStringData("Details", 0, 0), excel.getStringData("Details", 0, 1),excel.getStringData("Details", 0, 2));
		
		Helper.captureScreenshot(driver,testName,"02_InsertEmployeeDetails");
		
		indexPage.saveEmployee();
		
		indexPage.assertAddEmployee();
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"03_Complete");
	}
	
	@Test(priority=1)
	public void printEmployeeApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		extentTest.createNode(indexPage.printEmployee(excel.getStringData("Details", 0, 1)));
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}
	
	@Test(priority=2)
	public void editEmployeeApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.updateEmployee(excel.getStringData("Details", 0, 1), excel.getStringData("Update_Details", 0, 0), excel.getStringData("Update_Details", 0, 1), excel.getStringData("Update_Details", 0, 2));
		
		Helper.captureScreenshot(driver,testName,"02_InsertEmployeeDetails");
		
		Thread.sleep(1500);
		
		indexPage.saveUpdatedEmployee();
		
		indexPage.assertUpdateEmployee();
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"03_Complete");
	}
	
	@Test(priority=3)
	public void deleteEmployeeApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.deleteEmployee(excel.getStringData("Delete", 0, 1));
		
		indexPage.assertDeleteEmployee();
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}
}
