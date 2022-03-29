package ParallelExecution_DataProvider;

import org.testng.annotations.Test;

public class TestClass3 {
	
	@Test
	public void test1() {
		
		System.out.println("TestClass3 >> testMethod9 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		
		System.out.println("TestClass3 >> testMethod10 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() {
		
		System.out.println("TestClass3 >> testMethod11 >> "+Thread.currentThread().getId());
	}
	
	

}
