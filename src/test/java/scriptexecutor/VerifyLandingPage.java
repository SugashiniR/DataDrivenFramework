package scriptexecutor;

import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import pagefactory.LandingPage;
import utilities.ReadExcel;
import utilities.ReuseFunctions;



public class VerifyLandingPage extends Base {
	
	ReuseFunctions rf=new ReuseFunctions();
	static Logger log = Logger.getLogger(VerifyLandingPage.class);
	
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeSuite
	public void initlog() {
		
		PropertyConfigurator.configure("C:\\Users\\HP\\Desktop\\Edrive\\SugaProjects\\DataDriven2\\src\\test\\resources\\log4j.properties");
		//log.info("Execution Started !!!");
	
	}
	
	@BeforeClass
	public void extentreportinit() {
		//report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		report = new ExtentReports(System.getProperty("C:\\Users\\HP\\Desktop\\Edrive\\SugaProjects\\DataDriven2\\MyReports")+"ExtentReportResults.html");
		test = report.startTest("Extent Report will be generated");	
	}
	
@BeforeMethod
public static void testone() {
	Base.browserlaunch();
	log.info("Browser launched");
}
@DataProvider(name="samplesite")
public Object[][] TestDataEx2(){
	
	ReadExcel ExcelData=new ReadExcel("C:\\Users\\HP\\Desktop\\Edrive\\SugaProjects\\DataDriven2\\src\\test\\resources\\TestData1.xls");
	
	int rows=ExcelData.getRowCount("SearchTest");
	
	rows=rows-1;
	
	System.out.println(rows);
	
	Object[][] excelobj=new Object[rows][3];
	
	int Ncol=4;

	int ci=0;
	
	for(int i=1; i<=rows; i++,ci++) {
		int cj=0;
		for(int j=1; j<Ncol;j++,cj++) {
			
			excelobj[ci][cj] = ExcelData.getData("SearchTest", i, j);
			System.out.println(excelobj[ci][cj]);
		}
	}		
	return excelobj;
	
}

@Test(dataProvider="samplesite")
public void fourthscript(String name,String email,String msg) throws InterruptedException {

    Thread.sleep(3000);
	LandingPage ln=new LandingPage(driver);
	
	try {
		ln.enterName(name);
		test.log(LogStatus.PASS, "Name entered sucessfully");
		log.info("log message for name enter");
	} catch (TimeoutException e) {
		log.error("Enter name method call takes more than expected time");
	}
//	Thread.sleep(2000);
//	try {
//		ln.enterEmail(email);
//		test.log(LogStatus.PASS, "Email entered sucessfully");
//	} catch (Exception e) {
//		//log.error("Enter Email method call takes more than expected time");
//		test.log(LogStatus.FAIL, "Not able to enter email");
//	}
//	Thread.sleep(2000);
//	ln.enterMessage(msg);
//	test.log(LogStatus.PASS, "Message entered sucessfully");
//	Thread.sleep(5000);
//	ln.clickbutton();
}
@AfterMethod
public void DriverClose() {
	driver.close();
	System.out.println("Test completed");
	log.info("All test executed successfully");
}

@AfterClass
public static void endTest()
{
report.endTest(test);
report.flush();
}

//@AfterSuite
//public void quitbrowser() {
//	System.out.println("AFter suite method called");
//	driver.quit();
//}

}
