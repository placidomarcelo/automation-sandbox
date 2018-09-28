package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.BookingPage;
import pages.InvoicePage;
import pages.LoginPage;

/**
 * Validate invoice page.
 */

public class InvoiceTest {

	@Test
	public void autenticainvoice() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
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
						
		//Validate Invoice Date
		invoicepage.validateInvoiceDate("14/01/2018");
		
		//Validate Invoice Due Date
		invoicepage.validateInvoiceDueDate("15/01/2018");
		
		//Validate Invoice Number
		invoicepage.validateInvoiceInvoiceNumber("110");
		
		//Validate Booking Code
		invoicepage.validateBookingCode("0875");
		
		//Validate Customer Details
		invoicepage.validateCustomerDetails("JOHNY SMITH", "R2, AVENUE DU MAROC", "123456");
		
		//Validate Room
		invoicepage.validateRoomType("Superior Double");
		
		//Validate Check In
		invoicepage.validateCheckInDate("14/01/2018");
		
		//Validate Check Out
		invoicepage.validateCheckOutDate("15/01/2018");
		
		//Validate Total Stay Count
		invoicepage.validateTotalStayCount("1");
		
		//Validate Total Stay Amount
		invoicepage.validateTotalStayAmount("$150");

		//Validate Deposit Now
		invoicepage.validateDepositNow("USD $20.90");
		
		//Validate Tax&Vat
		invoicepage.validateTaxVat("USD $19.00");
		
		//Validate Total Amount
		invoicepage.validateTotalAmount("USD $209.00");
			
	}

}
