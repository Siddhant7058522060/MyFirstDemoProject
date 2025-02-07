package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement cartPageTitle;

    @FindBy(xpath="//span[@class='title']") private WebElement yourCartTxt;
	
	@FindBy(xpath="//div[text()='QTY']") private WebElement QTYText;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descriptionText;
	
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	@FindBy(xpath="//button[@name='checkout']") private WebElement checkoutBtn;
	
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String titleOfCartPage() 
	{
		return driver.getTitle();
		
	}

	public String yourcartTxt() 
	{
		return yourCartTxt.getText();
		
	}
	public String textQtyCart() 
	{
		return QTYText.getText();
	}
	public String textdescriptionCart() 
	{
		return descriptionText.getText();
	}
	
	public String continueshoppingCart() 
	{
		return driver.getCurrentUrl();
		
	}
	public String checkoutCart() 
	{ 
		 checkoutBtn.click();
		return driver.getCurrentUrl();
		
	}
}
