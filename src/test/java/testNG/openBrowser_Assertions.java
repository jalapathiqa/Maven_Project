package testNG;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser_Assertions {

	@Test(priority = 1)
	public void openGoogle() throws Exception {

		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://google.ca");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());

		String expectedTitle = "HYR Tutorials - Google Search";
		String actualTitle = driver.getTitle();

		assertEquals(expectedTitle, actualTitle, "Title is mismatched");
		assertTrue(true);

		Thread.sleep(3000);
		driver.quit();
	}

	@Test(enabled = true)
	public void openFB() throws Exception {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://facebook.com");
		driver.findElement(By.name("email")).sendKeys("Jp Reddy", Keys.ENTER);

		// title assertion

		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - Log In or Sign Up";
		
		
		System.out.println(actualTitle);
		assertEquals(actualTitle, expectedTitle, "Title is mismatched");

		// URL assertion
		SoftAssert softAssert = new SoftAssert();
		
		String actualURL = driver.getCurrentUrl();
//		String expectedURL = "https://facebook.com";
		String expectedURL = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjQ3NDk3MjU4LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
									
//		softAssert.assertEquals(actualURL, expectedURL, "URL is mismatched");
		
		// Text assertion

		String actualText = driver.findElement(By.name("email")).getAttribute("value");
//		String expectedText = " ";
		String expectedText = "Jp Reddy";

		softAssert.assertEquals(actualText, expectedText, "Username text is mismatched");

		// ErrorMessage assertion

		String actualErrorMessage = driver.findElement(By.xpath("//div[text()='The password you’ve entered is incorrect. ']")).getText();
//		String expectedErrorMessage = "The password you’ve entered is incorrect. Forgot Password?";
		String expectedErrorMessage = "Jp Reddy";

		softAssert.assertEquals(actualText, expectedText, "Error message is mismatched");

		Thread.sleep(3000);
		driver.quit();
		softAssert.assertAll();
	}

}
