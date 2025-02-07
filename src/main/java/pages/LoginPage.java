package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.mongodb.diagnostics.logging.Logger;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	
	// Object Repository
	
	@FindBy(xpath="//input[@id='user-name']") private WebElement UsernameTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement PasswordTxtBox;
	@FindBy(xpath="//input[@type='submit']") private WebElement ClickBtn;
	
	
	 public LoginPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String LoginToApplication() throws IOException 
	 {   
		 logger= report.createTest("Login to Sauce Lab Application");
		 UsernameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		 logger.log(Status.INFO, "Username is ENtered");
		 PasswordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		 logger.log(Status.INFO, "Password is Entered");
		 ClickBtn.click();
		 logger.log(Status.INFO, "Login Btn is Clicked");
		 logger.log(Status.PASS, "Login Successful");
		return driver.getCurrentUrl();
	 }
	 
	 public String loginToApplicationWithMultiCreds(String un , String pass) 
	 {
		 UsernameTxtBox.sendKeys(un);
		 PasswordTxtBox.sendKeys(pass);
		 ClickBtn.click();
		return driver.getCurrentUrl();
		 
	 }
	 
	
	public String verifyUrlOfApplication() 
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleOfApplication() 
	{
		return driver.getTitle();
		
	}
	
}
