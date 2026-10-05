package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest {

	@Test
	public void verify_login() {
		logger.info("** Starting TC002_Logintest **");

		try{
		Homepage hp = new Homepage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.Enteremail(P.getProperty("email"));
		lp.Enterpassword(P.getProperty("Password"));
		lp.Clicklogin();

		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetpage = ap.verify_MyAccount();
		
		Assert.assertTrue(targetpage);   //OR -->> Assert.assertEquals(targetpage, true, "Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("** Finished TC002_Logintest **");
	}
}
