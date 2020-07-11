package crudtable.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;

public class SingleAddTest extends BaseClass
{
	
	@Test
	public void addEmployeeApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.addEmployee(excel.getStringData("Details", 0, 0), excel.getStringData("Details", 0, 1),excel.getStringData("Details", 0, 2));
		
		indexPage.saveEmployee();
		
		Thread.sleep(3000);
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}

}
