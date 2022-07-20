import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.findElement(By.cssSelector(".blinkingText")).click(); //clicked on the link where new window will open
		
		//get the all window id's which opened
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId] all will be stored

		Iterator<String>it = windows.iterator(); //will pull all id's from the set data structure windows

		String parentId = it.next(); //by default this method will outside, when we give next() control will go to the '0'th index

		String childId = it.next(); //again after giving next() cotrol will go to next index that is 1st index child index

		driver.switchTo().window(childId); //will switch to window which is provided by us as window id 'childid'

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());//extracting text from entire paragraph
		//extracted text is - Pleaze email us at mentor@rahulshettyacademy.com with below template to receive response
		
		driver.findElement(By.cssSelector(".im-para.red")).getText();

		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

		driver.switchTo().window(parentId);

		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
