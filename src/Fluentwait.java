import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluentwait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		// here fluuentwait is class and implementing Wait interface

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>()
				{
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(By.cssSelector("[id='finish'] h4"));
						}
				});
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());

	}

}
