package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageDemo {

    WebDriver driver= null;
	LoginPage login;
	
	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	
	@And("^enters (.*) and (.*)$")
	public void enters_username_and_password(String username, String password) throws InterruptedException {
		
	    login=new LoginPage(driver);
		
		login.enterusername(username);
		login.enterpassword(password);
	
		Thread.sleep(1000);
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		
		login.loginbuttton();
		Thread.sleep(1000);
	}

	@Then("logout successfully")
	public void logout_successfully() throws InterruptedException {
		
		login.logout();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
