package listeners;

import static org.testng.Assert.assertTrue;

import org.apache.hc.core5.http.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ITestListenerClass.class})
public class TestClass1 {
	
	@Test
	public void testMethod1() {
		
		System.out.println("I'm test method 1");
	}
	
	@Test
	public void testMethod2() {
		
		System.out.println("I'm test method 2");
		assertTrue(false);
	}
	
	@Test(timeOut = 1000)
	public void testMethod3() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("I'm test method 3");
		

	}
	
	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {
		
		System.out.println("I'm test method 4");

	}

}
