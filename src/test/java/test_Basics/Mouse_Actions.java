package test_Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Actions {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * MoveToElement or MouseOver 
		 * Click, 
		 * Double Click 
		 * Right Click or Context Click
		 */
		

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//options.addArguments("--headless");
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");

		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@name='Submit']")).click();
//		
//		// Click
//		
//		
//		
//		actions.moveToElement(driver.findElement(By.xpath("//a[.='Admin']")))
//		.moveToElement(driver.findElement(By.xpath("//a[text()='Organization']")))
//		.moveToElement(driver.findElement(By.xpath("//a[text()='Locations']")))
//		.click()
//		.perform();
//		
//		driver.findElement(By.id("searchLocation_name")).sendKeys("Hyderabad");
//		
//		// Double Click
//		
//		actions.doubleClick(driver.findElement(By.id("searchLocation_name"))).perform();
		
		// Right Click or contextClick
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
//		xpath = //span[text()='right click me']
//		xpath = //span[.='right click me']
		
		actions.contextClick(driver.findElement(By.xpath("//span[.='right click me']"))).perform();
		driver.findElement(By.xpath("//li[.='Edit']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
