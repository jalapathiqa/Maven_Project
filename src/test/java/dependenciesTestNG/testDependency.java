package dependenciesTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testDependency {

	static String trackingNum = null;
@Ignore
	@Test
	public void CreateShipment() {
//		System.out.println(5/0);
		System.out.println("CreateShipment");
		trackingNum = "ABc1243Yz";
	}

	@Test(dependsOnMethods = "CreateShipment", alwaysRun = true)
	public void TrackShipment() throws Exception {
		if(trackingNum != null) {
		System.out.println("TrackShipment");
		}else 
		throw new Exception ("Invalid tracking number");
		
	}

	@Test(dependsOnMethods = {"TrackShipment", "TrackShipment"})
	public void CancelShipment() throws Exception {
		if(trackingNum != null) {
			System.out.println("CancelShipment");
			}else 
				throw new Exception ("Invalid tracking number");
	}

}
