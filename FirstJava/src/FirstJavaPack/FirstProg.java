package FirstJavaPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class FirstProg {
	static WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private static String baseUrl;
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver","C:\\Users\\Tester\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		 

	   // baseUrl="https://www.bankofamerica.com/";


	    driver.get("https://www.bankofamerica.com/");
		assertEquals("Loans menu. Press Enter to access submenu. To move through items press up or down arrow.", driver.findElement(By.linkText("Loans menu. Press Enter to access submenu. To move through items press up or down arrow.")).getText());
		//driver.quit();
	}
		/* public void testUntitled2() throws Exception {
			   
				driver.get(baseUrl + "/");
			   // driver.findElement(By.id("locatorLayer-CloseLink")).click();
			    try {
			      assertEquals("Loans menu. Press Enter to access submenu. To move through items press up or down arrow.", driver.findElement(By.linkText("Loans menu. Press Enter to access submenu. To move through items press up or down arrow.")).getText());
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
			    driver.findElement(By.linkText("Mortgage")).click();
			    driver.findElement(By.linkText("Estimate your monthly mortgage payment")).click();
			    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | spaWin | 30000]]
			  
  
	}*/

}