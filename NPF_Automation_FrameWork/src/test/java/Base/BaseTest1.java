package Base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {

	
	public static WebDriver driver;
	public static Properties prop=new Properties ();
	public static Properties loc=new Properties ();

	public static FileReader filereeder;
	public static FileReader filereeder1;

	
	@BeforeSuite
	public void setUp () throws IOException, InterruptedException {
			
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.out.println("Tearup Successfully");
		
		if (driver==null) {
						
			filereeder=new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config1.properties");
			filereeder1=new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators1.properties");

			prop.load(filereeder); 
			loc.load(filereeder1);
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.get(prop.getProperty("logindemo"));
			Thread.sleep(2000);
//          new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("register_Button"))));	

		}
		
		else  if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("logindemo"));
			Thread.sleep(2000);
		}	
	}
	
	@AfterSuite
	public void teardown () {
		
		driver.close();
		System.out.println("Teardown Successfully");
	}
}
