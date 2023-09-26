package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {

	@BeforeSuite
	public void beforesuite() {
		
		System.out.println("Common Data Setup");
	}
	
	@AfterSuite
	public void  aftersuite() {
		
		System.out.println("Common Data Cleanup");
	}
}
