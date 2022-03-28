package dataProvider;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_OrangeHRM_WithExcelData {
	WebDriver driver;

	@Test(dataProvider = "getData", dataProviderClass = ReadExcel.class)
	public void EnterLoginDetails(String userName, String password) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		optionsChrome.addArguments("start-maximized");
		driver = new ChromeDriver(optionsChrome);

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

		driver.findElement(By.name("txtUsername")).sendKeys(userName);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();

		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));

		Thread.sleep(3000);

		driver.quit();
	}

	
}
