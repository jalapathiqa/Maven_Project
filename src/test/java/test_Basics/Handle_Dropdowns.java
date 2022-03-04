package test_Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Dropdowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("ExcludeSwitches", new String []
		// {"enable-automation"});
		//options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		// Thread.sleep(2000);
		System.out.println(driver.getTitle().toString());

		// Dropdown

		WebElement courseName = driver.findElement(By.id("course"));

		Select courseNameDrodown = new Select(courseName);

		String selectText = courseNameDrodown.getFirstSelectedOption().getText();

		System.out.println("selected visible text: " + selectText);

		courseNameDrodown.selectByVisibleText("Java");
		System.out.println(courseName.getAttribute("value"));

		courseNameDrodown.selectByIndex(0);
		System.out.println(courseName.getAttribute("value"));

		List<WebElement> courseOptions = courseNameDrodown.getOptions();

		for (WebElement courses : courseOptions) {
			System.out.println(courses.getText());
		}

		// multiple select:
		
		System.out.println("******* ide drop down options *******");

		WebElement ideElement = driver.findElement(By.id("ide"));

		Select ideDropDown = new Select(ideElement);
		List<WebElement> ideOptions = ideDropDown.getOptions();
		for (WebElement webElement : ideOptions) {
			System.out.println(webElement.getText());
		}
		
		ideDropDown.selectByIndex(0);
		System.out.println("select eclipse: "+ideElement.getText());
		Thread.sleep(3000);

		ideDropDown.selectByValue("ij");
		System.out.println("select Intelli J: "+ideElement.getText());
		Thread.sleep(3000);

		
		ideDropDown.selectByVisibleText("NetBeans");
		System.out.println("Select NB: "+ideElement.getText());
		Thread.sleep(3000);

		
		ideDropDown.deselectByVisibleText("IntelliJ IDEA");
		Thread.sleep(3000);
		
		System.out.println("****** selected list ******");
		
		List<WebElement> selectedOptions = ideDropDown.getAllSelectedOptions();
		for (WebElement SelectedList : selectedOptions) {
			System.out.println(SelectedList.getText());
		}

		
	}
}
