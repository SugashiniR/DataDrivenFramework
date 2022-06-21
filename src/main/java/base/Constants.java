package base;

import java.util.ArrayList;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * In this class, declared and initialised Static variables and constants.
 * 
 * @author V414161
 *
 */

public class Constants 
{ 
	public static final boolean Dataproviderparallel =true; 
	public static final boolean  Retryenalbled = true;
	public static final int DataproviderThreadcount=50;
	public static final boolean GRIDMODE =false;
	public static final boolean RunEnterMode =false;
	public static final String testsuitename = "ApplicaitonAutomationTestSuite";
	public static final String testname = "Regression";
	public static ExtentReports reports = new ExtentReports("Extent Reporting system");
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html");
	public static ExtentTest parentTest;
	public static final String extentReportPath = "Desktop\\Edrive\\SugaProjects\\DataDriven2\\MyReports";
	
}