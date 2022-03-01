package test_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_controls {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("ExcludeSwitches", new String [] {"enable-automation"});
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		//Thread.sleep(2000);
		System.out.println(driver.getTitle().toString());
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstName")).sendKeys("Jp");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("reddy");
		Thread.sleep(2000);
		driver.findElement(By.id("femalerb")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("englishchbx")).click();
		Thread.sleep(2000);

		WebElement hindCheck = driver.findElement(By.id("hindichbx"));
				hindCheck.click(); // checking
		Thread.sleep(2000);
		
		driver.findElement(By.id("frenchchbx")).click();
		Thread.sleep(2000);
		
		if(hindCheck.isSelected()) {
			hindCheck.click(); // un-checking
			System.out.println("hindCheck is selected and un-checked now");
		}else {
			System.out.println("hindCheck is not selected");
		}
		
		driver.findElement(By.id("registerbtn")).click();
		System.out.println(driver.findElement(By.id("msg")).getText());
		Thread.sleep(3000);
		
		driver.findElement(By.id("clearbtn")).click();
		
	}

}
