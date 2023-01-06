package testsOnCloud;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testGridOnBrowserStack extends BaseTest_BrowserStack{
	
	@Test
	public void loginSauceLabs() {
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	
	@Test
	public void inventoryCount() {
		loginSauceLabs();
		org.openqa.selenium.Dimension size=	driver.findElement(By.cssSelector(".inventory_item")).getSize();
		
		System.out.println("inventory "+size);
		
		//Assert.assertEquals(size, 6);
		
	}
	
	@Test
	public void addToCart() {
		loginSauceLabs();
		org.openqa.selenium.Dimension size1=	driver.findElement(By.xpath("//button[text()='Add to cart']")).getSize();
		
		System.out.println("added to cart "+size1);
		
	//	Assert.assertEquals(size1, 6);
		
	}

}
