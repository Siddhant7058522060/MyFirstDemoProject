package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown
{
	public static void dropdownList(WebElement element , String value) 
	{
		Select s= new Select(element);
		s.selectByVisibleText(value);
	}
}
