package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	

	public Base() {
		
		prop=new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("C:\\Users\\HP\\Desktop\\Edrive\\SugaProjects\\DataDriven2\\src\\main\\java\\base\\Config.properties");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}	
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		} 	
	}
	
	
    
	public static void browserlaunch() {
        String browser=prop.getProperty("Browser");
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "F:\\SugaProjects\\DataDriven1\\src\\main\\java\\drivers\\chromedriver.exe");
     	    //driver = new ChromeDriver();		    
		    //Alternative for browser launch is WebDriver Manager or selenide API can be used
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		} else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get(prop.getProperty("url1"));
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	 
}

}

