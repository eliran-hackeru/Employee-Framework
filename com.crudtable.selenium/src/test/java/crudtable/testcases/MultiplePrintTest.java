package crudtable.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;


public class MultiplePrintTest extends BaseClass
{
	@Test
	public void printAllEmployeesApp() throws InterruptedException, IOException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		extentTest.createNode(indexPage.printAllEmployees());
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}
}
