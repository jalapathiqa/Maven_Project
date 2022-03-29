package ParallelExecution_DataProvider;

import org.testng.annotations.Test;

public class TestClass2 {
	
	@Test
	public void test1() {
		
		System.out.println("TestClass2 >> testMethod5 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		
		System.out.println("TestClass2 >> testMethod6 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() {
		
		System.out.println("TestClass2 >> testMethod7 >> "+Thread.currentThread().getId());
	}
	
	@Test
	public void test4() {
		
		System.out.println("TestClass1 >> testMethod8 >>"+Thread.currentThread().getId());
	}

}
