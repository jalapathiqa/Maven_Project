package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//	********************** Integer data provider ************************
	
	@Test(dataProvider = "dp3", enabled = false)
	public class Dataprovider_Integer {

		public void returnTypesDataprovider(int i) {

			System.out.println(i);
		}

	@DataProvider
	public Integer[] dp3() {
		
		Integer [] data = new Integer [] {
				 1,
				 2
		};	
		return data;
	}
	}
	

