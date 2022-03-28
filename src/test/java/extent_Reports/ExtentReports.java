package extent_Reports;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

	public static void main(String[] args) throws IOException {

		com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();
		
		File file = new File("extentReport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extent.attachReporter(sparkReporter);
		
		ExtentTest test1 = extent.createTest("Test 1");
		test1.pass("Test 1 is pass");
		
		ExtentTest test2 = extent.createTest("Test 2");
		test2.log(Status.FAIL, "Test 2 is Failed");
		
		extent.createTest("Test 3").skip("Test 3 is Skipped");

		extent.flush();

		// Open Report automatically:		
		//File file = new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Workspace\\Maven_Project\\ExtentReports\\extentReport");		
		Desktop.getDesktop().browse(new File("extentReport.html").toURI());

	}

}
