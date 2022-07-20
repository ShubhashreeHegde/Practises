import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		int j=0;
		// adding cucumber to cart. Find all teh elements. As we are collecting multiple element we need to use list of webelements

		// driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	
		
		
		//adding one item to the cart
		for (int i = 0; i < products.size(); i++) 
		{				
			// get will pull one partiular item from products, which we need to pull we should pass that index in get argument
			String name = products.get(i).getText();
			
			if (name.contains("Cucumber")) 
			{
				//click on add cart
				//"button[@text()='ADD TO CART']" - this way of using text is not suggested when that is dynamic, meanse after clicking of teh button name changes
				//driver.findElements(By.xpath("button[@text()='ADD TO CART']")).get(i).click();
				
				//we shoud use entire block, if inside block text changes also no pbm that will be selected
				driver.findElements(By.xpath("(//div[@class='product-action']/button)")).get(i).click();
				break;  //task completed, so we can come out of the for loop
			}			
		}
		
		
		//adding multiple items to cart
		//create first array of strings
		//check whether namme you extracted is present in arraylist or not
		//first convert array to arralist for easy search
		
		String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
		List itemsneededList=Arrays.asList(itemsneeded);
		for (int i = 0; i < products.size(); i++) 
		{				
			//format the text which we get to actual vegetable, use split(Cucumber - 1 Kg) to cucumber to be extracted
			//after splitting we will get array of string, so convert string to array of string string[]
			String[] name = products.get(i).getText().split("-");
			String formattedname=name[0].trim();
			if (itemsneededList.contains(formattedname))
			{
				driver.findElements(By.xpath("button[@text()='ADD TO CART']")).get(i).click();
				//if we use arraylist we cannot use break; because after clicking on first need item then it will break it wont find other needed
			}
			if(j==itemsneeded.length)
			{
				break;  //after finishing above given 3 titems serach for should break so that we are using j var to stopthe iteration
			
		}
	}
	}
}







