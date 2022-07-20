package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}  
	//main method if we use test will run in java compiler, but here not needed because testng will act as a java complier.
	//testng need all test execution in a method
	
	@Test   //is a annotatoin which will recognize the method which immediately followed after the annotation
	public void demo()   //this will treat as a test case
	{
		System.out.println("Hello");
	}
	
	
	@AfterTest   //it will execute after the test not after the complete project. To delete cookies and stop or remove connection we can use
	public void lastexecution()
	{
		System.out.println("I will execute last");
	}
	
	@AfterSuite
	public void AFSuite()
	{
		System.out.println("Am the last");
	}
	
	@Test  //if we write another annotation it will treat as 2nd test case
	public void SecondTest()
	{
		System.out.println("Bye");
	}

}


