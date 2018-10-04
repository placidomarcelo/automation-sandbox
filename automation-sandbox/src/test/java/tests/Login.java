package tests;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AccountPage;
import pages.LoginPage;
import reports.ExtentReportsClass;

public class Login extends ExtentReportsClass {

	WebDriver driver;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void after(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test case passed");
		} else {
			logger.log(LogStatus.FAIL, "Test case failed");
		}

		driver.quit();
	}

	@Test(priority = 0, description = "Valid login with correct username and password.")
	public void loginComSucesso() throws InterruptedException {

		logger = extent.startTest("Valid login with correct username and password.");

		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);

		loginPage.visita();

		loginPage.performLogin("demouser", "abc123");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "Performing login.");

		assertTrue(accountPage.isValida());
		logger.log(LogStatus.INFO, "Validating if user is logged.");

	}

	@Test(dataProvider = "getData", priority = 1, description = "Invalid login with incorrect username and password.")
	public void autenticaFalha(String username, String password) {
		logger = extent.startTest("Invalid login with incorrect username and password.");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.visita();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		loginPage.performLoginWithFailBoolean(username, password);
		logger.log(LogStatus.INFO, "Validating if user is not logged.");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] credentials = { { "Demouser", "abc123" }, { "demouser_", "xyz" }, { "demouser", "nananana" },
				{ "Demouser", "abc123" } };

		return credentials;

	}
}
