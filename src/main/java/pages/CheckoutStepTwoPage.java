package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutStepTwoPage extends TestBase
{
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement titleOfCheckoutStepTwo;
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement checkOutOverviewTxt;
	@FindBy(xpath="//div[text()='QTY']") private WebElement qtyxt;
	@FindBy(xpath="//div[text()='Description']") private WebElement descriptionTxt;
	
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement paymentInfoTxt;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement sauceCardTxt;
	@FindBy(xpath="//div[text()='Shipping Information:']") private WebElement shippingInfoTxt;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']") private WebElement freePonyExpDeliveryTxt;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement priceTotalTxt;
	@FindBy(xpath="//div[@class='summary_subtotal_label']") private WebElement itemTotalTxt;
	@FindBy(xpath="//div[@class='summary_tax_label']") private WebElement taxTxt;
	@FindBy(xpath="//div[@class='summary_total_label']") private WebElement totalTxt;
	
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancleBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement shoppingCart;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footerTxt;
	
 	@FindBy(xpath="//button[text()='Open Menu']") private WebElement openMenu;
 	
	public CheckoutStepTwoPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String clickOnOpenMenu() 
	{
		openMenu.click();
		return driver.getCurrentUrl();
	}
	public String clickOnCancleBtn() 
	{
		cancleBtn.click();
		return driver.getCurrentUrl();		
	}
	public String clickOnFinishBtn() 
	{
		finishBtn.click();
		return driver.getCurrentUrl();		
	}
	public String verifyShoppingCart() 
	{
		shoppingCart.click();
		return driver.getCurrentUrl();		
	}
	public boolean verifyTwitterLogo() 
	{
		return twitterLogo.isDisplayed();		
	}
	public boolean verifyFacebookLogo() 
	{
		return facebookLogo.isDisplayed();			
	}
	public boolean verifyLinkedInLogo() 
	{	
		return linkedInLogo.isDisplayed();			
	}
	public String getFooterTxt() 
	{
		return footerTxt.getText();
		
	}
	
	
	
	
	
	public String verifytitleOfCheckoutStepTwo() 
	{
		return driver.getTitle();
	}
	public String verifycheckOutOverviewTxt() 
	{
		return checkOutOverviewTxt.getText();		
	}
	public String verifyqtyxt() 
	{
		return qtyxt.getText();		
	}
	public String verifydescriptionTxt() 
	{
		return descriptionTxt.getText();		
	}
	
	
	public String verifypaymentInfoTxt() 
	{
		return paymentInfoTxt.getText();		
	}
	public String verifysauceCardTxt() 
	{
		return sauceCardTxt.getText();		
	}
	public String verifyshippingInfoTxt() 
	{
		return shippingInfoTxt.getText();		
	}
	public String verifyfreePonyExpDeliveryTxt() 
	{
		return freePonyExpDeliveryTxt.getText();		
	}
	public String verifypriceTotalTxt() 
	{
		return priceTotalTxt.getText();		
	}
	public String verifyitemTotalTxt() 
	{
		return itemTotalTxt.getText();		
	}
	public String verifytaxTxt() 
	{
		return taxTxt.getText();		
	}
	public String verifytotalTxt() 
	{
		return totalTxt.getText();		
	}
	
	
}
