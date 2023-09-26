package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest  {
	
	WebDriver driver;
	
	@BeforeMethod
	public static void setup () {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test (dataProvider="testdata")
	public void Data (String username, String password) throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement user=driver.findElement(By.xpath("//input[@id='user-name']"));
		user.clear();
		user.sendKeys(username);
		Thread.sleep(2000);
		
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		pass.clear();
		pass.sendKeys(password);
		Thread.sleep(2000);
		
		WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();
		Thread.sleep(2000);
		
		WebElement logoutmenu=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		logoutmenu.click();
		Thread.sleep(2000);
		
		WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		logout.click();
		Thread.sleep(2000);
	
	}
	
	@DataProvider (name="testdata") 
	public String[][] getData() {
		
		String[][] data = {{"standard_user","secret_sauce"},
		                    {"locked_out_user","secret_sauce"},
		                    {"problem_user","secret_sauce"},
		                    {"performance_glitch_user","secret_sauce"}
		                    };
		return data;	
	}
	
	@AfterMethod
	
	public void teardown() {
		
		driver.close();
	}
}
	
		
	
	
	
	

