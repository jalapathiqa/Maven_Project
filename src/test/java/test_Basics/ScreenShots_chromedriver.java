package test_Basics;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots_chromedriver {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		// create objects of Hashmap class
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions options = new ChromeOptions();

		// set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("disable-notifications");
		options.setExperimentalOption("prefs", prefs);
//		options.addArguments("--headless");
		
		//with chrome driver
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.ca");
		Thread.sleep(2000);

		// File
		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots-Fail/img111.jpg");
		FileUtils.copyFile(sourceFile, destFile);

		// Bytes
		byte[] bytearr = driver.getScreenshotAs(OutputType.BYTES);
		File destFile1 = new File("./Screenshots-Fail/img222.jpg");
		FileOutputStream fos = new FileOutputStream(destFile1);
		fos.write(bytearr);
		fos.close();
		
		
		// Base64
		String base64 = driver.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr = Base64.getDecoder().decode(base64);
		File destFile2 = new File("./Screenshots-Fail/img333.jpg");
		FileOutputStream fos1 = new FileOutputStream(destFile2);
		fos1.write(byteArr);
		fos1.close();

		driver.quit();

	}

}
