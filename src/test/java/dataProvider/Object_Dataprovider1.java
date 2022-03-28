package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	
//	********************** Object type data provider ************************
	
	@Test(dataProvider = "dp4", enabled = false)
	public class Object_Dataprovider1 {

		public void returnTypesDataprovider(Object i) {

			System.out.println(i);
		}

	@DataProvider
	public Object[] dp4() {
		
		Object[] data = new Object [] {
				1,
				"Jp",
				2,
				"Kalagiri"
		};
		
		return data;
	}
	}
	
	
