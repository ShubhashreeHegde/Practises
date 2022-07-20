
import java.time.Duration;
import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class base1 {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// Pros of implicit wait is Readable code
		// cons of implicit wait is it will hide the performance issue of particular
		// things

		// Pros of Explicit wait is Wait os applied in only targeted elements. So no
		// performance issue
		// cons of Explicit wait is more code, because need yo apply for all elements
		// wherever is required

//		There is another explicit wait mechanism type called Flluent wait
//
//		Explicit wait can be achieved in 2 ways
//		Webdriver wait - 10 secs - it will keep on monitoring DOM, if the object found then it will proceed 
//		Fluent wait - 10 secs, Polling 2 secs - iyt will check as the polling time, only check for each 2 secs
//
//		Fluent wait finds the web element repeatedly at regular intervals of time until the timeout or till the object gets found
//
//		Unlike webdriver wair, we need to build customizedwait methods based on condition
//
//		Both classes Webdriver wait & Fluent wait implement wait interface
//		your card is accepted(3 secs), order is being processed(7 secs), confirmation - we cau use here fuent wait

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// webdriverwait is a class
		// WebDriverWait w = new WebDriverWait(driver, 5); // this is deprecated
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);

		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// webelement =
		// driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		// locator = By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy")
		// explicit wait

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)

	{

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			// Brocolli - 1 Kg

			// Brocolli, 1 kg

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			// format it to get actual vegetable name

			// convert array into array list for easy search

			// check whether name you extracted is present in arrayList or not-

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;

				// click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length)

				{

					break;

				}

			}

		}

	}

}
