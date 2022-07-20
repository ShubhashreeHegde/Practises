import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions(); // ChromeOptions class will help you to set the behaviour for ur chrome browser.

		//some websites need some proxy to access. we can set project at runtime. For that we can use setCapability
		// in java there is class to handle all proxy related things. class name is proxy and create opbject for that
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); // we can set different types of proxy and need to check with security team
		options.setCapability("proxy", proxy);
		
		
		options.setAcceptInsecureCerts(true);	// using setAcceptInsecureCerts method we are telling to simply accept the insecure certifications and proceed
		
		//options.addExtensions("give the file path of extension"); //while sutomation browser wil open without any extensions, If we need to open with extension we can use this
		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriver driver = new ChromeDriver(options); // whenn we pass options chrome will come to know how to behave
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
		//blocking pop-ups which come while opening some websites with allow or block options
		ChromeOptions options1=new ChromeOptions();
		options1.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
		//When we click on some links, download will start. We can store that in given directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		
		// for firefox
		// FirefoxOptions options1 = new FirefoxOptions();
		// options1.setAcceptInsecureCerts(true);
		// EdgeOptions options2 = new EdgeOptions();

	}

}
