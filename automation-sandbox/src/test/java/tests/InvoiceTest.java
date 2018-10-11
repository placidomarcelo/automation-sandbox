package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BookingPage;
import pages.InvoicePage;
import pages.LoginPage;
import reports.ExtentReportsClass;
import utility.ConfigReader;

/**
 * Validate invoice page.
 */

public class InvoiceTest extends ExtentReportsClass {
	WebDriver driver;
	ConfigReader config = new ConfigReader();

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
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

	@Test(priority = 2, description = "Validate the invoice information displayed on the screen.")
	public void autenticainvoice() {
		logger = extent.startTest("Validate the invoice information displayed on the screen.");

		LoginPage loginPage = new LoginPage(driver);
		BookingPage bookingPage = new BookingPage(driver);

		loginPage.visita();
		loginPage.performLogin("demouser", "abc123");

		bookingPage.selecionaInvoice();
		InvoicePage invoicepage = new InvoicePage(driver);

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "Invoice";

		// Go to the page with the right title!
		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
				driver.switchTo().window(eachHandle);

			}
		}
		// Validate Hotel Name
		invoicepage.validateHotelName("Rendezvous Hotel");
		logger.log(LogStatus.INFO, "Validating Hotel name");

		// Validate Invoice Date
		invoicepage.validateInvoiceDate("14/01/2018");
		logger.log(LogStatus.INFO, "Validating Invoice date");

		// Validate Invoice Due Date
		invoicepage.validateInvoiceDueDate("15/01/2018");
		logger.log(LogStatus.INFO, "Validating Invoice Due Date");

		// Validate Invoice Number
		invoicepage.validateInvoiceInvoiceNumber("110");
		logger.log(LogStatus.INFO, "Validating Invoice Number");

		// Validate Booking Code
		invoicepage.validateBookingCode("0875");
		logger.log(LogStatus.INFO, "Validating Booking Code");

		// Validate Customer Details
		invoicepage.validateCustomerDetails("JOHNY SMITH", "R2, AVENUE DU MAROC", "123456");
		logger.log(LogStatus.INFO, "Validating Customer Details");

		// Validate Room
		invoicepage.validateRoomType("Superior Double");
		logger.log(LogStatus.INFO, "Validating Room");

		// Validate Check In
		invoicepage.validateCheckInDate("14/01/2018");
		logger.log(LogStatus.INFO, "Validating Check In");

		// Validate Check Out
		invoicepage.validateCheckOutDate("15/01/2018");
		logger.log(LogStatus.INFO, "Validating Check Out");

		// Validate Total Stay Count
		invoicepage.validateTotalStayCount("1");
		logger.log(LogStatus.INFO, "Validating Total Stay Count");

		// Validate Total Stay Amount
		invoicepage.validateTotalStayAmount("$150");
		logger.log(LogStatus.INFO, "Validating Total Stay Count");

		// Validate Deposit Now
		invoicepage.validateDepositNow("USD $20.90");
		logger.log(LogStatus.INFO, "Deposit Now");

		// Validate Tax&Vat
		invoicepage.validateTaxVat("USD $19.00");
		logger.log(LogStatus.INFO, "Tax&Vat");

		// Validate Total Amount
		invoicepage.validateTotalAmount("USD $209.00");
		logger.log(LogStatus.INFO, "Total Amount");

	}

}
