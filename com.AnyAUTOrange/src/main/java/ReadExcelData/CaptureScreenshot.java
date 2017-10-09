package ReadExcelData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class CaptureScreenshot 
{
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	
	@BeforeTest
	public void init()
	{
		extent=new ExtentReports("C:\\Software\\ExtentReports\\Reports\\advanceReport.html");
		
				
	}
	
	
	@Test
	public void captureScreenshot() throws IOException
	{
		//extent=new ExtentReports("C:\\Software\\ExtentReports\\Reports\\advanceReport.html");
		test=extent.startTest("captureScreenshot");
		driver=new FirefoxDriver();
		driver.get("https://anyaut.com/orange/index.php");
		String title=driver.getTitle();
		Assert.assertEquals("Logining | AnyAut", title);
		test.log(LogStatus.PASS, "Test Passed as titles are equal");
			
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath= GetScreenshot.capture(driver, "screenshotForExtentReport");
			test.log(LogStatus.FAIL, result.getName());
			test.log(LogStatus.FAIL, "Screenshot Below: "+ test.addScreenCapture(screenshotPath));
			
		}
		
		extent.endTest(test);
		
		
	}
	@AfterTest
	public void endReport()
	{
		
		extent.flush();
		extent.close();

		driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");	
	}

}