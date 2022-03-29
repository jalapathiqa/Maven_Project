package testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class timeOut {
	static WebDriver driver;
	@Test(timeOut = 5000)
	public void testOut() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/");
		takeScreenShot();
		
		driver.quit();
	}
	
	public static void takeScreenShot() {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File sourceFile = 	takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots-Fail/timeOut.jpg");
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
