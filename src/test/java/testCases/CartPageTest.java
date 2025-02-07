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
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CartPageTest extends TestBase
{
	
	LoginPage Login;
	InventoryPage Invent;
	CartPage Cart;
	
@BeforeMethod
	public void SetUp() throws IOException       
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Cart = new CartPage();
	   Login.LoginToApplication();  
	   Invent.Add6ProductsToCart();
	   Invent.clickOnCartIcon();
	}

@Test
	
	public void titleOfCartPageTest() 
	{
		String ExpTitle = "Swag Labs";
		String ActTitle = Cart.titleOfCartPage();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Title of Cart Page =" +ActTitle);
	}
	@Test

	public void yourcartTxtTest() 
	{
		String Expcart ="Your Cart";
		String Actcart = Cart.yourcartTxt();
		Assert.assertEquals(Expcart, Actcart);
	}
	
	@Test
	public void textQtyCartTest() 
	{
		String ExpTxt = "QTY";
		String ActTxt = Cart.textQtyCart();
		Assert.assertEquals(ExpTxt, ActTxt);
		Reporter.log("QTY =" +ActTxt);
	}
	@Test
	public void textdescriptionCartTest() 
	{
		String ExpTxt = "DescriptionS";
		String ActTxt = Cart.textdescriptionCart();
		Assert.assertEquals(ExpTxt, ActTxt);
		Reporter.log("Description Text =" +ActTxt);
	}
	
	@Test
	public void continueshoppingCartTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/inventory.html";
		String ActUrl = Cart.continueshoppingCart();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("Continue Shopping =" +ActUrl);
	}
	@Test
	public void checkoutCartTest() 
	{
		String ExpUrl = "https://www.saucedemo.com/checkout-step-one.html";
		String ActUrl = Cart.checkoutCart();
		Assert.assertEquals(ExpUrl, ActUrl);
		Reporter.log("CheckOut Link =" +ActUrl);
		
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
