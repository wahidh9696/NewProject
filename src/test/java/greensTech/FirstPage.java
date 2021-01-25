package greensTech;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Base;

public class FirstPage extends Base {

	public FirstPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//strong[contains(text(),'DAY to DAY Course Plan ')]")
	private WebElement scrollDown;
	
	@FindBy(xpath="//p[contains(text(),'Our Trainings are focused')]")
	private WebElement para;
	
	@FindBy(xpath="//h1[contains(text(),'No 1 Software')]")
	private WebElement scrollUp;
	
	@FindBy(xpath="//a[text()='Certifications']")
	private WebElement certification;
	
	@FindBy(xpath="(//a[text()='Course Content'])[40]")
	private WebElement courseContent;

	public WebElement getScrollDown() {
		return scrollDown;
	}

	public WebElement getPara() {
		return para;
	}

	public WebElement getScrollUp() {
		return scrollUp;
	}
	
	public WebElement getCertification() {
		return certification;
	}

	public WebElement getCourseContent() {
		return courseContent;
	}

	public void firstPage() throws InterruptedException {
		scrollDown(getScrollDown());
		getText(getPara());
		
		scrollUp(scrollUp);
		getText(scrollUp);
		
		click(getCertification());
		Thread.sleep(3000);
		click(courseContent);
	
	}
	
	
	
	
	
	
}
