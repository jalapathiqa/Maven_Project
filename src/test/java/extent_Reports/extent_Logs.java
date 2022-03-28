package extent_Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extent_Logs {

	public static void main(String[] args) throws IOException {

com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();
		
		File file = new File("extentReport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extent.attachReporter(sparkReporter);
		
		extent.createTest("Test 1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2")
		.log(Status.INFO, "info3")
		.log(Status.PASS, "info1")
		.log(Status.WARNING, "info2")
		.log(Status.WARNING, "info3")
		.log(Status.SKIP, "info1")
		.log(Status.FAIL, "info2")
		.log(Status.PASS, "info3");
		
		



		
		
		extent.flush();

		// Open Report automatically:		
		//File file = new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Workspace\\Maven_Project\\ExtentReports\\extentReport");		
		Desktop.getDesktop().browse(new File("extentReport.html").toURI());

		
	}

}
