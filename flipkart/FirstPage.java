package flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.Base;

public class FirstPage extends Base {
	
	public FirstPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closeBtn;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchItem;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchBtn;

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getSearchItem() {
		return searchItem;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	

}
