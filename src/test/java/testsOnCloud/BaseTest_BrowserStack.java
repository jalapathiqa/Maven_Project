package testsOnCloud;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_BrowserStack {
	
	public static String userName = "jalapathikalagir_oU43RO";
	public static String AccessKey =  "bKNAUqocU4WGAxZvtG8X";
	public static String URL = "https://" + userName + ":" + AccessKey + "@hub-cloud.browserstack.com/wd/hub";

	
	WebDriver driver;

	@Parameters({ "browser", "browser_version", "os", "os_version" })
	@BeforeMethod
	public void setup(String browserName, String browser_version, String os, String os_version, Method name) {

		String methodName = name.getName();
		
		System.out.println("broser name " + browserName);

//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("os", "Windows");
//		cap.setCapability("os_version", "11");
//		cap.setCapability("browserVersion", "latest");
//		cap.setCapability("name", "jpreddy's first test");
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("username", userName);
		caps.setCapability("accessKey",AccessKey);
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser", browserName);
		caps.setCapability("browser_version", browser_version);
		caps.setCapability("name", methodName);

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			caps.setCapability("browser", "Chrome");
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			caps.setCapability("browser", "Firefox");
		}

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
