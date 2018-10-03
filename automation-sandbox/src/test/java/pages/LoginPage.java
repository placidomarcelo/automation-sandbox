package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

/**
 * Log in with valid and invalid credentials.
 */
public class LoginPage {

	private WebDriver driver;
	private String url = "https://automation-sandbox.herokuapp.com/";
	By fieldUsername = By.xpath("//input[@name='username']");
	By fieldPassword = By.xpath("//input[@name='password']");
	By buttonSubmit = By.xpath("//button[@id='btnLogin']");
	By messageloginerror = By.xpath("//div[@class='alert alert-danger mt-3']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@BeforeMethod
	public void visita() {
		driver.get(url);
	}
	
	
	public void performLogin(String username, String password) {
		driver.findElement(fieldUsername).sendKeys(username);
		driver.findElement(fieldPassword).sendKeys(password);
		driver.findElement(buttonSubmit).click();  
	}
	
	
	public void performLoginWithFail(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(username, password);
		WebElement mensagemError = driver.findElement(messageloginerror);
		String mensagem = mensagemError.getText();
		assertEquals("Wrong username or password.", mensagem);
	}

	public boolean  performLoginWithFailBoolean(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(username, password);
		WebElement mensagemError = driver.findElement(messageloginerror);
		String mensagem = mensagemError.getText();
		System.out.println("Wrong username or password." +  mensagem);
		return ("Wrong username or password." == mensagem);
}
	}
