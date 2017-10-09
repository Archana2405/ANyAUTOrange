package com.org.learningMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Maven_FirstTest {
	
	WebDriver driver;
	
	@Test
	public void Show()
	{
		System.out.println("LogIn test");
		WebDriver driver= new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 //driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
	}
	

	
}
