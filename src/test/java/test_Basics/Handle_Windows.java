package test_Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Windows {

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
//		
//		// create objects of Hashmap class
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		ChromeOptions options = new ChromeOptions();
//		
//		// set the notification setting it will override the default setting
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//		options.addArguments("disable-notifications");
//		options.setExperimentalOption("prefs", prefs);
////		options.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//		Thread.sleep(2000);

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(2000);

//		// Singlw Window:
//		
//		String parentWindow = driver.getWindowHandle();
//		System.out.println("Parent window handle- " + parentWindow + driver.getTitle());
//		driver.findElement(By.id("newWindowBtn")).click();
//		Set<String> windowHandles = driver.getWindowHandles();
//
//		for (String windowHandle : windowHandles) {
//
//			if (!windowHandle.equals(parentWindow)) {
//				driver.switchTo().window(windowHandle);
//				// driver.manage().window().maximize();
//				driver.findElement(By.id("firstName")).sendKeys("Jp reddy");
//				Thread.sleep(3000);
//				driver.close();
//				Thread.sleep(3000);
//			}
//
////			System.out.println(windowHandle + driver.getTitle());
//
//		}
//
//		driver.switchTo().window(parentWindow);
//		Thread.sleep(2000);
//		driver.findElement(By.id("name")).sendKeys("jpreddy");

		// Single Tab:

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window handle- " + parentWindow + driver.getTitle());
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {

			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.findElement(By.id("alertBox")).click();
				Thread.sleep(3000);
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.id("output")).getText());
				Thread.sleep(3000);
				driver.close();
				
			}

//					System.out.println(windowHandle + driver.getTitle());

		}

		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("jpreddy");
		Thread.sleep(3000);
		driver.quit();

	}

}
