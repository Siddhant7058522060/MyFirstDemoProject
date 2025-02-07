package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutStepOnePage extends TestBase
{
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement checkoutPageTitle;
	@FindBy(xpath="//span[@class='title']") private WebElement yourInfoText;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancleBtn;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement checkoutpageCartIcon;
	
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCode;

	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath="//input[@name='continue']") private WebElement continueStepOneBtn;
	public CheckoutStepOnePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutPageTitle() 
	{
		return driver.getTitle();
		
	}
	public String verifyYourInfoTxt() 
	{
		return yourInfoText.getText();
		
	}
	public String clickOnCancleBtn() 
	{
		cancleBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String clickonCheckoutCartIcon() 
	{
		checkoutpageCartIcon.click();
		return driver.getCurrentUrl();
		
	}
	public String informationt() 
	{
		firstName.sendKeys("Siddhant");;
		lastName.sendKeys("Chothe");
		postalCode.sendKeys("415311");
		continueBtn.click();
		return driver.getCurrentUrl();
		 
	}
	public String clickOncontinueStepOneBtn() 
	{
		continueStepOneBtn.click();
		return driver.getCurrentUrl();
	}
	
}
