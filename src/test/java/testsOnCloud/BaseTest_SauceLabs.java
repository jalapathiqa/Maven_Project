package testsOnCloud;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_SauceLabs {
	
	public static String userName = "oauth-jpreddy911-5575a";
	public static String AccessKey =  "2aaae846-90ff-4acf-81e5-2e394b368b7f";
	public static String URL = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	WebDriver driver;

	@Parameters({ "browser", "platform" })
	@BeforeMethod
	public void setup(String browserName, String platformName, Method name) {

		String methodName = name.getName();
		
		System.out.println("broser name " + browserName);

		MutableCapabilities mutableCap = new MutableCapabilities();
		mutableCap.setCapability("name", methodName);
		mutableCap.setCapability("build", "java-w3c-examples");
		mutableCap.setCapability("seleniumVersion", "4.1.3");
		mutableCap.setCapability("username", userName);
		mutableCap.setCapability("accessKey",AccessKey);
		mutableCap.setCapability("tags", "w3c-chrome-tests");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", mutableCap);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", platformName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
		}

		try {
			driver = new RemoteWebDriver(new URL(URL), cap);
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
