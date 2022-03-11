package test_Basics;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		driver.manage().window().maximize();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
		
		driver.get("https://testproject.io/");
		
		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.linkText("Login")).click();		
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String windowHandle : windowHandles) {
			if(!windowHandle.equals(parentWindow)) {
			driver.switchTo().window(windowHandle);
			

			
			// using Funcation:
//			Function<WebDriver, Boolean> f = new Function<WebDriver, Boolean>() {
//
//				public Boolean apply(WebDriver webDriver) {
//					// TODO Auto-generated method stub
//					return webDriver.findElement(By.id("username")).isDisplayed();
//				}
//				
//			};
//			wait.until(f);
			
			wait.until(new Function<WebDriver, Object>() {
				public Object apply(WebDriver d) {
					return d.findElement(By.id("username")).isDisplayed();
				}
			});
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			
			driver.findElement(By.id("username")).sendKeys("JPReddy_UserName");
			System.out.println(driver.findElement(By.id("username")).getAttribute("value"));
			
			}
			
		}
		

		driver.quit();

	}

}
