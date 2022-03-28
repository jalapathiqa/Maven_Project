package openBrowsers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class startBrowser {
	static WebDriver driver;
	static String url;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		// options.addArguments("--headless");
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

//			WebDriverManager.firefoxdriver().setup();
//			WebDriver driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//			Thread.sleep(2000);

		// url = "https//eenadu.net";
		url = "https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html";
		driver.get(url);
		
		String path = screenShot("dropdown-elements-practice.jpg");
		screenShot(path);
		Thread.sleep(2000);

		driver.quit();
	}

	public static String screenShot(String fileName) {
		
		TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
		
		File sourceFile =	takesScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile =  new File("./Screenshots-Fail/"+fileName);
	
	try {
		FileUtils.copyFile(sourceFile, destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("Screenshot captured successfully");
	
	return destFile.getAbsolutePath();
		
	}

}
