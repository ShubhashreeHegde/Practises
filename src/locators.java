import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			//implicit wait - 2 seconds time out - each lines will wait until the time out if not finding element
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // this should be declare after driver object, Duration says that give the duration in terms of java class(Duration)
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.id("inputUsername")).sendKeys("rahul");  //webdriver interface exposed findelement method.Chromedriver class is implementing this interface and implementing the body of findelement exposed by webdriver
			driver.findElement(By.name("inputPassword")).sendKeys("hello123");
			driver.findElement(By.className("signInBtn")).click(); 
			System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
			driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(1000);
			//impliciti wait - waits for object to show on the page
			//Thread.sleep - if the application is in the changing state, that will cause interception error. So we can use this to wait some time to stable that screen
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
			driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
			driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
			driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			System.out.println(driver.findElement(By.cssSelector("form p")).getText());
			driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
			driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
			driver.findElement(By.id("chkboxOne")).click();
			driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
			

	}

}
