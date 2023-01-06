package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	
	@Test
	public void testGrid() throws MalformedURLException, InterruptedException {
		
		// 1. define desired capabilities:
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("edge");
		cap.setPlatform(Platform.WIN10);
		
		//2. Chrome options definition:
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
//		options.setExperimentalOption("excludeSwitches", new String[]())
		
		String huburl = "http://192.168.1.72:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(huburl),options);
		
        driver.get("https://eenadu.net");
		
		Thread.sleep(3000);
		driver.quit();
	}

}
