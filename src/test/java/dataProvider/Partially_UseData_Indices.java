package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Partially_UseData_Indices {
	
	@Test(dataProvider ="dataprovider7")
	public void test1(String s) {
		System.out.println(s);
	}
	
	
	@DataProvider(indices = {0, 2})
	public String[] dataprovider7() {
		
		String [] data = new String []
				{
						"Jp",
						"Reddy",
						"Kala",
						"Jala"
				};
		return data;
		
	}

}
