package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//	********************** Two dimensional data provider ************************

// two dimensional array in return type of single dimensional array

@Test(dataProvider = "dp5")
public class TowDimentionalArray {

	public void returnTypesDataprovider(String u, String p) {

		System.out.println(u + ">>" + p);
	}

	@DataProvider
	public String[][] dp5() {

		String[][] data = new String[][] {

				{ "Jp", "1" }, { "reddy", "2" } };
		return data;
	}
}
