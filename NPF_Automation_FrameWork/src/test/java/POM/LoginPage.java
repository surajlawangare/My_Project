package POM;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest1;
import utilities.Data;
import utilities.Variables;

public class LoginPage extends BaseTest1 {

	// Login page done 	

	@Test(priority=1, dataProviderClass = Data.class, dataProvider="Login") // Done
	// On the login page, When we enter invalid email & password then the user should not be logged in.
	
	public void Test13 (String username, String password) throws InterruptedException {
		   
		     Thread.sleep(2000);
		     SoftAssert softassert = new SoftAssert();
		     try {
			  WebElement existing_User = driver.findElement(By.xpath(loc.getProperty("existing_User")));
				existing_User.click();
		     	Thread.sleep(1000);
		  }
		  
		  catch (Exception e) {
			  
			WebElement click_On_Login = driver.findElement(By.xpath(loc.getProperty("click_On_Login")));
			click_On_Login.click();
		      Thread.sleep(1000);
		  }
		  finally {
			  WebElement login_Email = driver.findElement(By.xpath(loc.getProperty("login_Email")));
				login_Email.clear();
				login_Email.sendKeys(username);
		
				WebElement login_Password = driver.findElement(By.xpath(loc.getProperty("login_Password")));
				login_Password.clear();
				login_Password.sendKeys(password);

				WebElement login_Button = driver.findElement(By.xpath(loc.getProperty("login_Button")));
				login_Button.click();
				Thread.sleep(1000);

                softassert.assertTrue(login_Button.isDisplayed());
				driver.navigate().refresh();
		  }	
	}
	
	
	@Test(priority=3) // Done
	// On the login page, When we enter valid email & password then the user should be logged in.

