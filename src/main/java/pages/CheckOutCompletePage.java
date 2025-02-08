package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutCompletePage extends TestBase
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement titleOfApp;
	@FindBy(xpath="//span[@class='title']") private WebElement checkOutComplete;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement shoppingCart;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement tickMartLogo;
	@FindBy(xpath="//h2[text()='Thank you for your order!']") private WebElement thankYouForYourOrder;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement completeText;	
	@FindBy(xpath="//button[@name='back-to-products']") private WebElement backHome;
	
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footerTxt;
	
public CheckOutCompletePage() 			
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfApp() 
	{
		return titleOfApp.getText();
		
	}
	public String verifyCheckOutComplete()   
	{
		return checkOutComplete.getText();
		
	}
	public String verifyShoppingCart() 
	{
		return shoppingCart.getText();
		
	}
	public boolean verifyTickMarkImg() 
	{
		return tickMartLogo.isDisplayed();
		
	}
	public String verifyThankYouForYourOrder() 
	{
		return thankYouForYourOrder.getText();
		
	}
	public String verifyCompleteText() 
	{
		return completeText.getText();
		
	}
	
	
	
	public String verifyUrlOfBackHome() 
	{
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
	public String verifyFooterTxt() 
	{
		return footerTxt.getText();
	}
	
}
