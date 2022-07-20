package Test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//itestlisteners - to implement linsters in testng there is a interface called ITestListeners. To use methods of lstners we need to implement it in our tesng

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) 
	{
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("I successfully executed listeners pass code");

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//take screenshot after failure
		//System.out.println("Ifailed, executed listners pass code");
		System.out.println("Ifailed, executed listners pass code" +result.getName()); //it will show the failed test case name

	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{


	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{


	}

	@Override
	public void onStart(ITestContext context) 
	{

	}

	@Override
	public void onFinish(ITestContext context) 
	{


	}

}
