package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemailid;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;

	public void Enteremail(String email) {
		txtemailid.sendKeys(email);

	}

	public void Enterpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void Clicklogin() {
		btnlogin.click();
	}

}
