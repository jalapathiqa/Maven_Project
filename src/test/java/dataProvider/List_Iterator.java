package dataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//	********************** Two dimensional data provider ************************

// two dimensional array in return type of single dimensional array

@Test(dataProvider = "dp5")
public class List_Iterator {

	public void returnTypesDataprovider(String s) {

		System.out.println(s);
		
	}

	@DataProvider
	public Iterator<String> dp5() {
	
		List<String> data = new ArrayList<String>();
		data.add("Jp");
		data.add("Reddy");
		return data.iterator();
	}
}
