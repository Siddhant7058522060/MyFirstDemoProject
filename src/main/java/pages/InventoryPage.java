package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;


public class InventoryPage extends TestBase
{
	
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footerText; 
	@FindBy(xpath="//span[@class='title']") private WebElement titleProduct;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement inventoryPageLogo;
	
					// add
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackAddProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightAddProduct;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtAddProduct;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketAddProduct;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement oneSieAddProduct;
	@FindBy(xpath= "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtAddProduct;
					
					//remove
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement backPackRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeLightRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement fleeceJacketRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement oneSieRemoveProduct;
//	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtRemoveProduct;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDownList;
	
	public InventoryPage()									
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Add6ProductsToCart() 
	{
	
		HandleDropDown.dropdownList(dropDownList, "Name (A to Z)");
		backPackAddProduct.click();
		bikeLightAddProduct.click();
		boltTshirtAddProduct.click();
		fleeceJacketAddProduct.click();
		oneSieAddProduct.click();
		redTshirtAddProduct.click();
		return cartCount.getText();
		
	}
	public String Remove5ProductsFromeCart() throws InterruptedException 
	{
	    Add6ProductsToCart();							// pre requisite method
	    Thread.sleep(5000);
	    backPackRemoveProduct.click();
		bikeLightRemoveProduct.click();
		boltTshirtRemoveProduct.click();
		fleeceJacketRemoveProduct.click();
		oneSieRemoveProduct.click();
//		redTshirtRemoveProduct.click();
		return cartCount.getText();
		
	}
	
	public String clickOnCartIcon() 
	{
		 cartIcon.click();
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
		return false;
		
	}
	public String verifyFooterText() 
	{
		return footerText.getText();
		
	}
	public String verifyTitleOfProduct() 
	{
		return titleProduct.getText();
		
	}
	public String verifylogoOfInventoryPage() 
	{
		return driver.getTitle();
		
	}
	
}
