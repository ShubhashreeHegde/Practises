package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@Test
	public void ploan()
	{
		System.out.println("Hi");
	}
	
	@Test(groups= {"Smoke"})
	public void ploan1()
	{
		System.out.println("Hii");
	}
	
	@BeforeTest   // this we can use to cleanup data before starting test, in API setting base url, etc...
	public void prerequisite()
	{
		System.out.println("I will execute first");
	}
}
