package org.openqa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG 
	{
	
	 //WebDriver driver;
	@Test
	public void startApp()
	{
		//driver=new ChromeDriver();
		
	}
	@Test(dependsOnMethods="startApp")
	public void loginApp()
	{
		
	}
	@Test(dependsOnMethods="loginApp")
	public void logOut()
	{
	
	}
}

