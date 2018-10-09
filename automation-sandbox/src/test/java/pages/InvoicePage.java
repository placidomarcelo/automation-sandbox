package pages;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * The class contains methods to validate Invoice Page.
 */

public class InvoicePage {

	private WebDriver driver;
	By hotelName = By.xpath("//h4[@class='mt-5']");
	By invoiceDate = By.xpath("//section[@class='content']//ul//li[1]"); 
	By invoiceDueDate = By.xpath("//span[contains(text(),'Due Date:')]//..");
	By invoiceNumber = By.xpath("//h6[@class='mt-2']");
	By bookingCode = By.xpath("//td[contains(text(),'Booking Code')]//following-sibling::td");
	By customerDetails = By.xpath("//h5[contains(text(),'Customer Details')]//following-sibling::div");
	By room = By.xpath("//td[contains(text(),'Room')]//following-sibling::td");
	By checkInDate = By.xpath("//td[contains(text(),'Check-In')]//following-sibling::td");
	By checkOutDate = By.xpath("//td[contains(text(),'Check-Out')]//following-sibling::td");
	By totalStayCount = By.xpath("//td[contains(text(),'Total Stay Count')]//following-sibling::td");
	By totalStayAmount = By.xpath("//td[contains(text(),'Total Stay Amount')]//following-sibling::td");
	By depositNow = By.xpath("//td[contains(text(),'Deposit Nowt')]//..//..//../tbody//tr//td[1]");
	By taxVat = By.xpath("//td[contains(text(),'Tax&VAT')]//..//..//../tbody//tr//td[2]");
	By totalAmount = By.xpath("//td[contains(text(),'Total Amount')]//..//..//../tbody//tr//td[3]");

	public InvoicePage(WebDriver driver) {
		this.driver = driver;
	}

	public String retrieveWebElementText(By field) {
		WebElement element = driver.findElement(field);
		System.out.println(element.getText());
		return element.getText();
	}
	
	public void checkPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Invoice";
		assertEquals(expectedTitle, actualTitle);
	}

	public String hotelName() {
		return retrieveWebElementText(hotelName);
		

	}

	public boolean validateHotelName(String hotelName) {
		return (hotelName == this.hotelName());
			
		
	}

	public String invoiceDate() {
		return retrieveWebElementText(invoiceDate);
		
	}

	public void validateInvoiceDate(String InvoiceDate) {
		assertEquals (InvoiceDate , this.invoiceDate().split(" ")[2]);
	}

	public String invoiceDueDate() {
		return retrieveWebElementText(invoiceDueDate);
	}
	

	public void validateInvoiceDueDate(String InvoiceDueDate) {
		assertEquals (InvoiceDueDate , this.invoiceDueDate().split(" ")[2]);
	}

	public String invoiceNumber() {
		return retrieveWebElementText(invoiceNumber);
	}

	public void validateInvoiceInvoiceNumber(String InvoiceNumber) {
		assertEquals (InvoiceNumber , this.invoiceNumber().split(" ")[1].split("#")[1]);
	}

	public String bookingCode() {
		return retrieveWebElementText(bookingCode);

	}

	public void validateBookingCode(String Booking) {
		assertEquals (Booking , this.bookingCode());
	}

	public String customerDetails() {
		return retrieveWebElementText(customerDetails);
				
	}

	public void validateCustomerDetails(String name, String address, String number) {
		String s1 = this.customerDetails();
		
		assertTrue(Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(s1).find() &&
			Pattern.compile(Pattern.quote(address), Pattern.CASE_INSENSITIVE).matcher(s1).find() &&
			Pattern.compile(Pattern.quote(number), Pattern.CASE_INSENSITIVE).matcher(s1).find());
				
	}

	
	public String roomType() {
		return retrieveWebElementText(room);
	}
	
	public void validateRoomType(String room) {
		assertEquals(room, this.roomType());
	}
	

	public String checkInDate() {
		return retrieveWebElementText(checkInDate);

	}

	public void validateCheckInDate(String checkin) {
		assertEquals (checkin , this.checkInDate());
	}

	public String checkOutDate() {
		return retrieveWebElementText(checkOutDate);

	}

	public void validateCheckOutDate(String checkout) {
		assertEquals (checkout , this.checkOutDate());
	}

	public String totalStayCount() {
		return retrieveWebElementText(totalStayCount);
	}
	
	public void validateTotalStayCount(String totalStay) {
		assertEquals(totalStay, this.totalStayCount());
		
	}
	
	public String totalStayAmount() {
		return retrieveWebElementText(totalStayAmount);
	}
	
	public void validateTotalStayAmount(String totalStayAmount) {
		assertEquals(totalStayAmount, this.totalStayAmount());
	}
	

	public String depositNow() {
		return retrieveWebElementText(depositNow);

	}

	public void validateDepositNow(String depositnow) {
		assertEquals (depositnow , this.depositNow());
	}

	public String taxVat() {
		return retrieveWebElementText(taxVat);
		

	}

	public void validateTaxVat(String taxvat) {
		if (taxvat.endsWith(".00")) {
			taxvat = taxvat.substring(0, taxvat.lastIndexOf("."));
		}
		assertEquals (taxvat , this.taxVat());
	}

	public String totalAmount() {
		return retrieveWebElementText(totalAmount);

	}

	public void validateTotalAmount(String totalamount) {
		if (totalamount.endsWith(".00")) {
			totalamount = totalamount.substring(0, totalamount.lastIndexOf("."));
		}
		assertEquals (totalamount , this.totalAmount());
	}
	
}
