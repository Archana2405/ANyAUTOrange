package testNGFirst;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyApplication2 
	{
	
	WebDriver driver;
	@Test
	
	public void startApp()
	{
		Assert.assertEquals(12, 13);
		System.out.println("Starting app");
	}
	@Test(dependsOnMethods="startApp")
	public void loginApp()
	{
		System.out.println("Login app");
	}
	@Test(dependsOnMethods="loginApp")
	public void logOut()
	{
		System.out.println("Logout app");
	}
}
