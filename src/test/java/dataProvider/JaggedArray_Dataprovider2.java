package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//	********************** Two dimensional data provider ************************

// two dimensional array in return type of single dimensional array

@Test(dataProvider = "dp5")
public class JaggedArray_Dataprovider2 {

	public void returnTypesDataprovider(Object[] s) {

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			
		}
		System.out.println(">>>>>");
	}

	@DataProvider
	public Object[][] dp5() {

		Object[][] data = new Object[][] {

				{ "Jp", 1, 87, "Kala" }, 
				{ "reddy", 2 }, 
				{ "J1", 2, 887, "Kala3" }
			};
		return data;
	}
}
