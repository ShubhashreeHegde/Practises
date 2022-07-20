import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemoStream {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		//Req : Sort the veggies in the column
		// click on column, capture all the veggies > capture text of all webelements into new list(1)> apply sort on that list (1) and 
		//take next list (2) > compare the list (1) v(2) ---9because after click on the column name elements will sort and we need to cmpare that in automantion so that we are comparing those
		
		
		// click on column,
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new(original) list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		//stream().map(s -> s.getText()----? Here stream wil iterate first and get the first element and store in's', again it will iterate and get the 2nd webelement and store in 's',..........


		// sort on the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));

		
		//req : get the price of given veggies - scan the name column with getText ->Beanse->print the price of the Beanse
		List<String> price = elementsList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());   
				// value we are grabbing with gettext so we need to use list<string>
				//there will not be a custom method for 'getPriceVeggie',  move the cursor on  getPriceVeggie and create the method
				//if we want to do some work on list meanse need to use filetr, just to collect all the webelements need not to use filter. After filter what we collect that will continue for the further subsequent methods
				
		price.forEach(a -> System.out.println(a));  //prints all the elements in the list
		

		
		
		
		// Req : as of now searching items in the same page. If there is a multiple pages how we can search
		
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click(); //if element not found in that page click on next button
			}

		}while(price.size()<1);
		}



		private static String getPriceVeggie(WebElement s) {  //return type should be string so change to string after static

			String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();  //'s' will be having veggie xpath so we need to continue the remain xpath after traversing from parent to child, sibling. Actual xpath will be //tr/td[1]following-sibling::td[1]

			return pricevalue;

		}

	}


