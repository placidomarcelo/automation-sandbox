package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The class contains methods to select Invoices.
 */

public class BookingPage {
	WebDriver driver;
	
	By selecionaInvoice = By.xpath("//a[@href='/invoice/0']");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
}
	public void selecionaInvoice() {
		driver.findElement(selecionaInvoice).click();
	}
	
}

	

	
	
