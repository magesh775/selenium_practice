package pojo.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flip extends BaseClass {
	public flip() {
PageFactory.initElements(driver, Login);
	}

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement Login;
	@FindBy(xpath = "//button[text()='Request OTP']")
	private WebElement Request;

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getRequest() {
		return Request;
	}

}
