package dependenciesTestNG;

import org.testng.annotations.Test;

public class testGroupDependency {
	@Test(groups = "smoke1")
	public void test1() {
		System.out.println("testGroupDependency - smoke1");
	}
	
	@Test(groups = "smoke1")
	public void test2() {
		System.out.println("testGroupDependency - smoke1");
	}
	
	@Test(groups = "smoke2")
	public void test3() {
		System.out.println(5/0);
		System.out.println("testGroupDependency - smoke2");
	}
	
	@Test(groups = "smoke3", dependsOnGroups = "smoke2")
	public void test4() {
//		System.out.println(5/0);
		System.out.println("testGroupDependency - smoke3");
	}
	@Test(dependsOnGroups = {"smoke1","smoke2"} )
	public void test0() {
		System.out.println("main test");
	}

}
