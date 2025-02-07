package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class InventoryPageTest extends TestBase
{
	LoginPage Login;
	InventoryPage Invent;
	
	@BeforeMethod
	
	public void SetUp() throws IOException         // pre requisite ( 1st login )
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Login.LoginToApplication();  

	}

	@Test
	
	public void Add6ProductsToCartTest() throws EncryptedDocumentException, IOException 
	{
		String ExpCount =ReadData.readExcel(4, 1); //6            Parameterization
		String ActCount =Invent.Add6ProductsToCart();
		Assert.assertEquals(ExpCount, ActCount);
		Reporter.log("Add to cart products =" +ActCount);
	}
	
	@Test
	
	public void Remove5ProductsFromeCartTest() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		String ExpCount =ReadData.readExcel(5, 1);        // 1
		String ActCount = Invent.Remove5ProductsFromeCart();
		Assert.assertEquals(ExpCount, ActCount);
		Reporter.log(" Remove products from cart =" +ActCount);
	}
	@Test(invocationCount = 2, timeOut = 1000)
	public void verifyTwitterLogoTest() 
	{
		boolean result = Invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Logo of Twitter =" +result);
	}
	
	@Test
	public void verifyFacebookLogoTest() 
	{
		boolean result= Invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Logo of Facebook =" +result);
	}
	
	@Test
	public void verifyLinkedInLogoTest() 
	{
		boolean result = Invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Logo of Twitter =" +result);
	}
	
	@Test
	
	public void verifyFooterTextTest() 
	{
	    String ExpTxt = "© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
	    String ActTxt = Invent.verifyFooterText();
	    Assert.assertEquals(ExpTxt, ActTxt);
		Reporter.log("Text of Footer =" +ActTxt);
	}
	
	@Test
	
	public void verifyTitleOfProductTest() 
	{
		String ExpTitle= "Products";
		String ActTitle= Invent.verifyTitleOfProduct();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Title of Product =" +ActTitle);
	
	}
	@Test
	
	public void verifylogoOfInventoryPageTest()
	{
		String ExpLogo= "Swag Labs";
		String ActLogo= Invent.verifylogoOfInventoryPage();
		Assert.assertEquals(ExpLogo, ActLogo);
		Reporter.log("InventoryPage Logo =" +ActLogo);
	}
	@Test
	
	public void clickOnCartIconTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/cart.html";
		String ActUrl = Invent.clickOnCartIcon();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Shopping Cart =" +ActUrl);
	}
	@AfterMethod
	public void CloseBrowser(ITestResult It) throws IOException    // ITestResult class and create object It which contains status like FAILURE and getStatus
	{
		if(It.FAILURE==It.getStatus())
		{
			Screenshot.screencapture(It.getName());
		}	
		driver.close();
	}

}
