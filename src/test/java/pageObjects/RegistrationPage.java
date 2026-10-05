package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelphone;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmpass;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkpolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement BtnConfirm;
	
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtMessage;
	
	public void SetFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void SetLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void Setemail(String email) {
		txtemail.sendKeys(email);
	}

	public void Settelphone(String phone) {
		txttelphone.sendKeys(phone);
	}

	public void SetPassword(String pass) {
		txtpassword.sendKeys(pass);
	}

	public void SetConfirmPassword(String pass) {
		txtconfirmpass.sendKeys(pass);
	}

	public void setprivacypolicy() {
		chkpolicy.click();
	}

	public void setConfirmbutton() {
		BtnConfirm.click();
	}
	
	public String getConfirmation() {
	
	try {
		return (txtMessage.getText());
	}
	catch (Exception e)
	{
		 return (e.getMessage());
	}
}
}
