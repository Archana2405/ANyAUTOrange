package demo;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class StartChrome {

	@Test
	public void test1() throws MalformedURLException, InterruptedException
	{//Create object of DriredCapabilities class and specify android platform
		DesiredCapabilities capabilities=DesiredCapabilities.android();
		
		//set the capability to execute test in chrome browser
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		
		//set the capability to execute our test in Android Platform
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		
		//we need to define platform name
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//set the device name as well(you can give any name)
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Archana");
		
		//set android version as well
		capabilities.setCapability(MobileCapabilityType.VERSION,"4.1");
		
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		capabilities.setCapability("unicodeKeyboard", true);
		
		//Create object of URL class and specify the appium server address
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		//Create object of Android Driver class and pass the url and capability that we created
		WebDriver driver= new AndroidDriver(url,capabilities);
		
		//Open url
		driver.get("https://www.gmail.com/");
		//Print the title
		System.out.println("Title  "+driver.getTitle());
		
		//Enter username
		 driver.findElement(By.id("identifierId")).sendKeys("singh.archana2505@gmail.com");
		 driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("s1nghjaya");
		 
		 driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
		 Thread.sleep(10000);
		 
		 //driver.findElement(By.xpath("//*[@name='Search']")).sendKeys("Alok");
		 driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Alok");
		 Thread.sleep(3000);
		// ((PressesKeyCode) driver).pressKeyCode(66, 16);
		 //driver.pressKeyCode(66);
	
		//Enter Password
		//driver.findElement(By.name("pass")).sendKeys("singhjaya");
		//driver.findElement(By.name("btnK")).click();
		//Click on submit button
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc='Forgot email?']")).click();
		
		//driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(6000);
		
		//Close the browser
		driver.quit();
		
	}
}
