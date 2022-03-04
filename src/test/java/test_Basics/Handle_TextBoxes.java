package test_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_TextBoxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("ExcludeSwitches", new String [] {"enable-automation"});
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		//Thread.sleep(2000);
		System.out.println(driver.getTitle().toString());
		
	WebElement userName= driver.findElement(By.name("login"));
//	if(userName.isDisplayed()) {
//		if(userName.isEnabled()) {
//			userName.sendKeys("name entered");
//		String enteredText=	userName.getAttribute("value");
//			System.out.println(enteredText);
//			Thread.sleep(3000);
//
//			userName.clear();
//		}else
//			System.out.println("textbox is not enabled");
//		
//	}else
//		System.out.println("username text box is not displayed");
//		Thread.sleep(3000);
		//driver.quit();
	
	userName.sendKeys("name jalapathiqa entered");
	String enteredText = userName.getAttribute("value");
	System.out.println(enteredText);
		Thread.sleep(3000);
	
	}

}
