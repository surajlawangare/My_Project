package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseTest1;

public class ListenerUtils extends BaseTest1 {

	public void getScreenshot() throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", " - ").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
		
	}
}
