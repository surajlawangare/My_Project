package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalDetails {
	public static WebDriver driver;

	@BeforeSuite

	public void start() throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.out.println("Tearup Successfully");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admission.sws.school/");
		Thread.sleep(3000);
	}

	@Test
	public void personal() throws InterruptedException {

		driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[@href='#tab2default']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("suraj.lavangare@meritto.com");
		driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("abc@123");
		driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
		Thread.sleep(3000);
		
	}

	@AfterSuite
	public void close() {
		driver.close();
	}
}
