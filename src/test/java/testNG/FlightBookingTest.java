package testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FlightBookingTest {
	
	
	@Test
	public void Signup() {
		System.out.println("Signup");
	}
	
	@Test(priority = 1)
	public void Login() {
		System.out.println("Login");

	}
	
	@Test(priority = 2)
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");

	}
	
	@Test(priority = 4)
	public void SaveTheTicket() {
		System.out.println("SaveTheTicket");

	}
	
	@Test(priority = 3)
	public void BookTheTicket() {
		System.out.println("BookTheTicket");

	}
	
	@Ignore
	@Test(priority = 5)
	public void Logout() {
		System.out.println("Logout");

	}
	
	
}
