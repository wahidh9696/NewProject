package flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Base;

public class SecondPage extends Base{
	public SecondPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='_1fQZEK'])[1]")
	private WebElement item;
	
	public WebElement getItem() {
		return item;
	}

}
