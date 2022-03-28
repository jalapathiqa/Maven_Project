package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser2 {

	WebDriver driver;

	@Test(priority = 1)
	public void openGoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		optionsChrome.addArguments("start-maximized");
		driver = new ChromeDriver(optionsChrome);
		driver.get("https://google.ca/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());

		Thread.sleep(3000);
		driver.quit();
	}

	
	@Test(priority = 2)
	public void openFB() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		optionsChrome.addArguments("start-maximized");
		driver = new ChromeDriver(optionsChrome);

		driver.get("https://facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Jp Reddy", Keys.ENTER);
		System.out.println(driver.getTitle());

		Thread.sleep(3000);
		driver.quit();
	}

}
