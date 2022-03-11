package openBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class startBrowser {
	static String url;
	public static void main(String[] args) throws InterruptedException {
				
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//options.addArguments("--headless");
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");

		WebDriver driver = new ChromeDriver(options);
		

//			WebDriverManager.firefoxdriver().setup();
//			WebDriver driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//			Thread.sleep(2000);

			//url = "https//eenadu.net";
		url = "https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html";
		driver.get(url);
			
			Thread.sleep(2000);
			
			driver.quit();
		}

	}


