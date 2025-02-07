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
import utility.Screenshot;

public class CheckoutStepTwoPageTest extends TestBase
{
	LoginPage Login;
	InventoryPage Invent;
	CartPage Cart;
	CheckoutStepOnePage Checkout1;
	CheckoutStepTwoPage checkout2;
	
	@BeforeMethod(alwaysRun = true)
	
	public void SetUp() throws IOException       
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Cart = new CartPage();
	   Checkout1 = new CheckoutStepOnePage();
	   checkout2 = new CheckoutStepTwoPage();
	   Login.LoginToApplication();  
	   Invent.Add6ProductsToCart();
	   Invent.clickOnCartIcon();
	   Cart.checkoutCart();
	
	   Checkout1.informationt();
	}
	@Test(groups = {"Sanity","Regression"})
	
	public void verifytitleOfCheckoutStepTwoTest() 
	{
		String expTitle = "Swag Labs";			//Swag Labs
		String actTitle =checkout2.verifytitleOfCheckoutStepTwo();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title ="+actTitle);
	}
	@Test(groups = {"Retest","Regression"})
	public void verifycheckOutOverviewTxtTest() 
	{
		String expTitle = "Checkout: Overview";     // Checkout: Overview
		String actTitle =checkout2.verifycheckOutOverviewTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt checkout overview ="+actTitle);	
	}
	@Test(groups = "Sanity")
	public void verifyqtyxtTest() 
	{
		String expTitle = "QTY";			// QTY
		String actTitle =checkout2.verifyqtyxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt QTY ="+actTitle);
	}
	@Test(groups = "Sanity")
	public void verifydescriptionTxtTest() 
	{
		String expTitle = "Description"; 		//Description
		String actTitle =checkout2.verifydescriptionTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt description ="+actTitle);
	}
	
	
	@Test(groups = "Regression")
	public void verifypaymentInfoTxtTest() 
	{
		String expTitle = "Payment Information:";		// Payment Information:
		String actTitle =checkout2.verifypaymentInfoTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt payment information ="+actTitle);		
	}
	@Test(groups = {"Regression","Retest"})
	public void verifysauceCardTxtTest() 
	{
		String expTitle = "SauceCard #31337";		// SauceCard #31337
		String actTitle =checkout2.verifysauceCardTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt SauceCard ="+actTitle);	
	}
	@Test(groups = "Regression")
	public void verifyshippingInfoTxtTest() 
	{
		String expTitle = "Shipping Information:";		// Shipping Information:
		String actTitle =checkout2.verifyshippingInfoTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Shipping Information ="+actTitle);	
	}
	@Test(groups = "Regression")
	public void verifyfreePonyExpDeliveryTxtTest() 
	{
		String expTitle = "Free Pony Express Delivery!";   // Free Pony Express Delivery!
		String actTitle =checkout2.verifyfreePonyExpDeliveryTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Free Pony Express Delivery ="+actTitle);	
	}
	@Test(groups = "Sanity")
	public void verifypriceTotalTxtTest() 
	{
		String expTitle = "Price Total";		// Price Total
		String actTitle =checkout2.verifypriceTotalTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Price Total ="+actTitle);
	}
	@Test(groups = {"Regression", "Retest"})
	public void verifyitemTotalTxtTest() 
	{
		String expTitle = "Item total: $129.94";
		String actTitle =checkout2.verifyitemTotalTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Item total ="+actTitle);	
	}
	@Test(groups = "Sanity")
	public void verifytaxTxtTest() 
	{
		String expTitle = "Tax: $10.40";
		String actTitle =checkout2.verifytaxTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Tax ="+actTitle);	
	}
	@Test(groups = "Regression")
	public void verifytotalTxtTest() 
	{
		String expTitle = "Total: $140.34";
		String actTitle =checkout2.verifytotalTxt();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Txt Total ="+actTitle);		
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
