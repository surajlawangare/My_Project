package TokenFees;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.BaseTest1;

public class LPU extends BaseTest1 {
	
	@Test
	
	public void LPUDATA() throws InterruptedException {
		
    Thread.sleep(6000);
    WebElement name = driver.findElement(By.xpath("//input[@id='Name']"));
    name.sendKeys("Suraj");
    
//	WebElement country = driver.findElement(By.xpath(loc.getProperty("country")));
//	Select selcountry = new Select(country);
//	selcountry.selectByValue("1501042");
//	Thread.sleep(1000);
//
//	WebElement qualification = driver.findElement(By.xpath(loc.getProperty("qualification")));
//	Select selqualification = new Select(qualification);
//	selqualification.selectByValue("1500474");
//	Thread.sleep(1000);
//
//	WebElement discipline = driver.findElement(By.xpath(loc.getProperty("discipline")));
//	Select seldiscipline = new Select(discipline);
//	seldiscipline.selectByValue("1500520");
//	Thread.sleep(1000);
//
//	WebElement program = driver.findElement(By.xpath(loc.getProperty("program")));
//	Select selprogram = new Select(program);
//	selprogram.selectByValue("1500733");
//	Thread.sleep(1000);
	
	}
}
