package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver","C:\\Users\\Tester\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://google.com");
		driver.quit();
  
	}

}