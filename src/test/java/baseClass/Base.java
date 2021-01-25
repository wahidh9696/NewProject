package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Base extends Excel{
	
	public static WebDriver driver;
	
	//Browser Launch
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\MavenNew\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	//URL Launch
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	//Send Keys
	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	
	//Click
	public static void click(WebElement e) {
		e.click();
	}
	
	//Get Text
	public static String getText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
		return text;
	}
	
	//Get Attribute
	public static String getAttribute(WebElement e, String attribute) {
		String att = e.getAttribute(attribute);
		return att;
	}
	
	//Move to Element
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	
	//Drag & Drop
	public static void dragAndDrop(WebElement src, WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	//Double Click
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	
	//Context Click
	public static void contextClick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
	}
	
	//Scroll Down
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	//Scroll Up
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}
	
	//JS sendkeys
	public static void jsSendKeys(WebElement e, String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"' )", e);
	}
	
	//JS get Attribute
	public static String jsGetAttribute(WebElement e, String Attribute) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('"+Attribute+"')", e);
		return Attribute;		
	}
	
	//Alert--->Accept
	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	//Alert--->Dismiss
	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	
	//Alert--->Text with Accept
	public static void alertTextAccept(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
	}
	
	//Alert--->Text with Dismiss
	public static void alertTextCancel(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.dismiss();
	}
	
	//Screenshot
	public static File screenshot(String FileName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ELCOT\\Desktop\\Java\\Greens Technology\\Screenshot\\"+FileName+".png");
		FileUtils.copyFile(src, dest);
		return dest;
	}
	
	//Frames--->using name or Id
	public static void frame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	//Frames--->using Index
	public static void frame(int index) {
		driver.switchTo().frame(index);
	}
	
	//Frames-->Using WebElement
	public static void frame(WebElement e) {
		driver.switchTo().frame(e);
	}
	
	//Select--->Get options
	public static void getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		for (WebElement x : options) {
			System.out.println(x.getText()); 
		}
	}
	
	//Select--->get all  Selected Options
	public static void getSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement x : allSelectedOptions) {
			System.out.println(x.getText());
		}
	}
	
	//Select--->Get first Selected Option
	public static void getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	
	//Select--->Select all Options
	public static void selectAllOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			s.selectByIndex(i);
		}
	}
	
	//Window Handling
	public static void switchToWindow(int index) {
		Set<String> allID = driver.getWindowHandles();
		List<String> li=new LinkedList<String>();
		li.addAll(allID);
		driver.switchTo().window(li.get(index));	
	}
	
	// Implicit wait
	public static void waitAll() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// Fluent Wait
	public static void waitIt() {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2)).
				pollingEvery(Duration.ofSeconds(10)).ignoring(Throwable.class);
	}
	
	
	

}
