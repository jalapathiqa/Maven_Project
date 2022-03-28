package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeparateClass_dataProvider {
	
	@Test(dataProvider = "dp2", dataProviderClass= DataSupplier.class)
	public void test(String s) {
		
		System.out.println(s);
		
	}
	
}
