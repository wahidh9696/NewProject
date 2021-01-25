package flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Base;

public class ThirdPage extends Base {

	public ThirdPage()  {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;
	
	public WebElement getaddToCart() {
		return addToCart;
	}
	
}
