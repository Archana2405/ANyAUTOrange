package FirstJavaPack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BOA {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Tester\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 //driver = new ChromeDriver();
	driver=new FirefoxDriver();

    }

  @Test
  public void testUntitled2() throws Exception {
	  	 driver.get("https://www.bankofamerica.com/");
	  		
         driver.findElement(By.linkText("Loans menu. Press Enter to access submenu. To move through items press up or down arrow.")).click();
		 driver.findElement(By.linkText("Mortgage")).click();
	  	 driver.findElement(By.linkText("Estimate your monthly mortgage payment")).click();
        }

 }
  
  
