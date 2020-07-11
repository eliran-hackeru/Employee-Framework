package crudtable.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	//Screenshots, timestamps, waits and check for elements,  javascript executor
	
	public static void captureScreenshot(WebDriver driver, String testName, String screenshotName) 
	{
		try 
		{
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File("./Screenshots/"+testName+"_"+screenshotName+"_"+getCurrentDateTime()+".png");
			
			FileUtils.copyFile(src,DestFile);
			
			System.out.println("Screenshot captured");
		}
		catch (Exception e) {
			
			System.out.println("Exception while capturing screenshot "+e.getMessage());
		} 
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd");
		
//		Full date format: DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
	public static void waitForElementByID(WebDriver driver, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
	}
	
	public static void waitForElementByClassName(WebDriver driver, String className)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
	}
	

	public boolean checkForElementID(WebDriver driver, String value)
	{
		if (driver.findElements(By.id(value)).size() != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
}