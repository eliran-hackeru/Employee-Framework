package crudtable.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;

public class MultipleDeleteTest extends BaseClass
{
	@Test
	public void deleteAllEmployeesApp() throws InterruptedException, IOException //Remove all the phone numbers prefixes
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.deleteAllEmployees();
		
		Thread.sleep(1500);
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}
}
