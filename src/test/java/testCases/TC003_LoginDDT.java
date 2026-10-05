package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseTest {
	@Test(dataProvider = "Logindata", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("** Starting TC003_LoginDDT Test **");

		Homepage hp = new Homepage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();

		/*LoginPage lp = new LoginPage(driver);
		lp.Enteremail(email);
		lp.Enterpassword(pwd);
		lp.Clicklogin();

		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetpage = ap.verify_MyAccount();

		/*
		 * Conditions Data is Valid >> Login successful >> TC Pass Data is valid >>
		 * Login Failed >> TC Fail
		 * 
		 * Data is invalid >> Login successful >> TC Failed Data is invalid >> Login
		 * Failed >> TC Pass
		 */

		/*if (exp.equalsIgnoreCase("valid")) {
			if (targetpage == true) {

				ap.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		}
		if (exp.equalsIgnoreCase("invalid")) {
			if (targetpage == true) {
				ap.clickLogout();
				Assert.assertTrue(false);

			} else {
				Assert.assertTrue(true);
			}

		}*/

		logger.info("** Finished TC003_LoginDDT Test **");
	}
}
