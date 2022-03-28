package extent_Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extent_logs1 {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();
		File file = new File("extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extent.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.ca/");
		
		String dese64Code = captureScreenShot();
		String path = captureScreenShot("Google.jpg");
		
		// Base64:
		
//		extent.createTest("Screenshot Test 1", "This is attaching screenShot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromBase64String(dese64Code);
//		
//		extent.createTest("Screenshot Test 2", "This is attaching screenShot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromBase64String(dese64Code, "Google home page");
		
		// Path:
		
		extent.createTest("Screenshot Test 3", "This is attaching screenShot to the test at the test level")
		.info("This is a info msg")
		.addScreenCaptureFromPath(path);
		
		extent.createTest("Screenshot Test 4", "This is attaching screenShot to the test at the test level")
		.info("This is a info msg")
		.addScreenCaptureFromPath(path, "Google home page")
		.addScreenCaptureFromPath(path, "Google home page1")
		.addScreenCaptureFromPath(path, "Google home page2")
		.addScreenCaptureFromPath(path, "Google home page3")
		.addScreenCaptureFromPath(path, "Google home page4");
		
		extent.createTest("ScreenShot Test 5", "This is for attaching the screenshot for Failed Test")
		.info("this is info msg")
		.fail(com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page5").build());
		
		extent.createTest("ScreenShot Test 6", "This is for attaching the screenshot for Failed Test")
		.info("this is info msg")
		.fail("this is info message",com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page5").build());
		
		Throwable t = new Throwable("This is thowable exception");
		extent.createTest("ScreenShot Test 7", "This is for attaching the screenshot for Failed Test")
		.info("this is info msg")
		.fail(t, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page5").build());
		
		extent.createTest("ScreenShot Test 8", "This is for attaching the screenshot for Failed Test")
		.info("this is info msg")
		.fail(t, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page5").build())
		.fail(t, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page6").build())
		.fail(t, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page7").build());
		
		extent.flush();
		
		driver.quit();

		// Open Report automatically:		
		//File file = new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Workspace\\Maven_Project\\ExtentReports\\extentReport");		
		Desktop.getDesktop().browse(new File("extentReport.html").toURI());
	}
	
	public static String captureScreenShot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String dese64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		
	return dese64Code;
	}
	
	public static String captureScreenShot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots-Fail/"+ fileName);
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		
	return destFile.getAbsolutePath();
	}

}
