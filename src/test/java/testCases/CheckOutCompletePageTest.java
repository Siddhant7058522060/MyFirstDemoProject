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
import pages.CheckOutCompletePage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOutCompletePageTest extends TestBase
{
	LoginPage Login;
	InventoryPage Invent;
	CartPage Cart;
	CheckoutStepOnePage checkout1;
	CheckoutStepTwoPage checkout2;
	CheckOutCompletePage checkout3;
	
	
@BeforeMethod(alwaysRun = true)
	
	public void SetUp() throws IOException       
	{
		initialization();
	   Login = new LoginPage();
	   Invent = new InventoryPage();
	   Cart = new CartPage();
	   checkout1 = new CheckoutStepOnePage();
	   checkout2 = new CheckoutStepTwoPage();
	   checkout3 = new CheckOutCompletePage();
	   Login.LoginToApplication();  
	   Invent.Add6ProductsToCart();
	   Invent.clickOnCartIcon();
	   Cart.checkoutCart();
	   checkout1.informationt();
	   checkout2.clickOnFinishBtn();
	}

	
	@Test
	public void verifyTitleOfAppTest() 
	{
		String expTitle ="Swag Labs";
		String actTitle = checkout3.verifyTitleOfApp();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title Of Application ="+actTitle);
	}
	@Test
	public void verifyCheckOutCompleteTest() 
	{
		String expTxt ="Checkout: Complete!";
		String actTxt = checkout3.verifyCheckOutComplete();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Checkout Complete ="+actTxt);
	}
	@Test
	public void verifyShoppingCartTest() 
	{
		String expUrl ="";
		String actUrl = checkout3.verifyShoppingCart();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Shopping Cart Link ="+actUrl);
	}
	@Test
	public void verifyTickMarkImgTest() 
	{
		boolean result = checkout3.verifyTickMarkImg();
		Assert.assertEquals(result, true);
		Reporter.log("Tick Mark Logo is Display =" +result);
	}
	@Test
	public void verifyThankYouForYourOrderTest() 
	{
		String expTxt ="Thank you for your order!";
		String actTxt = checkout3.verifyThankYouForYourOrder();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Thank You For Your Order ="+actTxt);
	}
	@Test
	public void verifyCompleteTextTest()
	{
		String expTxt ="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actTxt = checkout3.verifyCompleteText();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Fetch Complete Text ="+actTxt);
	}	
	
	
	
	
	@Test
	public void verifyUrlOfBackHomeTest()
	{
		String expUrl ="https://www.saucedemo.com/inventory.html";
		String actUrl = checkout3.verifyUrlOfBackHome();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Verify Back Home Url ="+actUrl);
	}	
	
	@Test
	public void verifyTwitterLogo()
	{
		boolean result = checkout3.verifyTwitterLogo();
	    Assert.assertEquals(result, true);
	    Reporter.log("Linked In Logo Is Display =" +result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean result = checkout3.verifyFacebookLogo();
		 Assert.assertEquals(result, true);
	     Reporter.log("Linked In Logo Is Display =" +result);
	}
	@Test
	public void verifyLinkedInLogoTest()
	{
	    boolean result = checkout3.verifyLinkedInLogo();
	    Assert.assertEquals(result, true);
	    Reporter.log("Linked In Logo Is Display =" +result);
	}
	@Test
	public void verifyFooterTxtTest()
	{
		String exptxt ="© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actText = checkout3.verifyFooterTxt();
		Assert.assertEquals(exptxt, actText);
		Reporter.log("Verify Footer Text ="+actText);
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
