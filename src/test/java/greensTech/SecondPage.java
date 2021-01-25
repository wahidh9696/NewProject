package greensTech;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Base;

public class SecondPage extends Base {
	public SecondPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[contains(text(),'Technology, Rated As')]")
	private WebElement para;
	
	@FindBy(xpath="//h2[text()='Selenium Training in Chennai']")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}

	public WebElement getPara() {
		return para;
	}


	public void secondPage() {
		getText(getPara());
		getText(getTitle());

	}
	
	
	
}
