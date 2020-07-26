package crudtable.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;

public class SingleDeleteTest extends BaseClass
{
	@Test
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
