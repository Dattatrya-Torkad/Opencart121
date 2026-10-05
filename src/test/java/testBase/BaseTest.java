package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
	public WebDriver driver;
	public Logger logger; // log4j
	public Properties P;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// Loading Config Properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		P = new Properties();
		P.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser name");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(P.getProperty("appURL")); // Reading URL from Properties file
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

	public String random() {

		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String Randomnum() {
		String randomnumbers = RandomStringUtils.randomNumeric(10);
		return randomnumbers;
	}

	public String Alphanumeric() {
		String Alpha = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(4);
		return (Alpha + num);
	}

}
