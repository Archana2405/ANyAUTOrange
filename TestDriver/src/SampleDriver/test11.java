package SampleDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class test11 
{
	
	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver driver=new FirefoxDriver();
		//System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Tester\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
    //driver.get("https://www.bankofamerica.com/");
    //Thread.sleep(5000);
    //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    //capabilities.setCapability("marionette", true);
		WebDriver driver =new FirefoxDriver();
    //driver.wait(2000);
    driver.get("https://www.google.com/");
    
     //driver = new MarionetteDriver(capabilities);
    
}
}
