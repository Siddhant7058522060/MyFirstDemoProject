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
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CheckoutStepOnePageTest extends TestBase
{
	LoginPage Login;
	InventoryPage Invent;
	CartPage Cart;
	CheckoutStepOnePage Checkout;
	
	@BeforeMethod
	public void SetUp() throws IOException       
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Cart = new CartPage();
	   Checkout = new CheckoutStepOnePage();
	   Login.LoginToApplication();  
	   Invent.Add6ProductsToCart();
	   Invent.clickOnCartIcon();
	   Cart.checkoutCart();
	}
	
	@Test(priority=1)			// (priority=1)
	
	public void verifycheckoutPageTitleTest() 
	{
		String ExpTitle = "Swag Labs";
		String ActTitle = Checkout.verifycheckoutPageTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Verify checkout page Title =" +ActTitle);
	}
	@Test(priority=2)			// (priority=2)
	public void verifyYourInfoTxtTest() 
	{
		String ExpTxt = "Checkout: Your Information";
		String ActTxt = Checkout.verifyYourInfoTxt();
		Assert.assertEquals(ExpTxt, ActTxt);
		Reporter.log("Verify checkout page Title =" +ActTxt);
	}
	@Test(priority=4)			// (priority=4)
	public void clickOnCancleBtnTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/cart.html";
		String ActUrl = Checkout.clickOnCancleBtn();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Verify checkout page Title =" +ActUrl);
	}
	@Test(priority=5)			// (priority=5)
	public void clickonCheckoutCartIconTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/cart.html";
		String ActUrl = Checkout.clickonCheckoutCartIcon();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Verify checkout page Title =" +ActUrl);
	}
	@Test(enabled =true)			// (priority=6)
	public void informationtTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String ActUrl = Checkout.informationt();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Verify checkout page Title =" +ActUrl);
	}
	@Test(priority=3)			// (priority=3)
	
	public void clickOncontinueStepOneBtnTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String ActUrl = Checkout.clickOncontinueStepOneBtn();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Click On ContinueBtn =" +ActUrl);
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
