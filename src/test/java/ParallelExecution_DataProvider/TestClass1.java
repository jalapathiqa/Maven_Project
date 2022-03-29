package ParallelExecution_DataProvider;

import org.testng.annotations.Test;

public class TestClass1 {
	
	@Test
	public void test1() {
		
		System.out.println("TestClass1 >> testMethod1 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		
		System.out.println("TestClass1 >> testMethod2 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() {
		
		System.out.println("TestClass1 >> testMethod3 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test4() {
		
		System.out.println("TestClass1 >> testMethod4 >> "+Thread.currentThread().getId());
	}

}
