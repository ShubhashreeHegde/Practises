import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestivedropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://Selenium//practise-selenium//driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//return type of findelements is list of webelements. Now options has all the list which is displayed
		
		//Enhanced for loop
		// when loop irterates picked options will be stored in option variable. Return type of that element is webelement.
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
					{
				option.click();
				break;
					}
		}
			

	}

}
