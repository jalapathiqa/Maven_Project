package test_Basics;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_PageLoadTimeOut {

	public static void main(String[] args) {
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

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

		Instant startTime = Instant.now();
		System.out.println("Start time:- " + startTime.toString());

		driver.manage().window().maximize();
		driver.get("https://www.google.ca/");

//		driver.get("https://www.royalmansour.com/en/");

		Instant endTime = Instant.now();
		System.out.println("Start time:- " + endTime.toString());
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Page load time:- " + duration.toMillis() + " milli seconds");
		driver.getTitle();

		driver.quit();
	}
}
