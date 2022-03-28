package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//	********************** Two dimensional data provider ************************

// two dimensional array in return type of single dimensional array

@Test(dataProvider = "dp5")
public class JaggedArray {

	public void returnTypesDataprovider(String[] s) {

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			
		}
		System.out.println(">>>>>");
	}

	@DataProvider
	public String[][] dp5() {

		String[][] data = new String[][] {

				{ "Jp", "1", "87", "Kala" }, 
				{ "reddy", "2" }, 
				{ "J1", "2", "887", "Kala3" }
			};
		return data;
	}
}
