package pages;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
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
	By invoiceDueDate = By.xpath("//span[contains(text(),'Due Date:')]");
	By invoiceNumber = By.xpath("//h6[@class='mt-2']");
	By bookingCode = By.xpath("//td[contains(text(),'Booking Code')]//following-sibling::td");
	By customerDetails = By.xpath("//h5[contains(text(),'Customer Details')]//following-sibling::div");
	By room = By.xpath("//td[contains(text(),'Room')]//following-sibling::td");
	By checkInDate = By.xpath("//td[contains(text(),'Check-In')]//following-sibling::td");
	By checkOutDate = By.xpath("//td[contains(text(),'Check-Out')]//following-sibling::td");
	By totalStayCount = By.xpath("//td[contains(text(),'Total Stay Amount')]//following-sibling::td");
	By totalStayAmount = By.xpath("//td[contains(text(),'Total Stay Amount')]//following-sibling::td");
	By depositNow = By.xpath("//td[contains(text(),'USD $20.90')]");
	By taxVat = By.xpath("//td[contains(text(),'USD $19')]");
	By totalAmount = By.xpath("//td[contains(text(),'USD $209')]");

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

	public void validateHotelName(String hotelName) {
		assertEquals (hotelName , this.hotelName());
		
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
		assertEquals (InvoiceNumber , this.invoiceDueDate().split(" ")[1].split("#")[1]);
	}

	public String bookingCode() {
		return retrieveWebElementText(bookingCode);

	}

	public void validateBookingCode(String Booking) {
		assertEquals (Booking , this.bookingCode());
	}

	public List<String> customerDetails() {
		List<WebElement> customerdetails = driver.findElements(customerDetails);
		List<String> list = new ArrayList<String>();
		for (WebElement a : customerdetails) { // percorre elementos adicionando na 'list' o 'text' deles.
			list.add(a.getText());
		}
		return list;
	}

	public void validateCustomerDetails(String name, String address, String number) {
		boolean boolControl;
		boolControl = true;
		for (String stringCustomerDetails : customerDetails()) {
			if (stringCustomerDetails.equals(name) || stringCustomerDetails.equals(address)
					|| stringCustomerDetails.equals(number)) {
				continue;
			} // achou, não faz nada!
			else {
				boolControl = false; // caso não tenha a entrada seta para falso e para a execução, se não e
				break;
			}
		}
		assertEquals(boolControl, "true"); // confirma que achou todos elementos... se estiver 'false' não achou
											// algo....
	}

	// metodo room e validação room
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

	// method Total Stay and validação Total Stay
	public String totalStayCount() {
		return retrieveWebElementText(totalStayCount);
	}
	
	public void validateTotalStayCount(String totalStay) {
		assertEquals(totalStay, this.totalStayCount());
		
	}
	
	// method Total Stay Amount and validação Total Stay AMount
	public String totalStayAmount() {
		return retrieveWebElementText(totalStayAmount);
	}
	
	public void validateTotalStayAmount(String totalStayAmount) {
		assertEquals(totalStayAmount, this.totalStayAmount);
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
		assertEquals (taxvat , this.taxVat());
	}

	public String totalAmount() {
		return retrieveWebElementText(totalAmount);

	}

	public void validateTotalAmount(String totalamount) {
		assertEquals (totalamount , this.totalAmount());
	}

}
