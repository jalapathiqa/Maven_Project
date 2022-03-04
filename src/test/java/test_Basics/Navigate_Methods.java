package test_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_Methods {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("ExcludeSwitches", new String []
		// {"enable-automation"});
		//options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.ca/");
		// Thread.sleep(2000);
		System.out.println(driver.getTitle().toString());
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials");
		driver.findElement(By.name("q")).submit();
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("jpreddy");
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
