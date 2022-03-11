package test_Basics;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_ImplecitlyWait {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("txt1")).sendKeys("JPReddy_TextBox1");
		System.out.println(driver.findElement(By.id("txt1")).getAttribute("value"));
		
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("txt2")).sendKeys("JPReddy_TextBox2");
		System.out.println(driver.findElement(By.id("txt2")).getAttribute("value"));
		
		driver.quit();
		
		
	}

}
