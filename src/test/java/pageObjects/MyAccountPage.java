package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement textMyAcnt;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnklogout;

	public boolean verify_MyAccount() {
		try {
			return (textMyAcnt.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

	public void clickLogout() {
		lnklogout.click();
	}
}
