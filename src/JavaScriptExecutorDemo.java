import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//By default seelnium will not provide any scrolling technique.
		// So we should write javascript to scroll. So for that we need to write javascript to cast out driver 
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");  //it will take 2 argument, 2nd one is optional. Sctrrolls till the given axis in window
		Thread.sleep(2000);
		// if we want to scroll in table which is inside the window, there will be keep on adding items and scrooling will be dynamic
		// for the we need to call DOM object that is 'document'. Like cssselector in javascript we need to use queryselector
		
		js.executeScript("document.querySelector('.tablefixHead').scrollTop==5000"); //when we use outer double quote inside we should use single quote
		//here .tablefixHead is a path of table
		
		//doing sum of all the values in the column of table
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			sum=sum+Integer.parseInt(values.get(i).getText()); //getting as text, but to sum we need interger. so need to parse it
		}
		System.out.println(sum);
		
		
		//requirement = compare the sum which we automated with the sum displayed on the screen
		//driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();  //now this is a string, we need to convert to int
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		//compae the actual and retrived sum's
		Assert.assertEquals(sum, total);
		
	}

}
