package POM;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest1;
import utilities.Data;
import utilities.Variables;

public class RegistrationPage extends BaseTest1{
	
	
	@Test(enabled=false) // working & test case will be skip
	// When we entered all the valid details then the lead should be generated.

	public void Test1() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);	
		
		WebElement enter_Name = driver.findElement(By.xpath(loc.getProperty("enter_Name")));
		enter_Name.sendKeys(Variables.name);
		Thread.sleep(1000);

		WebElement enter_Email = driver.findElement(By.xpath(loc.getProperty("enter_Email")));
		enter_Email.sendKeys(Variables.email);
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(Variables.county_Code, "");
		Thread.sleep(1000);
		
		boolean dependencyFound;

		WebElement mobile_Number = driver.findElement(By.xpath(loc.getProperty("mobile_Number")));
		mobile_Number.sendKeys(Variables.number);
		Thread.sleep(1000);
		
		try {
			WebElement get_Otp = driver.findElement(By.xpath(loc.getProperty("get_Otp")));
			get_Otp.click();

			System.out.println("Please enter the OTP");
			String otp = sc.nextLine();
			Thread.sleep(3000);
			
			WebElement enter_Otp = driver.findElement(By.xpath(loc.getProperty("enter_Otp")));
			enter_Otp.sendKeys(otp);
			Thread.sleep(3000);
			
			String actual_Text = driver.findElement(By.xpath(loc.getProperty("otp_Verify"))).getText();
			String expected_Text = "OTP Verified";
			Assert.assertEquals(actual_Text, expected_Text);
		}
		catch(Exception e) {
			
		}
        
		try {
			WebElement enter_Password = driver.findElement(By.xpath(loc.getProperty("enter_Password")));
			enter_Password.sendKeys(Variables.password);
		}
		catch(Exception e) {
			
		}
		
