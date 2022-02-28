package openBrowsers;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class start_Browsers {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("ExcludeSwitches", new String [] {"enable-automation"});
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://eenadu.net");
		//Thread.sleep(2000);
		System.out.println(driver.getTitle().toString());
		Thread.sleep(2000);
		driver.quit();
		//driver.close();
		
	}

}
