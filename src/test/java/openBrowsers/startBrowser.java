package openBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class startBrowser {

	public static void main(String[] args) throws InterruptedException {
		startBrowser start = new startBrowser();
		start.browser("https://eenadu.net");
	}

	public static void browser(String url) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("ExcludeSwitches", new String[] { "enable-automation" });
//		options.addArguments("--headless");

//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//		Thread.sleep(2000);

		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
	}

}
