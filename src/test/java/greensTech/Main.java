package greensTech;

import baseClass.Base;

public class Main extends Base {

	public static void main(String[] args) throws InterruptedException {
		
		launchBrowser();
		launchUrl("http://www.greenstechnologys.com/");
		FirstPage p1=new FirstPage();
		p1.firstPage();
		
		
		
		
		
		
	
	}
}
