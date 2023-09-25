package StepsForHooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksDemoSteps {

	WebDriver driver=null;
	
	@Before (value="@stock", order=1)
	public void browsersetup() {
		
		System.out.println("I am Inside BrowserSetup");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void teardown() {
		System.out.println("I am Inside TearDown");
		driver.close();
		driver.quit();
	}
	
	@BeforeStep
	public void beforestep() {
		
		System.out.println("I am Inside BeforeStep");
	}
	
	@AfterStep
	public void afterstep() {
		
		System.out.println("I am Inside AfterStep");
	}
	
	@Given("browser is open")
	public void browser_is_open() {

		
	}
	@When("enters username and password")
	public void enters_username_and_password() {
	   
		
	}
	@And("click on login button")
	public void click_on_login_button() {
	   
		
	}
	@Then("logout successfully")
	public void logout_successfully() {
	    
		
	}
}
