package JenkinDemoP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoJenkin {
	@Test
	public void testJenkins()
	{
		
		System.out.println("Welcome to Jenkins");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook1.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

	
	
}