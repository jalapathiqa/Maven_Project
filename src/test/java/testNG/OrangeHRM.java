package testNG;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters("broswerName")
	@BeforeTest
	public void initialiseBrowser(String broswerName) {		
		switch (broswerName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
			optionsChrome.addArguments("start-maximized");
			driver = new ChromeDriver(optionsChrome);
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionsFF = new FirefoxOptions();
			optionsFF.setCapability("excludeSwitches", new String [] {"enable-automation"});
			optionsFF.addArguments("start-maximized");
			driver = new FirefoxDriver(optionsFF);
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions optionsEdge = new EdgeOptions();
			optionsEdge.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
			optionsEdge.addArguments("start-maximized");
			driver = new EdgeDriver(optionsEdge);
			break;
		default:
			System.out.println("browserName is invalid");
			break;
		}
		
		
	}
	
	@AfterTest
	public void TearDown() {
		
		driver.quit();
	}
	@Parameters("url")
	@Test(priority = 1)
	public void LaungApp(String url) {		
		
		driver.get(url);
	}
	
	@Parameters({"username", "password"})
	@Test(priority = 2)
	public void EnterLoginDetails(String username , String password) {
		driver.findElement(By.name("txtUsername")).sendKeys("username");
		driver.findElement(By.name("txtPassword")).sendKeys("password");
		driver.findElement(By.name("Submit")).click();
	}
	
	@Test(priority =3)
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
	}

	
	@Test(priority = 4)
	public void VerifyMyInfo() {
		
		boolean actualValue = driver.findElement(By.id("employee-details")).isDisplayed();		
		assertTrue(actualValue);
		
	}
	@Test(priority = 5)
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
		
	}

	

}
