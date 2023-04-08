package pojo.org;

import org.openqa.selenium.WebDriver;

public class login extends BaseClass{
public static void main(String[] args) {
	
	launchBrowser();
	launchurl("https://www.flipkart.com/");
	windowMax();
    flip f = new flip();
    clickBtn(f.getRequest());
	
	
	
	
}
}
