package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//	********************** Two dimensional data provider ************************
	
	// two dimensional array in return type of single dimensional array
	
	@Test(dataProvider = "dp5", enabled = false)
	public class Object__TowDimensional {

		public void returnTypesDataprovider(String[] s) {

			System.out.println(s[0] + ">>" +s[1]);
		}

	@DataProvider
	public String[][] dp5() {
		
		String[][] data = new String [][] {
			
			{"Jp", "1"},
			{"reddy", "2"}
		};
		return data;
	}
	}

	



