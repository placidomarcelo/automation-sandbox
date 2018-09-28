package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	 
	 private WebDriver driver;
	 By invoiceList = By.xpath("//h2[contains(text(),'Invoice List')]");
	 By temListagemInvoices = By.xpath("//a[@href='/invoice/0']");
	 
	 
	 public AccountPage(WebDriver driver) {
	   this.driver = driver;
	 }
	 
	 public boolean isValida() {
	   return (invoiceList() !=null) && temListagemInvoices();
	 }
	 
	 public WebElement invoiceList() {
		   return driver.findElement(invoiceList);
		 }
	 
	 public boolean temListagemInvoices() {
	   return driver.findElement(temListagemInvoices) !=null;
	 }
	 
	 	 	 
	}
