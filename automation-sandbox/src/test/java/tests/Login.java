package tests;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AccountPage;
import pages.LoginPage;
import reports.ExtentReportsClass;
import utility.ConfigReader;

public class Login extends ExtentReportsClass{

	@Test (priority = 0, description="Valid login with correct username and password.")
	public void loginComSucesso() throws InterruptedException {
		
		logger = extent.startTest("Valid login with correct username and password.");
		
		ConfigReader config = new ConfigReader();
		
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		WebDriver driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.visita();
		loginPage.performLogin("demouser", "abc123");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		AccountPage accountPage = new AccountPage(driver);
		
		assertTrue(accountPage.isValida());
		
		if (accountPage.isValida()) {
			logger.log(LogStatus.PASS, "Test case passed");
		}else {
			logger.log(LogStatus.FAIL, "Test case failed");
		}
		
		driver.quit();
		}
	
	
	
	@Test (dataProvider = "getData", priority = 1, description="Invalid login with incorrect username and password.")
	public void autenticaFalha(String username, String password) {
		logger = extent.startTest("Invalid login with incorrect username and password.");
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.visita();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		if (loginPage.performLoginWithFailBoolean(username, password)) {
			logger.log(LogStatus.PASS, "Test case passed");
		}else {
			logger.log(LogStatus.FAIL, "Test case failed");
			
		}
		
		driver.quit();
		
		
	}
	
	@DataProvider 
	public Object[][] getData() {
		Object[][] credentials = {
				{"Demouser", "abc123"},
				{"demouser_", "xyz"},
				{"demouser", "nananana"},
				{"Demouser", "abc123"}
		};

		return credentials;
	
	}
	}
