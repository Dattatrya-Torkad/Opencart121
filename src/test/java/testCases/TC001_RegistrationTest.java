package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

public class TC001_RegistrationTest extends BaseTest {

	@Test
	public void verify_account_registration() {

		logger.info(" **** Starting TC001_RegistrationTest ****");

		try {
			Homepage hp = new Homepage(driver);
			hp.ClickMyAccount();
			logger.info("Clicked on My Account link");
			hp.ClickRegister();
			logger.info("Clicked on My Register link");

			String pass = Alphanumeric();
			RegistrationPage rp = new RegistrationPage(driver);
			logger.info("Provide Customer details");
			rp.SetFirstName(random().toUpperCase());
			rp.SetLastName(random().toUpperCase());
			rp.Setemail(random() + "@gmail.com");
			rp.Settelphone(Randomnum());
			rp.SetPassword(pass);
			rp.SetConfirmPassword(pass);
			rp.setprivacypolicy();
			rp.setConfirmbutton();
			logger.info(" ** Validating expected message ** ");
			String confmsg = rp.getConfirmation();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test is failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}

}
