import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selIntroduction {

	public static void main(String[] args) {
//Invoking Browser
//Chrome - ChromeDriver(is a class)->Methods are close, get-- these all methofds are same for all browsers.
// need to create object to access methods in the class using new operator(WebDriver driver = new ChromeDriver();)
//Firefox- FirefoxDriver ->methods close get
// WebDriver(is a interface). it is a grp of related methods with empty bodies. Its class(chromedrive, FF driver,...) responsibility to implement the methods declared in the interface. When class agreed to implement the interface, they must need to provide implementation/bodies to all the defined methods in interface
// check in webdriver interface for more in selenium.dev URL
//WebDriver methods + class methods (WebDriver driver = new ChromeDriver(); or Chromedriver driver = new ChromeDriver();)
// Chromedriver.exe is a 3rd party library to invoke browser from the chrome people. It is a middle man proxy btwn the selenium and browser. In webdriver.chrome.driver is a key value, here we need to give the path of the driver
		
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com");
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());
//close will close the current/original window
//quit will closes the all associated windows which is opened by selenium
driver.close();

//Firefox
//	System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver");
//		WebDriver driver1 = new FirefoxDriver();
//Microsoft Edge
//		System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");
//		WebDriver driver2 = new EdgeDriver();
//		driver.get("https://rahulshettyacademy.com");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		driver.close();
//driver.quit();

	}

}
