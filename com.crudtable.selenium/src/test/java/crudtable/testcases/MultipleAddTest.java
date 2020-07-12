package crudtable.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import crudtable.pages.BaseClass;
import crudtable.pages.IndexPage;
import crudtable.utility.Helper;

public class MultipleAddTest extends BaseClass
{
	@Test
	public void addAllEmployeesApp() throws InterruptedException, IOException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
//		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		indexPage.addAllEmployees("Details");
	}
}
