package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory2 
{
	static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
		driver= new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Downloads\\chromedriver_win32\\chromedriver.exe");
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
