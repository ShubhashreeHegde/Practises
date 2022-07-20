import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		
		//generic methods to handle calendar
		
		// 1. requirement is pick 21st date (current month with different date)
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		List<WebElement> dates = driver.findElements(By.className("day")); // will find all the days(1,2,...)
		// Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.className("day")).size(); // it will pick the count of day class
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText(); // i will store in text
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
		
		
		
		// 2.requirement is pick May 21 (current month with different date)
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();  //select calendar and the default month is january for example
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) 
		// in while (!may) so control will go inside loop. Because defaulyt month  is jan and we are asking May in the condition
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click(); //click on the next arrow button in the calendar
		}

		List<WebElement> dates1 = driver.findElements(By.className("day")); // will find all the days(1,2,...)
		// Grab common attribute//Put into list and iterate
		int count1 = driver.findElements(By.className("day")).size(); // it will pick the count of day class

		for (int i = 0; i < count1; i++) {
			String text1 = driver.findElements(By.className("day")).get(i).getText(); // i will store in text
			if (text1.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

	}

}
