package baseClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public static WebDriver driver;
	public static String AppBrowser, userName, passWord, AppURL;
	public static Properties configProp;
	public static FileInputStream fis;
	public static String configFile = "C:\\Users\\kalag\\config.properties.txt";
	
	public static ExtentReports extentReporter;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;	
	public static String extentReports = "./ExtentReports/"+"Project-Report"+System.currentTimeMillis()+".html";
	
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		
		loadProperties();
		
		AppBrowser = configProp.getProperty("browser");		
		userName = configProp.getProperty("username");
		passWord = configProp.getProperty("password");
		AppURL = configProp.getProperty("urlOrange");

		extentReporter = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(extentReports);

		extentReporter.attachReporter(sparkReporter);

		
//		System.out.println(AppBrowser);
	}

	@BeforeClass
	public void beforeClass() {
		
		switch (AppBrowser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			options.addArguments("disable-notifications");
			options.addArguments("start-maximized");
//			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setCapability("excludeSwitches", new String[] {"enable-automation"});
			options1.addArguments("disable-notifications");
			options1.addArguments("start-maximized");
//			options1.addArguments("--headless");
			driver = new FirefoxDriver(options1);
			
			break;


		default:
			System.out.println("browser name is invalid");;
		}
		
		driver.get(AppURL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		extentTest = extentReporter.createTest(method.getName());
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		
		extentReporter.flush();
	}

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
	
	
	public static void loadProperties() throws IOException {
		
		configProp = new Properties();
		try {
			fis = new FileInputStream(configFile);
			configProp.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
