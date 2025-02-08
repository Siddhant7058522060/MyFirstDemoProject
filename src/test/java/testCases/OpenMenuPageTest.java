package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OpenMenuPage;
import utility.Screenshot;

public class OpenMenuPageTest extends TestBase
{
	LoginPage Login;
	InventoryPage Invent;
	CartPage Cart;
	CheckoutStepOnePage checkout1;
	CheckoutStepTwoPage checkout2;
	OpenMenuPage openMenu;
	
	
@BeforeMethod(alwaysRun = true)
	
	public void SetUp() throws IOException       
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Cart = new CartPage();
	   checkout1 = new CheckoutStepOnePage();
	   checkout2 = new CheckoutStepTwoPage();
	   Login.LoginToApplication();  
	   Invent.Add6ProductsToCart();
	   Invent.clickOnCartIcon();
	   Cart.checkoutCart();
	   checkout1.informationt();
	   openMenu = new OpenMenuPage();
	   checkout2.clickOnOpenMenu();
	}
@Test
	public void getAllItemsTxtTest() 
	{
		String expUrl= "All Items";
		String actUrl = openMenu.getAllItemsTxt();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Fetch All Items Text =" +actUrl);
	}
@Test

public void getAboutTxtTest()
{
	String expUrl= "About";
	String actUrl = openMenu.getAboutTxt();
	Assert.assertEquals(expUrl, actUrl);
	Reporter.log("Fetch About Text =" +actUrl);
}
@Test

public void getLogOutTxtTest() 
{

	String expUrl= "Logout";
	String actUrl = openMenu.getLogOutTxt();
	Assert.assertEquals(expUrl, actUrl);
	Reporter.log("Fetch Logout Text =" +actUrl);
}
@Test

public void getResetAppTxtTest() 
{

	String expUrl= "Reset App State";
	String actUrl = openMenu.getResetAppTxt();
	Assert.assertEquals(expUrl, actUrl);
	Reporter.log("Fetch Logout Text =" +actUrl);
}
@AfterMethod(alwaysRun = true)

	public void CloseBrowser(ITestResult It) throws IOException    // ITestResult class and create object It which contains status like FAILURE and getStatus
	{
		if(It.FAILURE==It.getStatus())
		{
			Screenshot.screencapture(It.getName());
		}	
		driver.close();
	}
}
