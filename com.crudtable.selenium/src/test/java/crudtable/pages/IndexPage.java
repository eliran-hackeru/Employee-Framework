package crudtable.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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
	
	public void printEmployee(String employeeName)
	{
		for (int i=0;i<uEmails.size();i++)
		{
			if (employeeName.equals(uEmails.get(i).getText())) 
			{
				System.out.println("The Employee Details:");
				System.out.println("Name: "+uNames.get(i).getText()+" Email: "+uEmails.get(i).getText()+" Phone: "+uPhones.get(i).getText());
				break;
			}
		}
	}
}
