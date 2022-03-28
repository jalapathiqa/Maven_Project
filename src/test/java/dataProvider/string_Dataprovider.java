package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//********************** String data provider ************************

@Test(dataProvider = "dp2", enabled = false)
public class string_Dataprovider {

	public void String_Dataprovider(String s) {

//		System.out.println(s);
	}


	@DataProvider
	public String[] dp1() {

		String[] data = new String[3];
		data[0] = "abcd";
		data[1] = "Jp";
		data[2] = "Jpreddy";

		return data;

	}

	@DataProvider
	public String[] dp2() {

		String[] data = new String[] { "abcd", "Jp", "Jpreddy" };
		return data;

	}


}