//		dependencyFound = js.executeScript("let staticDependencyFound = false; var courseId = ['UniversityId', 'CourseId', 'SpecializationId']; courseId.forEach(function (elemId) { if ($('body').search(elemId) !== -1) { staticDependencyFound = true; } if (staticDependencyFound === false) { $(document).ajaxStop(function () { $('#' + elemId).val($('#' + elemId).prop('selectedIndex', 1).val()); }); } }); return staticDependencyFound;")
//		if (dependencyFound == true) {
		
		try {
			WebElement select_Programme = driver.findElement(By.xpath(loc.getProperty("select_Programme")));
			Select sel2= new Select(select_Programme);
			sel2.selectByValue("");
			Thread.sleep(1000);
			}
		catch(Exception e){
			
		}
		try {
			WebElement select_Course = driver.findElement(By.xpath(loc.getProperty("select_Course")));
			Select sel3 = new Select(select_Course);
			sel3.selectByValue(Variables.course);
			Thread.sleep(1000);
		}
		catch(Exception e) {
			
		}
		try {
			WebElement select_Specialization = driver.findElement(By.xpath(loc.getProperty("select_Specialization")));
			Select sel4 = new Select(select_Specialization);
			sel4.selectByValue(Variables.specialization);
		}
		catch(Exception e) {
			
		}
		
		finally {
			System.out.println("Please enter the captcha");
			String captcha = sc.nextLine();
			Thread.sleep(2000);
			
			WebElement enter_Captcha = driver.findElement(By.xpath(loc.getProperty("enter_Captcha")));
			enter_Captcha.sendKeys(captcha);
			Thread.sleep(2000);
			sc.close();
			
			WebElement checkbox = driver.findElement(By.xpath(loc.getProperty("checkbox")));
			checkbox.click();
			
			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
			Thread.sleep(2000);
			
	        driver.findElement(By.xpath(loc.getProperty("back_To_Home"))).click();
		    new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("register_Button"))));
		    driver.findElement(By.xpath(loc.getProperty("register_Button"))).isDisplayed();
		}
	}

	@Test(priority=1)
	// Verify the email succesfully.
	
	public void Test2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Verified email or not ?");
		String verify_Email = sc.nextLine();
		if (verify_Email.equals("yes")){
			System.out.println("Verify email succesfully ");
			sc.close();
		}
		else {
			System.out.println("Email not verified");
		}
	}
	
	
	@Test(priority = 2, dataProviderClass=Data.class, dataProvider="name") // Done
	// When we enter invalid name in enter name field then the error message should be displayed.

	public void Test3(String name) throws InterruptedException {
        	
		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		WebElement enter_Name = driver.findElement(By.xpath(loc.getProperty("enter_Name")));
		enter_Name.clear();
		enter_Name.sendKeys(name);

		WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
		register_Button.click();
		Thread.sleep(1000);
		
		WebElement name_Error_Message = driver.findElement(By.xpath(loc.getProperty("name_Error_Message")));
		softassert.assertTrue(name_Error_Message.isDisplayed());
	}

	
	@Test(priority = 3, dataProviderClass=Data.class, dataProvider="email") // Done
	// When we enter invalid email then the error message should be displayed.

	public void Test4(String email) throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		WebElement enter_Email = driver.findElement(By.xpath(loc.getProperty("enter_Email")));
		enter_Email.clear();
		enter_Email.sendKeys(email);

		WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
		register_Button.click();
		Thread.sleep(1000);
		
		WebElement email_Error_Message = driver.findElement(By.xpath(loc.getProperty("email_Error_Message")));
		softassert.assertTrue(email_Error_Message.isDisplayed());
	}

		
	@Test(priority = 4, dataProviderClass=Data.class, dataProvider="countrycode") // Done
	// When we enter invalid mobile number then the error message should be displayed.
	
	public void Test5(String code, String number) throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(code, "");

		WebElement mobile_Number = driver.findElement(By.xpath(loc.getProperty("mobile_Number")));
		mobile_Number.clear();
		mobile_Number.sendKeys(number);

		WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
		register_Button.click();
		Thread.sleep(1000);

		WebElement number_Error_Message = driver.findElement(By.xpath(loc.getProperty("number_Error_Message")));
		softassert.assertTrue(number_Error_Message.isDisplayed());
	}

	
	@Test(priority = 5) // Pending need to discuss
	// When we entered invalid password then the error message should be displayed.

	public void Test6() throws InterruptedException {
		
		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		 By element_Locator = By.xpath("//input[@id='Password']");
		 boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		 
	     if(element_Is_Present) {
		
			WebElement enter_Password = driver.findElement(By.xpath(loc.getProperty("enter_Password")));
			enter_Password.clear();
			enter_Password.sendKeys("1");

			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
			Thread.sleep(1000);

			WebElement password_Error_Message = driver.findElement(By.xpath(loc.getProperty("password_Error_Message")));
			softassert.assertTrue(password_Error_Message.isDisplayed());
		} 
	      else{
     			throw new SkipException("TestCase Skipped");
	}
	}

	
	@Test(priority = 6) // Pending
	// When we don't select state & clicked on register button then error message should be displayed.

	public void Test7() throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//select[@id='StateId']");
		boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		
		if(element_Is_Present) {
			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
			Thread.sleep(1000);

			WebElement state_Error_Message = driver.findElement(By.xpath(loc.getProperty("state_Error_Message")));
			softassert.assertTrue(state_Error_Message.isDisplayed());
		}
		else {
			throw new SkipException("TestCase Skipped");
		}
	}

	
	@Test(priority = 7) // Pending
	// When we don't select city & clicked on register button then error message should be displayed.

	public void Test8() throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//select[@id='CityId']");
		boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		
		if(element_Is_Present) {
		WebElement select_State = driver.findElement(By.xpath(loc.getProperty("select_State")));
		Select sel1 = new Select(select_State);
		sel1.selectByValue(Variables.state);
		Thread.sleep(1000);

		WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
		register_Button.click();
		Thread.sleep(1000);

		WebElement city_Error_Message = driver.findElement(By.xpath(loc.getProperty("city_Error_Message")));
	    softassert.assertTrue(city_Error_Message.isDisplayed());
		}
		else {
			throw new SkipException("TestCase Skipped");
		}
	}

	
	@Test  (priority=8) // Pending 
	// When we don't select programme & clicked on register button then error message should be displayed.
	
	public void Test_19() throws InterruptedException {
		
		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//select[@id='UniversityId']");
		boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		
		if(element_Is_Present) {
			
			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
    		register_Button.click();
    		Thread.sleep(1000);
    		
    		WebElement select_Programme = driver.findElement(By.xpath(loc.getProperty("select_Programme")));
    		softassert.assertTrue(select_Programme.isDisplayed());
		}
		else {
			throw new SkipException("TestCase Skipped");
		}
	}
	
	
	@Test(priority = 9) // Pending 
	// When we don't select course & clicked on register button then error message should be displayed.

	public void Test9() throws InterruptedException {
		
		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//select[@id='CourseId']");
		boolean is_Element_Present = driver.findElements(element_Locator).size() > 0;
		
        	if (is_Element_Present) {
        		WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
        		register_Button.click();
        		Thread.sleep(1000);

        		WebElement course_Error_Message = driver.findElement(By.xpath(loc.getProperty("course_Error_Message")));
        		softassert.assertTrue(course_Error_Message.isDisplayed());
        	}	
        	else {
        	      throw new SkipException("TestCase Skipped");
        }
	}

	
	@Test(priority = 10) // Pending
	// When we don't select specialization & clicked on register button then error message should be displayed.

	public void Test10() throws InterruptedException {	
		
		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//select[@id='SpecializationId']"); 
		boolean is_Element_Present = driver.findElements(element_Locator).size() > 0;

          if(is_Element_Present) {				
			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
			Thread.sleep(2000);
		
			WebElement specilization_Error_Message = driver.findElement(By.xpath(loc.getProperty("specilization_Error_Message")));
			softassert.assertTrue(specilization_Error_Message.isDisplayed());
		   }
		   
		   else {
			throw new SkipException("TestCase Skipped");
		}
	}

		
	@Test(priority = 11, dataProviderClass=Data.class, dataProvider="captcha") // Done
	// When we enter invalid captcha and click on register then the error message should be displayed.

	public void Test11(String captcha) throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By element_Locator = By.xpath("//input[@placeholder='Enter text as shown']");
		boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		
		if(element_Is_Present) {
			WebElement enter_Captcha = driver.findElement(By.xpath(loc.getProperty("enter_Captcha")));
			enter_Captcha.clear();
			enter_Captcha.sendKeys(captcha);

			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
			Thread.sleep(1000);
	 
			String actual_error = driver.findElement(By.xpath(loc.getProperty("captcha_Error_Message"))).getText();
			String expected_error = "Enter exact characters shown in image.";
			softassert.assertEquals(actual_error, expected_error);
		}
		else {
			throw new SkipException("TestCase Skipped");
		}
		
	}

	
	@Test(priority = 12) // Done
	// When we don't click on the checkbox and clicked on register button the error message should be displayed.

	public void Test12() throws InterruptedException {

		Thread.sleep(1000);
		SoftAssert softassert = new SoftAssert();
		By  element_Locator= By.xpath("//input[@id='Agree']");
		boolean element_Is_Present = driver.findElements(element_Locator).size() > 0;
		if(element_Is_Present) {
			WebElement register_Button = driver.findElement(By.xpath(loc.getProperty("register_Button")));
			register_Button.click();
		
	        String actual_error = driver.findElement(By.xpath(loc.getProperty("i_Agree_Error_Message"))).getText();
	        String expected_error = "Please check the agreement checkbox to proceed";
	        softassert.assertEquals(actual_error, expected_error);
	        
		}
		else {
			throw new SkipException("TestCase Skipped");
		}
	}	
}
