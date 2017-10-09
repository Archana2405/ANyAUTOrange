/**
 * 
 */
package com.AnyAUTOrange.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ReadExcelData.GetScreenshot;
import junit.framework.Assert;

/**
 * @author Tester
 *
 */
public class CreateAnAccount2 
{
	
	static WebDriver driver;
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook wb=null;
	public XSSFSheet sheet1=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	String xlsFilePath;
	static String title=null;
	static ExtentReports extent;
	static ExtentTest test;
	static String status;
	
	public CreateAnAccount2(WebDriver driver)
	{
		this.driver=driver;
		this.wb = null;
	}

	@FindBy(how=How.ID, using="firstname")
	WebElement fname;
	
	@FindBy(how=How.ID, using="lastname")
	WebElement lname;
	
	@FindBy(how=How.ID, using="email")
	WebElement e_mail;
	
	@FindBy(how=How.XPATH, using=".//*[@id='password']")
	WebElement pswd;
	
	@FindBy(how=How.XPATH, using=".//*[@id='confirmpassword']")
	WebElement c_pswd;
	
	@FindBy(how=How.XPATH, using=".//*[@id='singlebutton']")
	WebElement submit_button;
	
	@FindBy(how=How.ID, using="company")
	WebElement compny;
	
	@FindBy (how=How.ID, using="designation")
	WebElement designation;
	
	@FindBy(how=How.ID, using="phone")
	WebElement phone;
	
	@FindBy(how=How.ID, using="country")
	WebElement country;
	
	@FindBy(how=How.XPATH, using="//*[@id='contact-information']//*[@id='singlebutton']")
	WebElement register_button;
	
	
	public void create_an_account(String fnm, String lnm, String email, String pass, String cpass, String comp, String desig, String ph, String country_dropdown) throws InterruptedException
	{
		fname.sendKeys(fnm);
		lname.sendKeys(lnm);
		e_mail.sendKeys(email);
		pswd.sendKeys(pass);
		c_pswd.sendKeys(cpass);
		submit_button.click();
		
		Thread.sleep(2000);
		
		compny.sendKeys(comp);
		designation.sendKeys(desig);
		phone.sendKeys(ph);
		Select country_d=new Select(country);
		country_d.selectByVisibleText(country_dropdown);
		register_button.click();
		//Thread.sleep(1000);	
		
	}
	public void quitApp()
	{
		driver.quit();
	}
	
	
	public CreateAnAccount2(String xlsFilePath) throws Exception
	{
		this.xlsFilePath=xlsFilePath;
		fis=new FileInputStream(xlsFilePath);
		wb=new XSSFWorkbook(fis);
		fis.close();
		
						
	}
			

	public String getData(String sheetName, String colName, int rowNum)
	{
		try
		{
			int colNum=-1;
			sheet1=wb.getSheet(sheetName);
			row=sheet1.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			row=sheet1.getRow(rowNum);
			cell=row.getCell(colNum);
			
			return cell.getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "data Not found";
		}
		
	}
	
	
		
		
		
	public int countCols(int sheetNumber, int row)
	{
		XSSFSheet sheet1=wb.getSheetAt(sheetNumber);
		int colcount=0;
		try{
			 colcount=sheet1.getRow(row).getLastCellNum();	
		}
		catch (NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		return colcount;
	}
	
	public int countRows(String sheetName)
	{
		int rowcount=0;
		
		try{
		sheet1=wb.getSheet(sheetName);
		
		rowcount=sheet1.getLastRowNum()+1;
			
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		return rowcount;
		
	}
	public int countRows(int sheetNo)
	{
		int rowcount=0;
		
		try{
		sheet1=wb.getSheetAt(sheetNo);
		
		rowcount=sheet1.getLastRowNum();
				
		}
		
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			
		}
		return rowcount;
	}
	public boolean setCellData(String sheetName, String colName, int rowNum, String value)
	{
		try
		{
			int colNum=-1;
			int i;
			sheet1=wb.getSheet(sheetName);
			row=sheet1.getRow(0);
			for(i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			
		
			row=sheet1.getRow(rowNum);
			if(row==null)
				row=sheet1.createRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell==null)
				cell=row.createCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream(xlsFilePath);
			wb.write(fos);
			fos.flush();
			fos.close();
			return true;
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	 public String pageTitle()
	{
		 try
		 {
			 title=driver.getTitle();
			 return title;
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
			return "data Not found";
		 }
	}
		public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
		 {
			 
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String dest=System.getProperty("user.dir")+"/Screenshots/"+screenshotName+".png";
			File destination=new File(dest);
			FileUtils.copyFile(source, destination);
			
			return dest;
		
		 }
		
		
		
	 
	/* public static void captureScreenShot(WebDriver driver, String screenshotName) 
	 {
		 System.out.println("In captureScreenShot()");
		 try
		 {
		  // Take screenshot and store as a file format
		 			 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 		
		 File source= ts.getScreenshotAs(OutputType.FILE);
		
		
		  // Copy the  screenshot to desired location using copyFile method
			 
		 FileUtils.copyFile(source, new File("./Screenshots/"+ screenshotName+ ".png"));   
		 driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");
				 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Exception while taking screenshot "+e.getMessage());
			
		 }
		 
			//report.close();
			
			//driver.get("file:///C://Software//ExtentReports//Reports//advanceReport.html");
		}
		*/
}

	
