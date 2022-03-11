package test_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPath {
	
//	XPath using Attributes
//	XPath Operators
//	XPath Conditions
//	XPath with Index
//	XPath Functions
//	XPath Axes
//	XPath Shortcuts
//	Third Party XPath Tools
//	Common Mistakes

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		examples();
		Attributes();
		
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
				element);
	}

	// types of XPath ():

	public static void examples() {

		driver.get("https://www.w3schools.com/");

		// absolute xpath
//		highlight(driver.findElement(By.xpath("/html/body/div[3]/a[4]")));

		// relative xpath
		highlight(driver.findElement(By.xpath(
				"//a[@class='w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 ws-hide-800']")));

	}

	public static void Attributes() {

		driver.get("https://www.w3schools.com/");
//		driver.findElement(By.xpath("//a[@id='w3loginbtn']")).click();
		driver.findElement(By.xpath("//a[@title=\"Search W3Schools\"]")).click();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("hello");

	}
	
	
	
	


}
