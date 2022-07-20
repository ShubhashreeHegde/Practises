package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	@BeforeClass
	public void BFClass()
	{
		System.out.println("Before executing any methods in the class");
	}
	
	@Parameters({"URL","APIkey/username"})  //it is applicable for only this paerticular test case, if need for all then we need to mention for all teh test cases
	@Test
	public void WebloginCarloan(String urlname, String key)
	{
		System.out.println("Web login car");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void BeforEvery()
	{
		System.out.println("I will execute before every test method in day 3 class");
	}
	
	@AfterMethod
	public void AfterEvery()
	{
		System.out.println("I will execute After every test method in day 3 class");
	}
	
	@AfterClass
	public void AFClass()
	{
		System.out.println("After executing any methods in the class");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginCarLoan()
	{
		System.out.println("Mobile login car");
	}
	
	@Test
	public void MobileLoginCarLoan1()
	{
		System.out.println("Mobile login car 1");
	}
	
	@BeforeSuite
	public void BFSuite()
	{
		System.out.println("Am first");
	}
	
	@Test(timeOut=4000)
	public void MobileLoginCarLoan2()
	{
		System.out.println("Mobile login car 2");
	}
	
	@Test(enabled=false)
	public void MobileLoginCarLoan3()
	{
		System.out.println("Mobile login car 2");
	}
	
	@Test(dependsOnMethods={"WebloginCarloan","MobileLoginCarLoan1"})
	public void LoginAPICarLoan()
	{
		System.out.println("API login car");
	}
	
	
	@Test(dataProvider="getData")   //this will run with multiple times as we are mention in the dataprovider annotation
	public void MobileLoginCarLoan4(String username, String password)  //will take 2 string data 
	{
		System.out.println("Mobile login car 2");
		System.out.println(username);
		System.out.println(password);
	}
	
	
	@DataProvider       // we can do different combination meanse particulat test cases will run with multiple times with diff combinations
	public Object[][] getData()   //after moving cursor on return type this is changed from void to Object[][]s
	{
		//1st combination testing with username and password - good create history
		//2nd - another username and password- no create history
		//3rd - fraudelent create history
		Object[][] data = new Object[3][2]; //defining multidimensional array. [3]meanse 3 cobinations, [2]eachcombination how many values passing
		
		//1st combination
		data[0][0] = "firstsetusername";         //data[0][0] initializing var
		data[0][1]="firstsetpassword";
		
		//2nd comb
		data[1][0]="Secondsetusername";
		data[1][1]="Secondsetpassword";
		
		//3rd
		data[2][0]="thirdsetusername";
		data[2][1]="thirdsetpassword";
		return data;
		
		
	}
	
}
