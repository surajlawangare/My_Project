package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	By txt_username=By.xpath("//input[@id='user-name']");
	By txt_password=By.xpath("//input[@id='password']");
	By btn_login=By.xpath("//input[@id='login-button']");
	By menu_logout=By.xpath("//button[@id='react-burger-menu-btn']");
	By btn_logout=By.xpath("//a[@id='logout_sidebar_link']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void enterusername(String username) {
		
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void loginbuttton() {
		
		driver.findElement(btn_login).click();
	}
	
	public void logout() throws InterruptedException {
		
		driver.findElement(menu_logout).click();
		Thread.sleep(1000);
		driver.findElement(btn_logout).click();
	}
	
}
