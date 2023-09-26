package ui;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	@BeforeClass
	public void beforeclass() {
		
		System.out.println("Run this test before the class");
	}
	
	@AfterClass
	public void afterclass() {
		
		System.out.println("Run this test after the class");
	}
	
	@BeforeTest
	public void LogintoApplication() {
		
		System.out.println("Login To Application");
	}
	
	@BeforeMethod
	public void DBcoonected() {
		
		System.out.println("DB coonected successfully");
	}
	
	@Test (priority=1, description="LogIn")
	public void Logintest () {
		
		System.out.println("Log In Successfully");
	}
	
	
	@Test (priority=2, description="LogOut")
	public void logouttest () {
		
		System.out.println("Log Out Successfully");
	}
	
	@AfterMethod
	public void DBdisconnect() {
		
		System.out.println("DB disconnect successfully");
	}
	
	@AfterTest
	public void Logoutfromapplication() {
		
		System.out.println("LogOut From Application");
	}
}
