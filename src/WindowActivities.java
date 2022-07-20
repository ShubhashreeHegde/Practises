import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// see the diff b/w maximize and full screen methods
		
		//get - selenium will wait until all the components of page loads completel
		//navigate - selenium will not wait until completely load, if load something in the page and then continue the steps but other all the elements will not be loaded. It will help when we need to navigate internally already when we are in automation mode
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
