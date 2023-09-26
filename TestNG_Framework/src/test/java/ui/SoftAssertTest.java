package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {

	@Test
	public void softassert() {
		
		SoftAssert softassert= new SoftAssert();
		
		String expectedttitle= "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expectedtext= "Search";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
		String actualtitle=driver.getTitle();
		System.out.println("Verifying Title");
		softassert.assertEquals(actualtitle, expectedtext, "Title Verification Failed");
		
		String actualtext=driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("type");
		System.out.println("Verifying Text");
		softassert.assertEquals(actualtext, expectedtext, "Text Verification Failed");
		
		System.out.println("Closing the browser");
		driver.close();
		
		
		
	}
}
