import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
//		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
//		// if we build then it is ready to run meanse it is just ready but will not execute. To perform that we need to mention perform
		
		
		//Building composite action
	
		Actions a = new Actions(driver);
		WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		
		//keyDown(Keys.SHIFT) - will hold shift key and type letter so it will take text in uppercase.
		//as we combined many actions so we can call it as a composite action
		//after entering text doubleclick on that and text will be selected
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//double clicking
		a.moveToElement(move).contextClick().build().perform();
		
		//can perform drag and drop actions
		
		
	}
}