	public void Test14() throws InterruptedException {
		
	     Thread.sleep(2000);
	     
	     SoftAssert softassert = new SoftAssert();
			  try {
				  WebElement existing_User = driver.findElement(By.xpath(loc.getProperty("existing_User")));
					existing_User.click();
			     	Thread.sleep(1000);
			  }
			  catch (Exception e) {
				  
				  WebElement click_On_Login = driver.findElement(By.xpath(loc.getProperty("click_On_Login")));
					click_On_Login.click();
				      Thread.sleep(1000);
			  }
			  
			  finally {
				  WebElement login_Email = driver.findElement(By.xpath(loc.getProperty("login_Email")));
					login_Email.sendKeys(Variables.email);

					WebElement login_Password = driver.findElement(By.xpath(loc.getProperty("login_Password")));
					login_Password.sendKeys(Variables.password);
					
					WebElement login_Button = driver.findElement(By.xpath(loc.getProperty("login_Button")));
					login_Button.click();
					Thread.sleep(2000);
					
					new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("my_Profile"))));	
				    WebElement my_Profile =driver.findElement(By.xpath(loc.getProperty("my_Profile")));
				    my_Profile.click();
					new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("logout_Button"))));	
				    driver.findElement(By.xpath(loc.getProperty("logout_Button"))).click();
				    
					WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
					softassert.assertTrue(register_Button.isDisplayed());
			  }
	}
	
	
	@Test(priority=4) // This testcase will be skip 
	// When we enter unverified email then verification email should be sent.
	
	public void Test15() throws InterruptedException {
		
		Thread.sleep(2000);
	    SoftAssert softassert = new SoftAssert();
	    By element_Locator = By.xpath("//div[@class='resetVerify']/a");
	    boolean element_Is_present = driver.findElements(element_Locator).size() > 0;
	    
	    if (element_Is_present) {
	    	WebElement resend_Verification_Email = driver.findElement(By.xpath(loc.getProperty("resend_Verification_Email")));
			resend_Verification_Email.click();
			Thread.sleep(500);
			
			WebElement verification_Email = driver.findElement(By.xpath(loc.getProperty("verification_Email")));
			verification_Email.sendKeys(Variables.verification_Mail);
			
			WebElement submit_Button = driver.findElement(By.xpath(loc.getProperty("submit_Button")));
			submit_Button.click();
			Thread.sleep(1000);
			
			WebElement verification_Email_Sent = driver.findElement(By.xpath(loc.getProperty("verification_Email_Sent")));
			softassert.assertTrue(verification_Email_Sent.isDisplayed());
			driver.navigate().refresh();
	    }
	    else {
	    	throw new SkipException("TestCase Skipped");
	    }
	}
	
	
	@Test (priority=5, dataProviderClass = Data.class, dataProvider="verifymail") // Done but currently this testcase will be skip
	// When we enter invalid email in the verify email field then the error message should be displayed.
	
	public void Test16(String verify_Email) throws InterruptedException {
		
		    Thread.sleep(2000);
		   SoftAssert softassert = new SoftAssert();
		    By element_Locator = By.xpath("//div[@class='resetVerify']/a");
		    boolean element_Is_present = driver.findElements(element_Locator).size() > 0;
		    
		    if (element_Is_present) {
		    	WebElement resend_Verification_Email = driver.findElement(By.xpath(loc.getProperty("resend_Verification_Email")));
				resend_Verification_Email.click();
				Thread.sleep(500);
				
				WebElement verification_Email = driver.findElement(By.xpath(loc.getProperty("verification_Email")));
				verification_Email.sendKeys(verify_Email);
				
				WebElement submit_Button = driver.findElement(By.xpath(loc.getProperty("submit_Button")));
				submit_Button.click();
				Thread.sleep(1000);
				
				WebElement verify_Email_Error =driver.findElement(By.xpath(loc.getProperty("verify_Email_Error")));
				softassert.assertTrue(verify_Email_Error.isDisplayed());
				driver.navigate().refresh();
		    }
		    else {
		    	throw new SkipException("TestCase Skipped");
		    }
	}
	
	
	@Test(priority=2, enabled=false) // Done
	// When we have clicked on forgot password then we can changed password successfully.
	
	public void Test17() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		SoftAssert softassert = new SoftAssert();

		Thread.sleep(2000);
		try {
			  WebElement existing_User = driver.findElement(By.xpath(loc.getProperty("existing_User")));
				existing_User.click();
		     	Thread.sleep(1000);
		  }
		  catch (Exception e) {
			  WebElement click_On_Login = driver.findElement(By.xpath(loc.getProperty("click_On_Login")));
				click_On_Login.click();
			      Thread.sleep(1000);
		  }
		finally {
			WebElement forgot_Password = driver.findElement(By.xpath(loc.getProperty("forgot_Password")));
			forgot_Password.click();
			Thread.sleep(500);
			
			WebElement forget_Email = driver.findElement(By.xpath(loc.getProperty("forget_Email")));
			forget_Email.sendKeys(Variables.email);
			
			WebElement forgot_Button = driver.findElement(By.xpath(loc.getProperty("forgot_Button")));
			forgot_Button.click();
			Thread.sleep(500);
			
			System.out.println("Please enter the OTP");
			String otp = sc.nextLine();
			WebElement enter_Otp = driver.findElement(By.xpath(loc.getProperty("enter_Otp")));
			enter_Otp.sendKeys(otp);
			Thread.sleep(2000);
			
			WebElement forgot_verify_Button = driver.findElement(By.xpath(loc.getProperty("forgot_verify_Button")));
			forgot_verify_Button.click();
			
			System.out.println("Please enter new password");
			String new_Password = sc.nextLine();
			WebElement enter_New_Password = driver.findElement(By.xpath(loc.getProperty("enter_New_Password")));
			enter_New_Password.sendKeys(new_Password);
			Thread.sleep(2000);
			
			System.out.println("Please re-enter password");
			String confirm_Password = sc.nextLine();
			WebElement re_enter_Password = driver.findElement(By.xpath(loc.getProperty("re_enter_Password")));
			re_enter_Password.sendKeys(confirm_Password);
			Thread.sleep(2000);
			sc.close();

			WebElement forgot_Otp_Button = driver.findElement(By.xpath(loc.getProperty("forgot_Otp_Button")));
			forgot_Otp_Button.click();
			Thread.sleep(2000);
			
			WebElement reset_Password_Sent = driver.findElement(By.xpath(loc.getProperty("reset_Password_Sent")));
			softassert.assertTrue(reset_Password_Sent.isDisplayed());
			driver.navigate().refresh();
		}
	}
	
	
	@Test(priority=6, dataProviderClass = Data.class, dataProvider="forgotmail") 
	// When we have entered unregistered email id in the forgot email field then error message should display.
	
	public void Test18(String user_email) throws InterruptedException {
		
	      Thread.sleep(2000);
			SoftAssert softassert = new SoftAssert();
			
		 try {
			  WebElement existing_User = driver.findElement(By.xpath(loc.getProperty("existing_User")));
				existing_User.click();
		     	Thread.sleep(1000);
		  }
		  catch (Exception e) {
			  WebElement click_On_Login = driver.findElement(By.xpath(loc.getProperty("click_On_Login")));
				click_On_Login.click();
			      Thread.sleep(1000);
		  }
			finally {
				WebElement forgot_Password = driver.findElement(By.xpath(loc.getProperty("forgot_Password")));
				forgot_Password.click();
				Thread.sleep(500);
				
				WebElement forget_Email = driver.findElement(By.xpath(loc.getProperty("forget_Email")));
				forget_Email.sendKeys(user_email);
				
				WebElement forgot_Button = driver.findElement(By.xpath(loc.getProperty("forgot_Button")));
				forgot_Button.click();
				Thread.sleep(1000);
				
				WebElement error_Forgot_Password = driver.findElement(By.xpath(loc.getProperty("error_Forgot_Password")));
				softassert.assertTrue(error_Forgot_Password.isDisplayed());
			    driver.navigate().refresh();
			}
	}
	
}
