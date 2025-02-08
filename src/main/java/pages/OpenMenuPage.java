package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class OpenMenuPage extends TestBase
{

	@FindBy(xpath="//a[@id='inventory_sidebar_link']") private WebElement allItems;
	@FindBy(xpath="//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logOut;
	@FindBy(xpath="//a[text()='Reset App State']") private WebElement resetApp;
	
	public OpenMenuPage() 
	{
		PageFactory.initElements(driver, this);
	}
	public String getAllItemsTxt() 
	{
		return allItems.getText();
		
	}
	public String getAboutTxt() 
	{
		return about.getText();
		
	}
	public String getLogOutTxt() 
	{
		return logOut.getText();
		
	}
	public String getResetAppTxt() 
	{
		return resetApp.getText();
		
	}
}
