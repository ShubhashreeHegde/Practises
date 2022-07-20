import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//this while loop continuosly print until the sytem battery down or OS crash because of 'true'
//		while(true)
//		{
//			sop(''hello'')//
//		}
		
		//in whicle loop always we should initialize, compare, and increment every time
		int i=0;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();       //4 times will click + icon in adult
			i++;
		}
		
		// we can also use for loop 
//		for(int i=1;i<5;i++)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click(); 
//		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//checking checkbox
		driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).click();
		//how to check whether checkbox is selected or not. There is a method in selenium to find 
		System.out.println(driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).isSelected());  //it will return true or false
		
		
		//count the no of checkboxes present
		driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		//printing
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	
		
		//Assertion - can use testNG and JUnit - it will validate the expected and actual
		//testng is the testing framework which we will use when we are building automation framework using selenium. We will use this library to build robust utilities with selenium framework
		//assertfalse will expect false value inside braces. 
		//assertFalse(true value) & assert.assertFalse(false) meanse test will pass. 
		// assertFalse(true value) & assert.assertFalse(true) meanse test will fail.
		Assert.assertFalse(driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).isSelected());
		Assert.assertFalse(false);
		
		//asserttrue
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).isSelected());
		
		//assertequal - compares 2 arguments actual and expected
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 adults");
		
		//select radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//check whether caleb]ndar is enabled or disabled
		driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();
		// in the latest websites current technology it wont works because after disabling if we click on that it will get enabled.
		//so that we need to find the attribute which is set by developer in html. We need to pull that attribute which is making that to disable 
		// find the attribute which is changing while disabling and enabling
		if(driver.findElement(By.id("")).getAttribute("style").contains("1"))
		{
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
