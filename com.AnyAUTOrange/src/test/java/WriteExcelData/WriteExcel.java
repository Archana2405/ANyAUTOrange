package WriteExcelData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AnyAUTOrange.Pages.CreateAnAccount2;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ReadExcelData.GetScreenshot;

import com.AnyAUTOrange.Pages.CreateAnAccount2;

import Utility.BrowserFactory2;


public class WriteExcel{
	String title;
	ExtentReports extent;
	ExtentTest test; 
	WebDriver driver;
	CreateAnAccount2 excel;
	String status=null;
	int countStatus=0;
	int rows=0;
	
	
	
	@BeforeTest
	public void init()
	{
		extent=new ExtentReports("C:\\Software\\ExtentReports\\Reports\\advanceReport.html");
		
				
	}
	
	@Test
	public void excelInput() throws Exception
	{
			
		 
		// Create object of extent report
	//	report=new ExtentReports("C:\\Software\\ExtentReports\\Reports\\advanceReport.html");
			
		// Start Test
		test=extent.startTest("Capture Screenshots for Registration");
		
			
		// Start browser
		//WebDriver driver= BrowserFactory2.startBrowser("firefox", "https://anyaut.com/orange/index.php");
		driver=new FirefoxDriver();
		driver.get("https://anyaut.com/orange/index.php");
		test.log(LogStatus.INFO, "Browser is up and running");
		
	
		 excel=new CreateAnAccount2("C:\\Software\\ExcelData\\DDF - AnyAUTOrange.xlsx");
	//	logger.log(LogStatus.INFO,"Application is up and running" );
		
		// get title
		title=driver.getTitle();
	
		 rows = excel.countRows("CreateAccount");
		String[] statuses= new String[rows];
			
		countStatus= statuses.length;
		System.out.println(countStatus);
		for (int row = 1; row <statuses.length; row++) 
		{
					
			test.log(LogStatus.INFO, "Title captured");
					
			// Verify title
						
			Assert.assertEquals("Login | AnyAut", title);
			test.log(LogStatus.PASS, "Test Passed as titles are equal");
					
			status="Pass";
			//CreateAnAccount2.captureScreenShot(driver,"Passed Testcase");
			
			excel.setCellData("CreateAccount", "Status", row, status);
			
			test.log(LogStatus.INFO, "Writing status in Excel");	
			
					
		}
			//CreateAnAccount2.captureScreenShot(driver,"Passed Testcase");
	
			//report.flush();
			//report.close();
						
		//	driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");
					 
		}

		@AfterMethod
		public void getResult(ITestResult result) throws IOException
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String screenshotPath= CreateAnAccount2.captureScreenshot(driver, "screenshotForExtentReport");
				test.log(LogStatus.FAIL, result.getName());
				test.log(LogStatus.FAIL, "Screenshot Below: "+ test.addScreencast(screenshotPath));
				
				status="Fail";
				excel.setCellData("CreateAccount", "Status", rows, status);
				
				test.log(LogStatus.INFO, "Writing status in Excel");
				
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

	/*@AfterMethod
	public void tearDown(ITestResult result)
	{
	if(ITestResult.FAILURE==result.getStatus())
		{
			System.out.println("In @AfterMethod()");
			CreateAnAccount2.captureScreenShot(driver,result.getName());
		
		
		
	//	String screenshot_path=CreateAnAccount2.captureScreenShot(driver, result.getName());
	//	driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");
	//	String image=logger.addScreenCapture(screenshot_path);
	//	logger.log(LogStatus.FAIL, "Title verification", image);
		
		//System.out.println("Image ="+ image);	
		
		//System.out.println("In @AfterMethod()");
		
		
		}
		
	//report.flush();
	//report.close();
	driver.quit();	
	//driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");

	
		}
	

}
*/