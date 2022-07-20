package Test;

import org.testng.ITestResult;

public class NOTE {
	//Running test in testNG - should have a annotation @Test to run
	//we can define multiple test from single class
	// create testNG XML - right click on TestNGTutorial - TestNG - Conver to TestNG - Finish - testng.xml will be created
	//we can modularize the test cases based on the functionalities(car,home,..) and can trigger accordingly
	//excluding and including some methods from the class in xml to skip the execution of particular test cases
	//dealing with regular expressions(regex) = methodname.*
	//running package level  = this will be usefull for regression test
	//@Before test - it will execute before executing the test cases which is mentioned in the xml
	
	//if there are 4 test cases(methods) in class and when we have before method annotation, the befor annotation method will execute first, 
	//then one text will execute, aftre that again beforemethod will execute (BeforeMethod will call every time afer executing each test case)
	
	// @BeforeClass will execute first before starting the executions of the methods inside that class
	//@AfterClass will execute at the last after completing the executions of the methods in the class
	
	//Group : if we want to pick some testcases from different classes in this cases Groups will come into picture. Like @Test(group={"Smoke"}). We can include and excude also
	
	//Helper attributes = Depends, enabled, timeout
	//@Test(dependsOnMethods={"Mothodname"}in TestNG methods will execute as per the alphabetical order. Here the annotationed followed method will execute after the "Mothodname" execution
	//@Test(enabled=false - if any page is not working and while doing execution we want to skip that page then we can use this
	//@Test(timeOut=4000 if any test case is taking more time to execute we can use it
	
	//if any parameters are same for all the test folders then we need to write it on the top of test folders in the xml <parameter>
	//if it is for suite level then we can use for suitelevel
	
	//Dataprovider annotation - Parameterizing with multiple data sets by running tests with multiple combination
	
	//imp qus ----------- how will achieve parameterization in testNG ?
	//-> We can drive the data from testNG xml file and we can also parameterize using dataprovider annotation isung TestNG
	
	//TestNG Listeners(listens the test case) - there are some listeners it will activate after or before our test. when test case fails listeners will gp to screenshot block and execute
	// we should tell the sml where the testng listners are present. After suite need to mention
	//imp qus : When u catch listners how do u know which test case---->onTestFailure(ITestResult result), here if we write result.getname() it will show the failed test case name
		
	//Running test parallel in testNG - there is one attribute we can add in xml - <suite name="Loan Dept" parallel="tests" thread-count="2"> - give name of parallel test and count in thread
	//it will run in 2 browser
	//it is not suggested intestNG, for that we can use grid
	
	//after all we can see the result in test-output
		
	
	//Testng design---Test suite -> test folder(shell/Module) -> test cases
	
}
