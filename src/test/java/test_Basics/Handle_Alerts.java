package test_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import openBrowsers.startBrowser;

public class Handle_Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		//ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("ExcludeSwitches", new String []
		// {"enable-automation"});
		// options.addArguments("--headless");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

//		Thread.sleep(2000);
//		driver.findElement(By.id("alertBox")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.switchTo().alert().getText());
//		
//		driver.switchTo().alert().accept();
//		System.out.println(driver.findElement(By.id("output")).getText());

//		driver.findElement(By.id("confirmBox")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		System.out.println(driver.findElement(By.id("output")).getText());
//		Thread.sleep(5000);
//		driver.findElement(By.id("confirmBox")).click();
//		// Thread.sleep(2000);
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().dismiss();
//		System.out.println(driver.findElement(By.id("output")).getText());

		
		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Jpreddy");
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		Thread.sleep(5000);
		driver.findElement(By.id("promptBox")).click();
		// Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("output")).getText());
		
		
		driver.quit();

	}

}
