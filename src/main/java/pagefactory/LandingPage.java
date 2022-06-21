package pagefactory;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReuseFunctions;


public class LandingPage {
	
	ReuseFunctions rf=new ReuseFunctions();
	
	WebDriver driver;
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	WebElement Hamburgermenu;
	@FindBy(xpath="//div[@id='hmenu-customer-name']")
	WebElement titlenav;
	
	@FindBy(xpath="//input[@id='et_pb_contact_name_0']")
	WebElement Name;
	@FindBy(xpath="//input[@id='et_pb_contact_email_0']")
	WebElement Email;
	@FindBy(xpath="//textarea[@name='et_pb_contact_message_0']")
	WebElement Message;

	By Button1=By.xpath("//div[@class='et_pb_row et_pb_row_2 et_pb_row_4col']/div[1]/div[1]/a[contains(text(),'Button')]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyheader() throws InterruptedException {
		
		Hamburgermenu.click();
		Thread.sleep(5000);
		String title=titlenav.getText();
		System.out.println(title);
	}
	
	public void enterName(String name) throws TimeoutException {
		rf.waitForWebElement(Name);
		Name.sendKeys(name);		
	}
	public void enterEmail(String email) throws TimeoutException {
		rf.waitForWebElement(Email);
		Email.sendKeys(email);
	}
	public void enterMessage(String msg) {
		Message.sendKeys(msg);
	}
	
	public void clickbutton() {
		rf.waitForElementToBeClickable(driver, Button1);
		driver.findElement(Button1).click();
	}

}
