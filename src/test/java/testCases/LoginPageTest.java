package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage Login;
	
	@BeforeMethod               // pre requisite/pre condition
	public void SetUp() throws IOException
	{
		initialization();
		Login = new LoginPage();        // create object of LoginPage class and declare it globally
	}
	
	@Test
	
	public void LoginToApplicationTest() throws IOException 
	{
		String ExpUrl =ReadData.readExcel(0, 1);          // https://www.saucedemo.com/inventory.html  (Parameterization)
		String ActUrl = Login.LoginToApplication();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Logged in Url =" +ActUrl);
	}
	
	@DataProvider(name= "LoginWithCreds")
	
	public Object[] [] getData()
	{
		return new Object[] [] 
		{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			
		};
		
	}
	
	
	@Test(dataProvider = "LoginWithCreds")
	public void loginToApplicationWithMultiCredsTest(String un, String pass) 
	{
		SoftAssert soft = new SoftAssert();
		String expUrl ="https://www.saucedemo.com/inventory.html";
		String actUrl = Login.loginToApplicationWithMultiCreds(un, pass);
		soft.assertEquals(expUrl, actUrl);
		soft.assertAll();
	}
	
	@Test						
	
	public void verifyUrlOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpUrl = ReadData.readExcel(1, 1);         // https://www.saucedemo.com/
		String ActUrl = Login.verifyUrlOfApplication();
	Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Application Url=" +ActUrl);
	}
	
	@Test
	
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpTitle = ReadData.readExcel(2, 1);  //	Swag Labs
		String ActTitle = Login.verifyTitleOfApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("ActTitle=" +ActTitle);
	}
	@AfterMethod				// close browser
	
	public void CloseBrowser(ITestResult It) throws IOException    // ITestResult class and create object It which contains status like FAILURE and getStatus
	{
		if(It.FAILURE==It.getStatus())
		{
			Screenshot.screencapture(It.getName());
		}	
		report.flush();
		driver.close();
	}

}
