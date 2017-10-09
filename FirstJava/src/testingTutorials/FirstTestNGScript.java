package testingTutorials;

import org.testng.annotations.Test;

public class FirstTestNGScript 
{
	@Test(priority=1, description="TC verify login functioanlity")
	public void LoginApp()
	{
		
		System.out.println("My first test");
	}
	@Test(priority=2, description="Will add items")
	public void selectItems()
	{
		
		System.out.println("My items selected ");
	}
	@Test(priority=3, description="Will perform checkout")
	public void checkOut()
	{
		
		System.out.println("Checkout");
	}


}
