import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
//for the relative locators package we need to take from official website and paste. As it is static it will not import automatically


public class RelativeLoc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// friendly locators or Relative locators - above(), below(), toLeftoff(),
		// toRightoff()
		// syntax is driver.findElement(with tagName("label").below(webelement))
		
		//Req : Find the name label
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']")); 
		//writing relative locator
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());  //beacuse name label is above the name edit box

				
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));  //it is a flex element so will not identify se we are using next line for xpath. Check with latest version whether its supporting or not
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

		WebElement rdb = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

	}

}
