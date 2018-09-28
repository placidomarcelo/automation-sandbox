package tests;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LoginPage;
import utility.ConfigReader;

public class login {

	@Test
	public void loginComSucesso() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		

		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		WebDriver driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.visita();
		loginPage.performLogin("demouser", "abc123");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		AccountPage accountPage = new AccountPage(driver);
		
		assertTrue(accountPage.isValida());
		driver.quit();
		}
	
	
	@Test(dataProvider = "getData")
	public void autenticaFalha(String username, String password) {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.visita();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		loginPage.performLoginWithFail(username, password);
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
