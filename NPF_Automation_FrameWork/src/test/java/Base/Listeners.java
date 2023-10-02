package Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ListenerUtils;

public class Listeners extends ListenerUtils implements ITestListener {
	
    public void onStart(ITestContext context) {
        // Code to be executed when the test run starts
    }

    public void onTestStart(ITestResult result) {
        // Code to be executed when a test method starts
    }

    public void onTestSuccess(ITestResult result) {
        // Code to be executed when a test method succeeds
    }

    public void onTestFailure(ITestResult result) {
        // Code to be executed when a test method fails
    	
    	try {
    		getScreenshot();
    	} 
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    public void onTestSkipped(ITestResult result) {
        // Code to be executed when a test method is skipped
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to be executed when a test method fails but is within the success percentage
    }

    public void onFinish(ITestContext context) {
        // Code to be executed when the test run finishes
    }

	
}
