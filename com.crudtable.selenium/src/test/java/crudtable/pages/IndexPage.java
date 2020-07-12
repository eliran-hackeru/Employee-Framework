package crudtable.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import crudtable.utility.ExcelDataProvider;
import crudtable.utility.Helper;

public class IndexPage {
	
	WebDriver driver;
	
	public IndexPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id = "name") WebElement uName;
	
	@FindBy(id = "email") WebElement uEmail;
	
	@FindBy(id = "phone") WebElement uPhone;
	
	@FindBy(id = "save") WebElement saveButton;
	
	@FindBy(id = "colName") List<WebElement> uNames;
	
	@FindBy(id = "colEmail") List<WebElement> uEmails;
	
	@FindBy(id = "colPhone") List<WebElement> uPhones;
	
	@FindBy(id = "colEdit") List<WebElement> editButton;
	
	@FindBy(id = "colDelete") List<WebElement> deleteButton;
	
	@FindBy(id = "update") WebElement updateButton;
	
	public void addEmployee (String nameApp, String emailApp, String phoneApp) 
	{
		uName.sendKeys(nameApp);
		uEmail.sendKeys(emailApp);
		uPhone.sendKeys(phoneApp);
	}
	
	public void saveEmployee() 
	{
		saveButton.click();
	}
	
	public void printEmployee(String employeeEmail)
	{
		for (int i=0;i<uEmails.size();i++)
		{
			if (employeeEmail.equals(uEmails.get(i).getText())) 
			{
				System.out.println("The Employee Details:");
				System.out.println("Name: "+uNames.get(i).getText()+" Email: "+uEmails.get(i).getText()+" Phone: "+uPhones.get(i).getText());
				break;
			}
		}
	}
	
	public void updateEmployee(String oldEmail, String upName, String upEmail, String upPhone)
	{
		for (int i=0;i<uEmails.size();i++)
		{
			if (oldEmail.equals(uEmails.get(i).getText())) 
			{
				editButton.get(i).click();
				Helper.waitForElementByID(driver, "update");
				uName.clear();
				uEmail.clear();
				uPhone.clear();
				addEmployee(upName, upEmail, upPhone);
				break;
			}
		}
		
	}
	
	public void saveUpdatedEmployee()
	{
		updateButton.click();
	}
	
	public void deleteEmployee(String delEmail)
	{
		for (int i=0;i<uEmails.size();i++)
		{
			if (delEmail.equals(uEmails.get(i).getText()))
			{
				deleteButton.get(i).click();
			}
		}
	}
	
	public void addAllEmployees(String sheetName) throws IOException
	{
		int row = ExcelDataProvider.rowCounter(sheetName);
		
		for (int i=0;i<row;i++)
		{
			addEmployee(ExcelDataProvider.getStringData(sheetName, i, 0), ExcelDataProvider.getStringData(sheetName, i, 1), ExcelDataProvider.getStringData(sheetName, i, 2));
			saveEmployee();
		}
	}
}
