package utilities;

import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class ReuseFunctions {
		
	public void waitForWebElement( WebElement elementpath) throws TimeoutException {
		FluentWait<WebElement> wait = new FluentWait<WebElement>(elementpath);
		wait.withTimeout(Duration.ofSeconds(5000));
		wait.pollingEvery(Duration.ofSeconds(2000));
		wait.ignoring(NoSuchElementException.class);
		
		Function<WebElement, Boolean> f = new Function<WebElement, Boolean>() {
			
			public Boolean apply(WebElement elementpath) {
				if (elementpath.isDisplayed() && elementpath.isEnabled() == true) {
					return true;
				}
				return false;
			}
		};
		wait.until(f);
	
}
	
	/**
	 * Wait for element to appear on the webpage
	 * @param driver
	 * @param locatorObject
	 */
	public void waitForElementToBeVisible(WebDriver driver, By locatorObject) {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locatorObject));
	}


	/**
	 * Waits for element to become interactive/clickable
	 * @param driver
	 * @param locatorObject
	 */
	public void waitForElementToBeClickable(WebDriver driver, By locatorObject) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(locatorObject));
	}
	
	/**
	 * Wait for given time period
	 * @param milliseconds
	 */
	
	public void sleep(int milliseconds)
	 {	 try 
		 {
			Thread.sleep(milliseconds);
		 }
		 catch (InterruptedException e) 
		 {
			e.printStackTrace();
		 } 
	 }
	
}
