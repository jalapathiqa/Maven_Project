package test_Basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Frames {

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();

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
//		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
//		Thread.sleep(2000);

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(2000);

		driver.findElement(By.id("name")).sendKeys("TEXT 1");
		Thread.sleep(3000);
		
		driver.switchTo().frame("frm1");
		Thread.sleep(2000);
		
		WebElement courseDD = driver.findElement(By.id("course"));
		Select courseDropDown = new Select(courseDD);
		courseDropDown.selectByVisibleText("Python");
		Thread.sleep(3000);
		
	List<WebElement>	courseList = courseDropDown.getOptions();
		for (WebElement listOfCourses : courseList) {
			System.out.println(listOfCourses.getText());
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("TEXT 2");
		Thread.sleep(3000);
		
		driver.switchTo().frame("frm1");
		Thread.sleep(2000);
		
		courseDropDown.selectByVisibleText("Java");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frm2");
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Jpreddy");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("TEXT 3");
		//driver.quit();
	}

}
