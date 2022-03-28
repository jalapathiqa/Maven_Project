package dataProvider;

public class DataSupplier {

	@org.testng.annotations.DataProvider
	public String[] dp1() {

		String[] data = new String[] { "Jp", "Reddy", "Kala" };
		return data;

	}
	
	@org.testng.annotations.DataProvider
	public String[] dp2() {

		String[] data = new String[] { "Jp1", "Reddy1", "Kala1" };
		return data;

	}


}
